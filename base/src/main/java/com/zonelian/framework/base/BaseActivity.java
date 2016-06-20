package com.zonelian.framework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kernel on 16/6/13.
 * Email: 372786297@qq.com
 */
public abstract class BaseActivity extends FragmentActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLaoyout());
        initView();
        initData();
    }

    public TextView findTextViewById(int id) {
        return (TextView)findViewById(id);
    }

    public EditText getEditTextById(int id) {
        return (EditText)findViewById(id);
    }

    public Button findButtonById(int id) {
        return (Button)findViewById(id);
    }

    public ImageView findImageViewById(int id) {
        return (ImageView)findViewById(id);
    }

    public abstract int initLaoyout();
    public abstract void initView();
    public abstract void initData();
}
