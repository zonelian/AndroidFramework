package com.zonelian.framework.http.core;

/**
 * Created by kernel on 16/6/19.
 * Email: 372786297@qq.com
 */
public interface Result<T> {
    public int getCode();
    public String getMsg();
    public boolean isOk();
    public T getData();
}
