package com.zonelian.androidframework.server;

import android.support.annotation.NonNull;

import com.zonelian.androidframework.App;
import com.zonelian.androidframework.server.baidu.api.QueryIDInterface;
import com.zonelian.androidframework.server.baidu.model.BaiduModel;
import com.zonelian.androidframework.server.baidu.model.IDBean;
import com.zonelian.framework.base.remote.BaseAndroidService;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import rx.Observable;

/**
 * Created by kernel on 2016/10/29.
 * Email: 372786297@qq.com
 */

public class BaiduDataServer extends BaseAndroidService {

    @Override
    public OkHttpClient getOkHttpClient() {
        return App.getInstance().getRemoteDataLater().getDefaultOkHttpClient();
    }

    @NonNull
    @Override
    public String getBaseUrl() {
        return UrlManager.getInstance().getBaseUrl();
    }

    public Observable<BaiduModel<IDBean>> getID(String id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        return getRetrofit().create(QueryIDInterface.class).getID(params);
    }
}
