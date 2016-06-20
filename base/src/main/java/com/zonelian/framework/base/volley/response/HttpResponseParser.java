package com.zonelian.framework.base.volley.response;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;

/**
 * Created by kernel on 16/6/13.
 * Email: 372786297@qq.com
 */
public interface HttpResponseParser {

    public Response parse(NetworkResponse response, Class beanClass);
}
