package com.zonelian.androidframework;

import android.app.Application;

import com.zonelian.androidframework.data.GrobalRemoteDataLater;
import com.zonelian.framework.core.memory.MemoryOptimizer;
import com.zonelian.framework.data.cache.SharePreferencesHelper;

/**
 * Created by kernel on 16/7/3.
 * Email: 372786297@qq.com
 */
public class App extends Application{
    private GrobalRemoteDataLater mRemoteDataLater;
    private SharePreferencesHelper mSharePrefHelper;
    private static App sInstance;

    public static final App getInstance(){
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MemoryOptimizer.getInstance().init();
        sInstance = this;
        mRemoteDataLater = new GrobalRemoteDataLater();
        mSharePrefHelper = new SharePreferencesHelper(sInstance, "Application");
    }

    public GrobalRemoteDataLater getRemoteDataLater() {
        return mRemoteDataLater;
    }

    public SharePreferencesHelper getSharePrefeHelper() {
        return mSharePrefHelper;
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
