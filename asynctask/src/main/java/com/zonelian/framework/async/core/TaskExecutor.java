package com.zonelian.framework.async.core;

import java.io.InterruptedIOException;

/**
 * Created by kernel on 2016/10/15.
 * Email: 372786297@qq.com
 */

public interface TaskExecutor<T> {
    T execute(Task.Request request) throws InterruptedException, InterruptedIOException;
}
