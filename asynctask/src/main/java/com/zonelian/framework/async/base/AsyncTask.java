package com.zonelian.framework.async.base;

import android.support.annotation.NonNull;

import com.zonelian.framework.async.core.Task;
import com.zonelian.framework.async.core.TaskCompleteAction;
import com.zonelian.framework.async.core.TaskErrorAction;
import com.zonelian.framework.async.core.TaskExecutor;

import java.io.InterruptedIOException;

/**
 * Created by kernel on 2016/10/15.
 * Email: 372786297@qq.com
 */

public class AsyncTask implements Task{
    private boolean mIsCancled = false;
    private boolean mIsDone = false;
    private Request mRequest;
    protected int mMostConsumePerformance = Request.CONSUME_CPU;
    private Response mResponse;

    protected TaskExecutor mExecutor;
    protected TaskCompleteAction mCompleteAction;
    protected TaskErrorAction mErrorAction;

    public AsyncTask() {
        mRequest = new Request() {

            @Override
            public boolean isCancled() {
                return AsyncTask.this.mIsCancled;
            }

            @Override
            public boolean isDone() {
                return AsyncTask.this.mIsDone;
            }

            @Override
            public int getWhitchPerformanceConsumeMost() {
                return AsyncTask.this.mMostConsumePerformance;
            }
        };
    }

    @Override
    public Object execute(Request request) throws InterruptedException, InterruptedIOException{
        if(mExecutor != null) {
            return mExecutor.execute(request);
        }
        return null;
    }

    public void submit() {
        AsyncTaskManager.getInstance().submit(this);
    }

    @Override
    public void onDone() {
        mIsDone = true;
    }

    @Override
    public void cancle() {
        mIsCancled = true;
        AsyncTaskManager.getInstance().cancle(this);
    }

    @Override
    public boolean isCancled() {
        return mIsCancled;
    }

    @Override
    public Request getRequest() {
        return mRequest;
    }

    @Override
    public Response getResponse() {
        return mResponse;
    }

    @Override
    public void setResponse(Response response) {
        this.mResponse = response;
    }

    @Override
    public TaskCompleteAction getCompleteAction() {
        return mCompleteAction;
    }

    @Override
    public TaskErrorAction getErrorAction() {
        return mErrorAction;
    }

    public static class Builder {
        private int consumePerformance = Request.CONSUME_CPU;
        TaskExecutor executor;
        TaskCompleteAction completeAction;
        TaskErrorAction errorAction;

        public Builder consumePerformance(int type) {
            this.consumePerformance = type;
            return this;
        }

        public Builder execute(@NonNull TaskExecutor executor) {
            this.executor = executor;
            return this;
        }

        public Builder complete(TaskCompleteAction complete) {
            this.completeAction = complete;
            return this;
        }

        public Builder error(TaskErrorAction error) {
            this.errorAction = error;
            return this;
        }

        public AsyncTask build() {
            AsyncTask task = new AsyncTask();
            task.mMostConsumePerformance = this.consumePerformance;
            task.mExecutor = this.executor;
            task.mCompleteAction = this.completeAction;
            task.mErrorAction = this.errorAction;
            if(this.executor == null) {
                throw new NullPointerException("must invoke execute method");
            }
            return task;
        }
    }

    public static class DefaultResponse<T> implements Response<T> {
        private T result;

        @Override
        public T response() {
            return result;
        }

        @Override
        public void setResponse(T result) {
            this.result = result;
        }
    }
}
