package com.zonelian.androidframework.demo.base.datasource.local;

import com.zonelian.framework.data.cache.SerializeHelper;

/**
 * Created by kernel on 2016/11/9.
 * Email: 372786297@qq.com
 */

public class GrobalLocalDataLayer {
    private DefaultSharePreferences mDefaultSharePreferences;
    private SerializeHelper mSerializeHelper;


    public DefaultSharePreferences getDefaultSharePreferences() {
        if(mDefaultSharePreferences == null) {
            mDefaultSharePreferences = new DefaultSharePreferences();
        }
        return mDefaultSharePreferences;
    }

    public SerializeHelper getFileHelper() {
        if(mSerializeHelper == null) {
            mSerializeHelper = new SerializeHelper();
        }
        return mSerializeHelper;
    }

    // add DAO method and so on
}
