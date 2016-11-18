package com.zonelian.framework.async.core;

/**
 * Created by kernel on 2016/10/15.
 * Email: 372786297@qq.com
 */

public interface Task extends TaskExecutor{

    public interface Request {
        public static final int CONSUME_CPU = 1;
        public static final int CONSUME_IO = 2;
        public static final int CONSUME_CUSTOME = 3;
        boolean isCancled();
        boolean isDone();
        int getWhitchPerformanceConsumeMost();
    }

    public interface Response<T> {
        T response();
        void setResponse(T result);
    }

    Request getRequest();

    Response getResponse();
    void setResponse(Response response);

    void onDone();

    void cancle();
    boolean isCancled();

    TaskCompleteAction getCompleteAction();
    TaskErrorAction getErrorAction();
}
