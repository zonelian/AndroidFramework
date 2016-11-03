package com.zonelian.androidframework.data;

import com.zonelian.androidframework.server.BaiduDataServer;
import com.zonelian.framework.http.remote.RemoteDataLayer;

/**
 * Created by kernel on 2016/10/25.
 * Email: 372786297@qq.com
 */

public class GrobalRemoteDataLater extends RemoteDataLayer {
    private BaiduDataServer mBaiduServer;

    public GrobalRemoteDataLater() {
        mBaiduServer = new BaiduDataServer();
    }

    public BaiduDataServer getBaiduServer() {
        return mBaiduServer;
    }
}
