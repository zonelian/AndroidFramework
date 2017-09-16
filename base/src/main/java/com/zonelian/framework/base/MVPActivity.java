package com.zonelian.framework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zonelian.framework.base.presenter.IActivityPresenter;
import com.zonelian.framework.core.SimpleActivity;

/**
 * Created by kernel on 2016/10/13.
 * Email: 372786297@qq.com
 */

public abstract class MVPActivity<T extends IActivityPresenter> extends SimpleActivity {
    private T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        setPresenter(mPresenter);
        super.onCreate(savedInstanceState);
        if(mPresenter != null) {
            getPresenter().onCreate(savedInstanceState);
            initPresenter(mPresenter);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null) {
            mPresenter.onDestory();
            setPresenter(null);
        }
    }

    public abstract T createPresenter();

    public void initPresenter(T presenter) {
    }

    public T getPresenter() {
        return mPresenter;
    }

    public void setPresenter(T presenter) {
        mPresenter = presenter;
    }

}
