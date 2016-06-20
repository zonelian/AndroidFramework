package com.zonelian.framework.base.okhttp;

/**
 * Created by kernel on 16/6/19.
 * Email: 372786297@qq.com
 */
public interface OkHttpResponseParser<T extends Result> {

    public T parse(String response, Class beanClass);
}
