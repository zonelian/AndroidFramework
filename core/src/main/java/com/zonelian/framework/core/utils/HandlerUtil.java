package com.zonelian.framework.core.utils;

import android.os.Looper;

/**
 * Created by kernel on 2016/10/12.
 * Email: 372786297@qq.com
 */

public class HandlerUtil {

    public static void runOnMainThread(Runnable runnable) {
        new android.os.Handler(Looper.getMainLooper()).post(runnable);
    }

    public static void runOnMainThreadDelay(Runnable runnable, long millisecond) {
        new android.os.Handler(Looper.getMainLooper())
                .postDelayed(runnable, millisecond);
    }

    public static void runDelay(Runnable runnable, long millisecond) {
        new android.os.Handler().postDelayed(runnable, millisecond);
    }
}
