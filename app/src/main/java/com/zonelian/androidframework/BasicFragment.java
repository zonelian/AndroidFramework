package com.zonelian.androidframework;

import com.zonelian.androidframework.component.AppComponent;
import com.zonelian.framework.base.BaseFragment;

/**
 * Created by kernel on 16/7/9.
 * Email: 372786297@qq.com
 */
public abstract class BasicFragment extends BaseFragment{

    public AppComponent getAppComponent() {
        return ((App)getActivity().getApplication()).getAppComponent();
    }
}
