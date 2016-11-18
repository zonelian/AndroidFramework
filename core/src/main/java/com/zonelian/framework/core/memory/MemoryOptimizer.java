package com.zonelian.framework.core.memory;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import static android.content.ComponentCallbacks2.TRIM_MEMORY_BACKGROUND;
import static android.content.ComponentCallbacks2.TRIM_MEMORY_COMPLETE;
import static android.content.ComponentCallbacks2.TRIM_MEMORY_MODERATE;
import static android.content.ComponentCallbacks2.TRIM_MEMORY_RUNNING_CRITICAL;
import static android.content.ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW;
import static android.content.ComponentCallbacks2.TRIM_MEMORY_RUNNING_MODERATE;
import static android.content.ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN;

/**
 * 内存优化器
 * Created by kernel on 2016/10/30.
 * Email: 372786297@qq.com
 */

public class MemoryOptimizer {
    private static final String TAG = "MemoryOptimizer";
    private static final int MSG_HANDLE_DETECT = 12;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_HANDLE_DETECT:
                    detect();
                    sendMessageDelayed(obtainMessage(MSG_HANDLE_DETECT), 3 * 60 * 1000);
                    break;
            }
        }
    };

    private static MemoryOptimizer sInstance;

    private MemoryOptimizer() {
    }

    public static MemoryOptimizer getInstance() {
        if(sInstance == null) {
            synchronized (MemoryOptimizer.class) {
                sInstance = new MemoryOptimizer();
            }
        }
        return sInstance;
    }

    public final void init() {
        mHandler.sendEmptyMessageDelayed(MSG_HANDLE_DETECT, 3 * 60 * 1000);
    }

    private final void detect() {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long usedMemory = totalMemory - Runtime.getRuntime().freeMemory();
        Log.d(TAG, "maxMemory:" + maxMemory);
        Log.d(TAG, "totalMemory:" + totalMemory);
        Log.d(TAG, "usedMemory:" + usedMemory);
        if(maxMemory * 0.8 <= usedMemory) {
            trimMemory();
        }
    }

    public void trimMemory() {
        Log.d(TAG, "trimMemory");
        System.gc();
        // TODO: 2016/10/30 释放、回收应用持有的内存
    }

    public void onLowMemory() {
        Log.d(TAG, "onLowMemory");
    }

    public void onTrimMemory(int level) {
        switch (level) {
            case TRIM_MEMORY_COMPLETE:
                Log.d(TAG, "trim_memory_complete");
                break;
            case TRIM_MEMORY_MODERATE:
                Log.d(TAG, "trim_memory_moderate");
                break;
            case TRIM_MEMORY_BACKGROUND:
                Log.d(TAG, "trim_memory_background");
                break;
            case TRIM_MEMORY_UI_HIDDEN:
                Log.d(TAG, "trim_memory_ui_hidden");
                break;
            case TRIM_MEMORY_RUNNING_CRITICAL:
                Log.d(TAG, "trim_memory_running_critical");
                break;
            case TRIM_MEMORY_RUNNING_LOW:
                Log.d(TAG, "trim_memory_running_low");
                break;
            case TRIM_MEMORY_RUNNING_MODERATE:
                Log.d(TAG, "trim_memory_running_moderate");
                break;
        }
        long totalMemory = Runtime.getRuntime().totalMemory();
        long usedMemory = totalMemory - Runtime.getRuntime().freeMemory();
        Log.d(TAG, "totalMemory" + totalMemory);
        Log.d(TAG, "usedMemory" + usedMemory);
    }
}
