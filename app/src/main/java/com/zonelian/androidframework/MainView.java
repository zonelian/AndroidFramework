package com.zonelian.androidframework;

import android.support.annotation.StringRes;

import com.zonelian.framework.mvp.core.MVP;

/**
 * Created by kernel on 2016/10/22.
 * Email: 372786297@qq.com
 */

public interface MainView extends MVP.MVPView {
    void showToast(@StringRes int resId);
    void showToast(String msg);

    void showData(String name, int age);
}
