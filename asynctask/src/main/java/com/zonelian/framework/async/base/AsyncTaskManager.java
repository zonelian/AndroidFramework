package com.zonelian.framework.async.base;

import android.support.annotation.NonNull;

import com.zonelian.framework.async.core.Dispatcher;

/**
 * Created by kernel on 2016/10/15.
 * Email: 372786297@qq.com
 */

public class AsyncTaskManager {
    private static AsyncTaskManager sInstance;

    private Dispatcher mDispatcher;

    private AsyncTaskManager() {
        mDispatcher = new DefaultDispacher();
    }

    public static AsyncTaskManager getInstance() {
        if(sInstance == null) {
            synchronized (AsyncTaskManager.class) {
                sInstance = new AsyncTaskManager();
            }
        }
        return sInstance;
    }

    public Dispatcher getDispatcher() {
        return mDispatcher;
    }

    public void setDispatcher(@NonNull Dispatcher mDispatcher) {
        this.mDispatcher = mDispatcher;
    }

    public void submit(@NonNull AsyncTask task) {
        mDispatcher.taskDispatch(task);
    }

    protected void cancle(@NonNull AsyncTask task) {
        mDispatcher.onTaskCancle(task);
    }
}
