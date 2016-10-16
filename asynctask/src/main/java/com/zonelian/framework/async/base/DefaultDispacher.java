package com.zonelian.framework.async.base;

import android.util.Log;

import com.zonelian.framework.async.core.Dispatcher;
import com.zonelian.framework.async.core.Task;

import java.io.InterruptedIOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by kernel on 2016/10/15.
 * Email: 372786297@qq.com
 */

public class DefaultDispacher implements Dispatcher {
    private static final String TAG = "DefaultDispacher";
    public static final int CPU_AVALABLE_COUNT = Runtime.getRuntime().availableProcessors();
    private ExecutorService mScheduledExecutorService;

    private ExecutorService mCacheExecutorService;

    private ConcurrentMap<Task, Future> mSubmiteds;

    public DefaultDispacher() {
        mScheduledExecutorService = Executors.newScheduledThreadPool(CPU_AVALABLE_COUNT);
        mCacheExecutorService = Executors.newCachedThreadPool();
        mSubmiteds = new ConcurrentHashMap<>();
        Log.d(TAG, "cpu_avalable_count:" + CPU_AVALABLE_COUNT);
    }

    @Override
    public void taskDispatch(Task task) {
        Log.d(TAG, "taskDispatch");
        if(task.isCancled() || task.getRequest().isDone()) {
            Log.d(TAG, "taskDispatch isCancled or isDone");
            return;
        }
        TaskRunner taskRunner = new TaskRunner(task);
        switch (task.getRequest().getWhitchPerformanceConsumeMost()) {
            case Task.Request.CONSUME_IO:
                mSubmiteds.put(task, mCacheExecutorService.submit(taskRunner));
                Log.d(TAG, "cache submit");
                break;
            case Task.Request.CONSUME_CPU:
            default:
                mSubmiteds.put(task, mScheduledExecutorService.submit(taskRunner));
                Log.d(TAG, "schedule submit");
                break;
        }
    }

    @Override
    public void resultDispatch(final Task task) {
        Log.d(TAG, "resultDispatch");
        if(task.isCancled() || task.getRequest().isDone()) {
            Log.d(TAG, "resultDispatch isCancled or isDone");
            return;
        }
        onTaskComplete(task);
        if(task.getCompleteAction() != null) {
            task.getCompleteAction().action(task, task.getResponse().response());
        }
    }

    @Override
    public void errorDispatch(Task task, Exception exception) {
        Log.d(TAG, "errorDispatch");
        if(task.isCancled() || task.getRequest().isDone()) {
            Log.d(TAG, "errorDispatch isCancled or isDone");
            return;
        }
        onTaskComplete(task);
        if(task.getErrorAction() != null) {
            task.getErrorAction().action(task, exception);
        }
    }

    @Override
    public void onTaskCancle(Task task) {
        Log.d(TAG, "onTaskCancle");
        if(mSubmiteds.containsKey(task)) {
            if(!mSubmiteds.get(task).isDone()) {
                mSubmiteds.get(task).cancel(true);
            }
            mSubmiteds.remove(task);
        }
    }

    @Override
    public void onTaskComplete(Task task) {
        Log.d(TAG, "onTaskComplete");
        if(mSubmiteds.containsKey(task)) {
            mSubmiteds.remove(task);
        }
    }

    private class TaskRunner implements Runnable{
        private Task task;

        public TaskRunner(Task task) {
            this.task = task;
        }

        @Override
        public void run() {
            Log.d(TAG, "TaskRunner run");
            if(task.isCancled() || task.getRequest().isDone()) {
                Log.d(TAG, "TaskRunner isCancled or isDone");
                return;
            }
            try {
                Object result = task.execute(task.getRequest());
                Task.Response response = new AsyncTask.DefaultResponse();
                if(task.isCancled()) {
                    Log.d(TAG, "Task Runner cancle");
                    return;
                }
                response.setResponse(result);
                task.setResponse(response);
                resultDispatch(task);
            }catch (InterruptedException e) {
                e.printStackTrace();
                if(task.isCancled()) {
                    Log.d(TAG, "Task Runner cancle");
                    return;
                }
                errorDispatch(task, e);

            }catch (InterruptedIOException e) {
                e.printStackTrace();
                if(task.isCancled()) {
                    Log.d(TAG, "Task Runner cancle");
                    return;
                }
                errorDispatch(task, e);

            } catch (Exception e) {
                e.printStackTrace();
                errorDispatch(task, e);
            }
        }
    }
}
