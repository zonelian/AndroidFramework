package com.zonelian.androidframework.server;

import android.support.annotation.NonNull;

import com.zonelian.androidframework.App;
import com.zonelian.androidframework.server.main.api.DetailInterface;
import com.zonelian.androidframework.server.main.model.DetailBean;
import com.zonelian.androidframework.server.main.model.ResultModel;
import com.zonelian.framework.base.data.remote.BaseService;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import rx.Observable;

/**
 * Created by kernel on 2016/10/25.
 * Email: 372786297@qq.com
 */

public class MainDataServer extends BaseService{

    @Override
    public OkHttpClient getOkHttpClient() {
        return App.getInstance().getRemoteDataLater().getDefaultOkHttpClient();
    }

    @NonNull
    @Override
    public String getBaseUrl() {
        return UrlManager.getInstance().getBaseUrl();
    }

    public Observable<ResultModel<DetailBean>> getDetail(String id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        return getRetrofit().create(DetailInterface.class).getDetail(params);
    }
}
