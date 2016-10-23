package com.zonelian.androidframework.server;

/**
 * Created by kernel on 2016/10/23.
 * Email: 372786297@qq.com
 */

public class UrlManager {
    private static UrlManager sInstance;
    private boolean mIsDebug;

    private UrlManager() {
    }

    public static UrlManager getInstance() {
        if(sInstance == null) {
            synchronized (UrlManager.class) {
                if(sInstance == null) {
                    sInstance = new UrlManager();
                }
            }
        }
        return sInstance;
    }

    public void setDebug(boolean debug) {
        mIsDebug = debug;
    }



}
