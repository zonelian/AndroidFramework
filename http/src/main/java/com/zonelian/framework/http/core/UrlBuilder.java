package com.zonelian.framework.http.core;

/**
 * Created by kernel on 16/6/28.
 * Email: 372786297@qq.com
 */
public class UrlBuilder {
    private StringBuilder result;
    private boolean isFirstParam = true;

    public UrlBuilder() {
        result = new StringBuilder();
    }

    public UrlBuilder setUrl(String url) {
        result.append(url);
        return this;
    }

    public UrlBuilder addParam(String key, String value) {
        if(isFirstParam) {
            result.append("?");
            result.append(key);
            result.append("=");
            result.append(value);
            isFirstParam = false;
        }else {
            result.append("&");
            result.append(key);
            result.append("=");
            result.append(value);
        }
        return this;
    }

    public String build() {
        return result.toString();
    }
}
