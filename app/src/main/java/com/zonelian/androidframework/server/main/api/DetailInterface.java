package com.zonelian.androidframework.server.main.api;

import com.zonelian.androidframework.server.main.model.DetailBean;
import com.zonelian.androidframework.server.main.model.ResultModel;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by kernel on 2016/10/25.
 * Email: 372786297@qq.com
 */

public interface DetailInterface {

    @Headers("apikey: dfa1ac2423f0be8d69ddfdc14734f22e")
    @GET("apistore/idservice/id")
    Observable<ResultModel<DetailBean>> getDetail(@QueryMap Map<String, String> params);
}
