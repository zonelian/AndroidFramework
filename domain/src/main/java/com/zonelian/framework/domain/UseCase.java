package com.zonelian.framework.domain;

/**
 * Created by kernel on 2016/11/8.
 * Email: 372786297@qq.com
 */

public interface UseCase<Q extends UseCase.Request, R extends UseCase.Response> {

    public static interface Request<T> {
        T input();
    }

    public static interface Response<T> {
        T response();
    }

}
