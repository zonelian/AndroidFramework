package com.zonelian.framework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zonelian.framework.core.BaseActivity;
import com.zonelian.framework.mvp.extend.IActivityPresenter;

/**
 * Created by kernel on 2016/10/13.
 * Email: 372786297@qq.com
 */

public abstract class MVPActivity<T extends IActivityPresenter> extends BaseActivity {
    private T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        initPresenter(mPresenter);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter = null;
    }

    public T getPresenter() {
        return mPresenter;
    }

    public abstract T createPresenter();

    public abstract void initPresenter(T presenter);
}
