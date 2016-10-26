package com.zonelian.androidframework.server.api;

import com.zonelian.androidframework.server.model.DetailBean;
import com.zonelian.androidframework.server.model.ResultModel;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by kernel on 2016/10/25.
 * Email: 372786297@qq.com
 */

public interface DetailInterface {

    @GET
    Observable<ResultModel<DetailBean>> getDetail(String id);
}
