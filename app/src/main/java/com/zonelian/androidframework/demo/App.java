package com.zonelian.androidframework.demo;

import android.app.Application;
import android.util.Log;

import com.zonelian.androidframework.demo.base.datasource.local.GrobalLocalDataLayer;
import com.zonelian.androidframework.demo.base.datasource.remote.GrobalRemoteDataLayer;
import com.zonelian.framework.core.memory.MemoryOptimizer;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by kernel on 16/7/3.
 * Email: 372786297@qq.com
 */
public class App extends Application{
    private GrobalLocalDataLayer mLocalDataLayer;
    private GrobalRemoteDataLayer mRemoteDataLayer;
    private static App sInstance;

    public static final App getInstance(){
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MemoryOptimizer.getInstance().init();
        sInstance = this;
        mLocalDataLayer = new GrobalLocalDataLayer();
        mRemoteDataLayer = new GrobalRemoteDataLayer();

        final Request request = new Request.Builder().url("http://192.168.16.114:80/inner/channel_info?channel_id=1900").get().build();
        Call call = mRemoteDataLayer.getDefaultOkHttpClient().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("OkHttp onFailure", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("OkHttp status", response.code() + "");
                Log.d("OkHttp response", response.body().string());
            }
        });
    }

    public GrobalRemoteDataLayer getRemoteDataLayer() {
        return mRemoteDataLayer;
    }

    public GrobalLocalDataLayer getLocalDataLayer() {
        return mLocalDataLayer;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        MemoryOptimizer.getInstance().onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        MemoryOptimizer.getInstance().onTrimMemory(level);
    }
}
