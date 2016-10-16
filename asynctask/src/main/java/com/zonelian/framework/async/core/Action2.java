package com.zonelian.framework.async.core;

/**
 * Created by kernel on 2016/10/15.
 * Email: 372786297@qq.com
 */

public interface Action2<T> extends Function {
    void action(T input1, T input2);
}
