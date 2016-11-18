package com.zonelian.framework.async.core;

/**
 * Created by kernel on 2016/10/15.
 * Email: 372786297@qq.com
 */

public interface Actions<T> extends Function {
    void action(T... inputs);
}
