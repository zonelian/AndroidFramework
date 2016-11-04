package com.zonelian.framework.async.core;

import java.util.concurrent.ExecutorService;

/**
 * Created by kernel on 2016/10/15.
 * Email: 372786297@qq.com
 */

public interface Dispatcher {
    void taskDispatch(Task task);
    void resultDispatch(Task task);
    void errorDispatch(Task task, Exception exception);
    void onTaskCancle(Task task);
    void onTaskComplete(Task task);
    void setExecutorService(ExecutorService executorService);
}
