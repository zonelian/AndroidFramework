package com.zonelian.framework.http.core;

/**
 * Created by kernel on 16/6/19.
 * Email: 372786297@qq.com
 */
public interface HttpResponseParser<T extends Result> {

    public T parse(String response, Class beanClass);
}
