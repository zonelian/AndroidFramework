package com.zonelian.androidframework;

import com.zonelian.androidframework.component.AppComponent;
import com.zonelian.framework.base.BaseActivity;

/**
 * Created by kernel on 16/7/9.
 * Email: 372786297@qq.com
 */
public abstract class BasicActivity extends BaseActivity{

    public AppComponent getAppComponent() {
        return ((App)getApplication()).getAppComponent();
    }
}
