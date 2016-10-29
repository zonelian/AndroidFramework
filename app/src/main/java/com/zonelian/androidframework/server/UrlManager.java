package com.zonelian.androidframework.server;

/**
 * Created by kernel on 2016/10/23.
 * Email: 372786297@qq.com
 */

public class UrlManager {
    private static UrlManager sInstance;
    private boolean mIsDebug;

    private static final String BASE_DOMAIN_RELEASE = "apis.baidu.com";
    private static final String BASE_DOMAIN_DEBUG = "test.com";

    private static String sBaseUrl = "http://" + BASE_DOMAIN_RELEASE;

    private UrlManager() {
        initUrl();
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
        initUrl();
    }

    private void initUrl() {
        if(mIsDebug) {
            sBaseUrl = "http://" + BASE_DOMAIN_DEBUG;
        }else {
            sBaseUrl = "http://" + BASE_DOMAIN_RELEASE;
        }
    }

    public String getBaseUrl() {
        return sBaseUrl;
    }

    public String getListUrl() {
        return sBaseUrl + "/get_list";
    }

    public String getDetailUrl() {
        return sBaseUrl + "/get_detail";
    }
}
