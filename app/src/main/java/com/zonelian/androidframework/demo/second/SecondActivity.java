package com.zonelian.androidframework.demo.second;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.zonelian.androidframework.demo.R;
import com.zonelian.framework.base.MVPActivity;

/**
 * Created by kernel on 2016/11/17.
 * Email: 372786297@qq.com
 */

public class SecondActivity extends MVPActivity<SecondPresenter> implements SecondView{
    private TextView mTvSex;
    private TextView mTvBirthday;
    private TextView mTvAddress;

    @Override
    public SecondPresenter createPresenter() {
        return new SecondPresenter();
    }

    @Override
    public void initPresenter(SecondPresenter presenter) {
        presenter.setView(this);
    }

    @Override
    public int initLayout() {
        return R.layout.activity_second;
    }

    @Override
    public void initView() {
        mTvSex = getViewById(R.id.tvSex);
        mTvBirthday = getViewById(R.id.tvBirthday);
        mTvAddress = getViewById(R.id.tvAddress);
    }

    @Override
    public void initData() {
        getPresenter().initData();
    }

    @Override
    public void showData(String sex, String birthday, String address) {
        mTvSex.setText(sex);
        mTvBirthday.setText(birthday);
        mTvAddress.setText(address);
    }

    public static void launch(Context context) {
        context.startActivity(new Intent(context, SecondActivity.class));
    }
}
