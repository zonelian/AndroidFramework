package com.zonelian.framework.base.data.remote;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by kernel on 2016/10/23.
 * Email: 372786297@qq.com
 */

public abstract class BaseService {
    private Retrofit mRetrofit;

    public OkHttpClient getOkHttpClient() {
        return RemoteDataLayer.getInstance().getDefaultOkHttpClient();
    }

    public Retrofit getRetrofit() {
        if(mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .client(getOkHttpClient())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(getBaseUrl())
                    .build();
        }
        return mRetrofit;
    }

    public abstract @NonNull String getBaseUrl();
}
