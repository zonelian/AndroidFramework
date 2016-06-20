package com.zonelian.framework.base.volley.request;

import com.android.volley.AuthFailureError;

import java.util.Map;

/**
 * Created by kernel on 16/6/14.
 * Email: 372786297@qq.com
 */
public class HttpPostRequest extends HttpRequest{

    public HttpPostRequest(String url) {
        super(Method.POST, url);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return mHttpParam != null ? mHttpParam.get() : super.getParams();
    }

    @Override
    public void deliverResult(Object data) {

    }

    public static class Build extends HttpRequest.Build {

        @Override
        public HttpPostRequest build() {
            HttpPostRequest request = new HttpPostRequest(url);
            request.mHttpHeader = headers;
            request.mHttpParam = params;
            request.mResponseParser = responseParser;
            request.mResultCallback = callback;
            return request;
        }
    }

}
