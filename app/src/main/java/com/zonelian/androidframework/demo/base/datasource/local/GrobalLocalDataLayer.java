package com.zonelian.androidframework.demo.base.datasource.local;

import com.zonelian.androidframework.demo.App;
import com.zonelian.androidframework.demo.base.datasource.local.db.DaoMaster;
import com.zonelian.androidframework.demo.base.datasource.local.db.UserDao;
import com.zonelian.framework.data.cache.SerializeHelper;

/**
 * Created by kernel on 2016/11/9.
 * Email: 372786297@qq.com
 */

public class GrobalLocalDataLayer {
    private DefaultSharePreferences mDefaultSharePreferences;
    private SerializeHelper mSerializeHelper;
    private UserDao mUserDao;

    private DaoMaster.DevOpenHelper mDaoOpenHelper;
    private DaoMaster mDaoMaster;

    public GrobalLocalDataLayer() {
        mDaoOpenHelper = new DaoMaster.DevOpenHelper(App.getInstance());
        mDaoMaster = new DaoMaster(mDaoOpenHelper.getWritableDatabase());
    }

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

    public DaoMaster getDaoMaster() {
        return mDaoMaster;
    }

    public UserDao getUserDao() {
        if(mUserDao == null) {
            mUserDao = mDaoMaster.newSession().getUserDao();
        }
        return mUserDao;
    }
}
