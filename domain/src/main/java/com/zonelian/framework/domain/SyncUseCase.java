package com.zonelian.framework.domain;

/**
 * Created by kernel on 2016/11/8.
 * Email: 372786297@qq.com
 */

public interface SyncUseCase<Q extends UseCase.Request, R extends UseCase.Response> extends UseCase<Q, R>{

    R execute(Q request);
}
