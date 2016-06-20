package com.zonelian.androidframework;

import com.android.volley.RequestQueue;
import com.zonelian.framework.base.volley.HttpRequestCallback;
import com.zonelian.framework.base.volley.request.HttpGetRequest;
import com.zonelian.framework.base.volley.response.HttpResponseGsonParser;
import com.zonelian.framework.mvp.usecase.UseCase;

/**
 * Created by kernel on 16/6/14.
 * Email: 372786297@qq.com
 */
public class TestVolleyTask implements UseCase{
    RequestQueue mRequestQueue;
    HttpGetRequest mRequest;
    HttpRequestCallback mResultCallback;

    public TestVolleyTask(RequestQueue mRequestQueue, HttpRequestCallback callback) {
        this.mRequestQueue = mRequestQueue;
        this.mResultCallback = callback;
    }

    @Override
    public void start() {
        mRequest = (HttpGetRequest)new HttpGetRequest.Build()
                .setBeanClass(null)
                .setResponseParser(new HttpResponseGsonParser())
                .setCallback(mResultCallback)
                .setUrl("")
                .setHeaders(null)
                .setParams(null)
                .build();
        mRequestQueue.add(mRequest);
    }

    @Override
    public void stop() {
        mRequestQueue.stop();
    }

    @Override
    public void cancel() {
        mRequest.cancel();
    }
}
