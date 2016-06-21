package com.zonelian.androidframework;

import com.zonelian.framework.base.okhttp.OkResponseCallbackWrapper;
import com.zonelian.framework.mvp.usecase.UseCase;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;

/**
 * Created by kernel on 16/6/19.
 * Email: 372786297@qq.com
 */
public class TestOkHttpTask implements UseCase{
    private Callback mCallback;
    private Request mRequest;
    private Response mResponse;

    @Override
    public void execute(Request request) {
        mRequest = request;
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.SECONDS)
                .readTimeout(10000, TimeUnit.SECONDS)
                .writeTimeout(10000, TimeUnit.SECONDS)
                .build();

        okhttp3.Request okRequest = new okhttp3.Request.Builder()
                .url("http://www.baiud.com")
                .get()
                .build();

        Call call = okHttpClient.newCall(okRequest);
        OkResponseCallbackWrapper wrapper = new OkResponseCallbackWrapper.Builder()
                .build();
        call.enqueue(wrapper.enqueue());
    }

    @Override
    public Request getRequest() {
        return mRequest;
    }

    @Override
    public Response getResponse() {
        return mResponse;
    }

    @Override
    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    @Override
    public Callback getCallback() {
        return mCallback;
    }
}
