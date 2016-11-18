package com.zonelian.framework.http.okhttp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zonelian.framework.http.core.HttpResponseParser;
import com.zonelian.framework.http.core.Result;

;

/**
 * Created by kernel on 16/7/3.
 * Email: 372786297@qq.com
 */
public class HttpResponseGsonParser implements HttpResponseParser<Result> {

    @Override
    public Result parse(String response, Class beanClass) {
        Gson gson = new GsonBuilder().create();
        return (Result) gson.fromJson(response, beanClass);
    }
}
