package com.zonelian.androidframework.demo.second.remote;

import android.support.annotation.NonNull;

import com.zonelian.androidframework.demo.App;
import com.zonelian.androidframework.demo.base.datasource.remote.UrlManager;
import com.zonelian.androidframework.demo.second.remote.baidu.api.QueryIDInterface;
import com.zonelian.androidframework.demo.second.remote.baidu.model.BaiduModel;
import com.zonelian.androidframework.demo.second.remote.baidu.model.IDBean;
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
        return App.getInstance().getRemoteDataLayer().getDefaultOkHttpClient();
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
