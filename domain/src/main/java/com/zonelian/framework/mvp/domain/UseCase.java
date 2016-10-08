package com.zonelian.framework.mvp.domain;

/**
 * 业务逻辑
 * Created by kernel on 16/6/13.
 * Email: 372786297@qq.com
 */
public interface UseCase<Q extends UseCase.Request, R extends UseCase.Response> {

    public Q getRequest();

    public R getResponse();

    public void setCallback(Callback callback);

    public Callback getCallback();

    public void execute(Q request);

    public  interface Request {
    }

    public  interface Response {
    }

    public  interface Callback<T> {
        public interface FaildMessage {
            public int getCode();
            public String getMessage();
        }

        public void onSuccess(T response);
        public void onFaild(FaildMessage message);
        public void onError(Exception e);
    }
}
