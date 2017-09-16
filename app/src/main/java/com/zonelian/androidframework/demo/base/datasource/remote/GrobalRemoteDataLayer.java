package com.zonelian.androidframework.demo.base.datasource.remote;

import com.zonelian.androidframework.demo.second.remote.BaiduDataServer;
import com.zonelian.framework.base.remote.RemoteDataLayer;

/**
 * Created by kernel on 2016/10/25.
 * Email: 372786297@qq.com
 */

public class GrobalRemoteDataLayer extends RemoteDataLayer {
    private BaiduDataServer mBaiduServer;

    public GrobalRemoteDataLayer() {
        mBaiduServer = new BaiduDataServer();
    }

    public BaiduDataServer getBaiduServer() {
        return mBaiduServer;
    }
}
