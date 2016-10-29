package com.zonelian.framework.base.data.remote;

import android.support.annotation.NonNull;

import com.zonelian.framework.base.rx.RxHttpUtil;
import com.zonelian.framework.core.http.UrlBuilder;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by kernel on 2016/10/23.
 * Email: 372786297@qq.com
 */

public abstract class BaseService {
    private Retrofit mRetrofit;
    private UrlBuilder mUrlBuilder;

    public BaseService() {
        mUrlBuilder = new UrlBuilder();
    }

    public abstract OkHttpClient getOkHttpClient();

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

    public <T> Subscription subscribe(Observable source, Action1<T> onNext, Action1<Throwable> onError,
                                      Action0 onTimeout) {
        return RxHttpUtil.subscribeOn(source, onNext, onError, onTimeout, 30, TimeUnit.SECONDS, true);
    }

    public <T> Subscription subscribe(Observable source, Action1<T> onNext, Action0 onComplete,
                                      Action1<Throwable> onError, Action0 onTimeout) {
        return RxHttpUtil.subscribeOn(source, onNext, onComplete, onError, onTimeout, 30, TimeUnit.SECONDS, true);
    }

    public abstract @NonNull String getBaseUrl();

    public String buildUrl(String baseUrl, Map<String, String> params) {
        if(baseUrl != null) {
            mUrlBuilder.setUrl(baseUrl);
        }
        if(params != null && params.keySet().size() > 0) {
            for(String key : params.keySet()) {
                mUrlBuilder.addParam(key, params.get(key));
            }
        }
        return mUrlBuilder.build();
    }
}
