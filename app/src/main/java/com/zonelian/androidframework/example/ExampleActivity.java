package com.zonelian.androidframework.example;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.zonelian.androidframework.BasicActivity;
import com.zonelian.androidframework.R;

/**
 * Created by kernel on 16/7/9.
 * Email: 372786297@qq.com
 */
public class ExampleActivity extends BasicActivity implements ExampleView{
//    @Inject ExamplePresenter mPresenter;

    @Override
    public int initLayout() {
        return R.layout.activity_test;
    }

    @Override
    public void initView() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
//        initInject();
//        mPresenter.onCreate(savedInstanceState);
//        mPresenter.getRepository().put("key", "value");
    }

//    private void initInject() {
//        DaggerExamplePresenterComponent.builder()
//                .examplePresenterModule(new ExamplePresenterModule(this))
//                .exampleRepositoryComponent(DaggerExampleRepositoryComponent.builder().build())
//                .build()
//                .inject(this);
//    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        mPresenter.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
//        mPresenter.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        mPresenter.onRestoreInstanceState(outState);
    }

    @Override
    public void onDestory() {
//        mPresenter.onDestory();
    }

    @Override
    public void initData() {
    }
}
