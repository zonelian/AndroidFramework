package com.zonelian.framework.http.okhttp;

import com.zonelian.framework.http.core.Result;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by kernel on 16/6/19.
 * Email: 372786297@qq.com
 */
public interface OkHttpResultCallback<T extends Result> {
    public void onResultSuccess(Call call, Response response, T result);
    public void onResultCanceled(Call call);
    public void onResultTimeout(Call call);
    public void onResultFaild(Call call, Response response, int code, String msg);
    public void onResultError(Call call, Exception e);
}
