package com.zonelian.androidframework.demo.base.app;

import android.support.annotation.StringRes;

import com.zonelian.framework.mvp.core.MVP;

/**
 * Created by kernel on 2016/11/17.
 * Email: 372786297@qq.com
 */

public interface BaseAppView extends MVP.MVPView {
    void showToast(String msg);
    void showToast(@StringRes int resId);

    void showCenterToast(String msg);
    void showCenterToast(@StringRes int resId);
}
