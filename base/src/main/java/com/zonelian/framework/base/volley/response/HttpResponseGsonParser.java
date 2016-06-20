package com.zonelian.framework.base.volley.response;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 使用Gson解析json数据的解析器
 * Created by kernel on 16/6/14.
 * Email: 372786297@qq.com
 */
public class HttpResponseGsonParser implements HttpResponseParser{
    Gson mGon = null;

    @Override
    public Response parse(NetworkResponse response, Class beanClass) {
        try {
            if(mGon == null) {
                mGon = new GsonBuilder().create();
            }
            String json = new String(response.data);
            Object obj = mGon.fromJson(json, beanClass);
            Cache.Entry cache = new Cache.Entry();
            cache.data = response.data;
            cache.responseHeaders = response.headers;
            return Response.success(obj, cache);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return Response.error(new ResponseParseError());
    }
}
