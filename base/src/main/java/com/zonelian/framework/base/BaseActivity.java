package com.zonelian.framework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by kernel on 16/6/13.
 * Email: 372786297@qq.com
 */
public abstract class BaseActivity extends FragmentActivity{
    private SparseArray<View> mChildViews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mChildViews = new SparseArray<>();
        setContentView(initLaoyout());
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindView();
    }

    public <V extends View> V getViewById(int id) {
        View view = mChildViews.get(id);
        if(view == null) {
            view = findViewById(id);
            mChildViews.put(id, view);
        }
        return (V)view;
    }

    private void unbindView() {
        mChildViews.clear();
    }

    public abstract int initLaoyout();
    public abstract void initView();
    public abstract void initData();
}
