package com.zonelian.framework.base.okhttp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.PriorityCallComparator;
import okhttp3.internal.Util;

/**
 * Created by kernel on 16/9/18.
 * Email: 372786297@qq.com
 */
@Deprecated
public class OkPrirotyClient {

    public static OkHttpClient get() {
        ExecutorService executorService = new ThreadPoolExecutor(2, 14, 60, TimeUnit.SECONDS,
                new PriorityBlockingQueue(60, new PriorityCallComparator<Runnable>()),
                Util.threadFactory("OkHttp Dispatcher", false));
        Dispatcher dispatcher = new Dispatcher(executorService);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().dispatcher(dispatcher).build();
        return okHttpClient;
    }

}
