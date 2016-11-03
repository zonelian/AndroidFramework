package com.zonelian.androidframework;

import com.zonelian.framework.base.MVPActivity;

/**
 * Created by kernel on 2016/10/30.
 * Email: 372786297@qq.com
 */

public class FirstActivity extends MVPActivity<FirstPresenter> implements FirstView{

    @Override
    public FirstPresenter createPresenter() {
        return new FirstPresenter();
    }

    @Override
    public void initPresenter(FirstPresenter presenter) {
        presenter.setView(this);
    }

    @Override
    public int initLayout() {
        return R.layout.activity_first;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
