package com.zonelian.androidframework.data;

import com.zonelian.androidframework.server.BaiduDataServer;
import com.zonelian.androidframework.server.MainDataServer;
import com.zonelian.framework.base.data.remote.RemoteDataLayer;

/**
 * Created by kernel on 2016/10/25.
 * Email: 372786297@qq.com
 */

public class GrobalRemoteDataLater extends RemoteDataLayer {
    private MainDataServer mMainServer;
    private BaiduDataServer mBaiduServer;

    public GrobalRemoteDataLater() {
        mMainServer = new MainDataServer();
        mBaiduServer = new BaiduDataServer();
    }

    public MainDataServer getMainServer() {
        return mMainServer;
    }

    public BaiduDataServer getBaiduServer() {
        return mBaiduServer;
    }
}
