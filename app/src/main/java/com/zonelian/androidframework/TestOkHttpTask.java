package com.zonelian.androidframework;

import com.zonelian.framework.base.okhttp.OkResponseCallbackWrapper;
import com.zonelian.framework.mvp.usecase.UseCase;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by kernel on 16/6/19.
 * Email: 372786297@qq.com
 */
public class TestOkHttpTask implements UseCase{

    @Override
    public void cancel() {

    }

    @Override
    public void start() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.SECONDS)
                .readTimeout(10000, TimeUnit.SECONDS)
                .writeTimeout(10000, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url("http://www.baiud.com")
                .get()
                .build();

        Call call = okHttpClient.newCall(request);
        OkResponseCallbackWrapper wrapper = new OkResponseCallbackWrapper.Builder()
                .build();
        call.enqueue(wrapper.enqueue());
    }

    @Override
    public void stop() {

    }
}
