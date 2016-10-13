package com.zonelian.framework.mvp.extend;

import android.os.Bundle;

import com.zonelian.framework.mvp.core.MVP;

/**
 * Created by kernel on 2016/10/8.
 * Email: 372786297@qq.com
 */

public interface IActivityPresenter<T extends MVP.MVPView> extends MVP.MVPPresenter<T>{

    void onCreate(Bundle savedInstanceState);
    void onRestoreInstanceState(Bundle savedInstanceState);
    void onSaveInstanceState(Bundle outState);
    void onStart();
    void onResume();
    void onPause();
    void onStop();
    void onDestory();
}
