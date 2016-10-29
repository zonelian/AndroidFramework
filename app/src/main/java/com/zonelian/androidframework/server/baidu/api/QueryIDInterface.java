package com.zonelian.androidframework.server.baidu.api;

import com.zonelian.androidframework.server.baidu.model.BaiduModel;
import com.zonelian.androidframework.server.baidu.model.IDBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by kernel on 2016/10/29.
 * Email: 372786297@qq.com
 */

public interface QueryIDInterface {

    @Headers("apikey: dfa1ac2423f0be8d69ddfdc14734f22e")
    @GET("apistore/idservice/id")
    Observable<BaiduModel<IDBean>> getID(@QueryMap Map<String, String> params);
}
