package com.zonelian.framework.base.data.remote;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by kernel on 2016/10/23.
 * Email: 372786297@qq.com
 */

public abstract class RemoteDataLayer {
//    private static RemoteDataLayer sInstance;

    private OkHttpClient mOkHttpClient;

    public RemoteDataLayer() {
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

//    public static RemoteDataLayer getInstance() {
//        if(sInstance == null) {
//            synchronized (RemoteDataLayer.class) {
//                if(sInstance == null) {
//                    sInstance = new RemoteDataLayer();
//                }
//            }
//        }
//        return sInstance;
//    }

    public OkHttpClient getDefaultOkHttpClient() {
        return mOkHttpClient;
    }
}
