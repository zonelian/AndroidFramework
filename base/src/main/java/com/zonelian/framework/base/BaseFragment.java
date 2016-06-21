package com.zonelian.framework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kernel on 16/6/13.
 * Email: 372786297@qq.com
 */
public abstract class BaseFragment extends Fragment{
    private SparseArray<View> mChildViews;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mChildViews = new SparseArray<>();
        mView = inflater.inflate(initLaoyout(), null);
        initView();
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    public <V extends View> V getViewById(int id) {
        View view = mChildViews.get(id);
        if(view == null) {
            view = mView.findViewById(id);
            mChildViews.put(id, view);
        }
        return (V)view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbindView();
    }

    private void unbindView() {
        mChildViews.clear();
    }

    public abstract int initLaoyout();
    public abstract void initView();
    public abstract void initData();

}
