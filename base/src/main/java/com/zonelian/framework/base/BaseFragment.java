package com.zonelian.framework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kernel on 16/6/13.
 * Email: 372786297@qq.com
 */
public abstract class BaseFragment extends Fragment{
    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(initLaoyout(), null);
        initView();
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    public View findViewById(int id) {
        return mView.findViewById(id);
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
