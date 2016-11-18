package com.zonelian.framework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zonelian.framework.base.presenter.IFragmentPresenter;
import com.zonelian.framework.core.BaseFragment;

/**
 * Created by kernel on 2016/10/13.
 * Email: 372786297@qq.com
 */

public abstract class MVPFragment<T extends IFragmentPresenter> extends BaseFragment {
    private T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        initPresenter(mPresenter);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter = null;
    }

    public T getPresenter() {
        return mPresenter;
    }

    public abstract T createPresenter();

    public abstract void initPresenter(T presenter);
}
