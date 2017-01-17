package com.zonelian.framework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zonelian.framework.base.presenter.IFragmentPresenter;
import com.zonelian.framework.core.SimpleFragment;

/**
 * Created by kernel on 2016/10/13.
 * Email: 372786297@qq.com
 */

public abstract class MVPFragment<T extends IFragmentPresenter> extends SimpleFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setPresenter(createPresenter());
        super.onCreate(savedInstanceState);
        if(getPresenter() != null) {
            getPresenter().onCreate(savedInstanceState);
        }
        initPresenter();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(getPresenter() != null) {
            getPresenter().onDestory();
            setPresenter(null);
        }
    }

    public abstract T createPresenter();

    public abstract void initPresenter();

    public abstract T getPresenter();

    public abstract void setPresenter(T presenter);
}
