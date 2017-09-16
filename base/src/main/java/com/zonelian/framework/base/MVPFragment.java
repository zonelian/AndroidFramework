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
    private T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        setPresenter(mPresenter);
        super.onCreate(savedInstanceState);
        if(mPresenter != null) {
            mPresenter.onCreate(savedInstanceState);
            initPresenter(mPresenter);
        }
    }

    @Override
    public void onDestroy() {
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
