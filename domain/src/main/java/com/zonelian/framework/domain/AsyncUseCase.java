package com.zonelian.framework.domain;

/**
 * Created by kernel on 2016/11/8.
 * Email: 372786297@qq.com
 */

public interface AsyncUseCase <Q extends UseCase.Request, R extends UseCase.Response> extends UseCase<Q, R>{

    public static interface Callback<R> {
        void onComplete(R response);
        void onError(Exception e);
    }

    void execute(Request request, Callback<R> callback);

    void cancel();
}
