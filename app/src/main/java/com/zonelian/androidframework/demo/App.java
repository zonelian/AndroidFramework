package com.zonelian.androidframework.demo;

import android.app.Application;

import com.zonelian.androidframework.demo.base.datasource.local.GrobalLocalDataLayer;
import com.zonelian.androidframework.demo.base.datasource.remote.GrobalRemoteDataLayer;
import com.zonelian.framework.core.memory.MemoryOptimizer;

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
