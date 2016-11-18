package com.zonelian.androidframework.demo.main;

import android.support.annotation.StringRes;
import android.view.View;
import android.widget.Toast;

import com.zonelian.androidframework.demo.R;
import com.zonelian.androidframework.demo.first.FirstActivity;
import com.zonelian.androidframework.demo.second.SecondActivity;
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
        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnFirst:
                        FirstActivity.launch(MainActivity.this);
                        break;
                    case R.id.btnSecond:
                        SecondActivity.launch(MainActivity.this);
                        break;
                }
            }
        }, R.id.btnFirst, R.id.btnSecond);
    }

    @Override
    public void initData() {
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showToast(@StringRes int resId) {

    }
}
