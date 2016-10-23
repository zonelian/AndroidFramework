package com.zonelian.androidframework;

import android.support.annotation.StringRes;

import com.zonelian.framework.base.MVPActivity;

/**
 * Created by kernel on 2016/10/8.
 * Email: 372786297@qq.com
 */

public class MainActivity extends MVPActivity<MainPresenter> implements MainView{

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void initPresenter(MainPresenter presenter) {
        presenter.setView(this);
    }

    @Override
    public int initLayout() {
        return 0;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showToast(@StringRes int resId) {

    }
}
