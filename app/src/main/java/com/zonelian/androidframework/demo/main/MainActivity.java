package com.zonelian.androidframework.demo.main;

import android.support.annotation.StringRes;
import android.view.View;
import android.widget.Toast;

import com.zonelian.androidframework.demo.R;
import com.zonelian.framework.base.MVPActivity;

/**
 * Created by kernel on 2016/10/8.
 * Email: 372786297@qq.com
 */

public class MainActivity extends MVPActivity<MainPresenter> implements MainView {

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
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        getTextViewById(R.id.tvName).setText("12222222");
        getTextViewById(R.id.tvAge).setText("dkjalfkdjalk");
        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.tvName:
                        break;
                    case R.id.tvAge:
                        break;
                }
            }
        }, R.id.tvName, R.id.tvAge);
    }

    @Override
    public void initData() {
        getPresenter().initData();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showToast(@StringRes int resId) {

    }

    @Override
    public void showData(String name, int age) {
        getTextViewById(R.id.tvName).setText(name);
        getTextViewById(R.id.tvAge).setText("" + age);
    }
}
