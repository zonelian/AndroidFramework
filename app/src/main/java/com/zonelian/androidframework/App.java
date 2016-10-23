package com.zonelian.androidframework;

import android.app.Application;
import android.content.SharedPreferences;

import com.zonelian.androidframework.server.RemoteDataLayer;

/**
 * Created by kernel on 16/7/3.
 * Email: 372786297@qq.com
 */
public class App extends Application{
    private SharedPreferences mSharePreferencesGlobal;
    private RemoteDataLayer mRemoteDataLater;
    private static App sInstance;

    public static final App getInstance(){
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    private void test() {
    }

    public SharedPreferences getSharedPreferences() {
        if(mSharePreferencesGlobal == null) {
            mSharePreferencesGlobal = getSharedPreferences("Application", MODE_PRIVATE);
        }
        return mSharePreferencesGlobal;
    }

    public SharedPreferences getSharePreferences(String name) {
        return getSharedPreferences(name, MODE_PRIVATE);
    }
}
