package com.zonelian.framework.base.volley;

import com.android.volley.VolleyError;

/**
 * Created by kernel on 16/6/13.
 * Email: 372786297@qq.com
 */
public interface HttpRequestCallback<M> {

    public void onSuccess(M data);
    public void onFaild(M data);
    public void onError(VolleyError error);
    public void onTimeout();
}
