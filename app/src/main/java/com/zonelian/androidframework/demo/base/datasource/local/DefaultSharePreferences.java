package com.zonelian.androidframework.demo.base.datasource.local;

import com.zonelian.androidframework.demo.App;
import com.zonelian.framework.data.cache.SharePreferencesHelper;

/**
 * Created by kernel on 2016/11/9.
 * Email: 372786297@qq.com
 *
 */
public class DefaultSharePreferences {
    private SharePreferencesHelper mHelper;

    public DefaultSharePreferences() {
        mHelper = new SharePreferencesHelper(App.getInstance());
    }

    public SharePreferencesHelper getHelper() {
        return mHelper;
    }
}
