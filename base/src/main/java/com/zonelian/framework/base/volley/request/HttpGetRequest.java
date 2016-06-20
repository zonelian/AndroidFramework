package com.zonelian.framework.base.volley.request;

import com.zonelian.framework.base.volley.HttpParam;

/**
 * Created by kernel on 16/6/14.
 * Email: 372786297@qq.com
 */
public class HttpGetRequest extends HttpRequest {

    public HttpGetRequest(String url) {
        super(Method.GET, url);
    }

    @Override
    public void deliverResult(Object data) {

    }

    public static class Build extends HttpRequest.Build {

        @Override
        public HttpGetRequest build() {
            HttpGetRequest request = new HttpGetRequest(wrapUrl(url, params));
            request.mHttpHeader = headers;
            request.mHttpParam = params;
            request.mResponseParser = responseParser;
            request.mResultCallback = callback;
            return request;
        }
    }

    public static String wrapUrl(String url, HttpParam params) {
        StringBuilder result = new StringBuilder(url);
        if(params != null && params.get().keySet().size() > 0) {
            boolean isFirst = true;
            for(String key : params.get().keySet()) {
                if( !isFirst) {
                    result.append("&");
                    result.append(key);
                    result.append("=");
                    result.append(params.get(key));
                }else {
                    result.append("?");
                    result.append(key);
                    result.append("=");
                    result.append(params.get(key));
                    isFirst = false;
                }
            }
        }
        return result.toString();
    }

}
