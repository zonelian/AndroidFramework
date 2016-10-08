package com.zonelian.framework.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zonelian.framework.base.view.ViewFinderDelegate;

/**
 * Created by kernel on 16/6/13.
 * Email: 372786297@qq.com
 */
public abstract class BaseActivity extends FragmentActivity{
    private ViewFinderDelegate mViewFinderDeleage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewFinderDeleage = new ViewFinderDelegate();
        setContentView(initLayout());
        mViewFinderDeleage.register(getWindow().getDecorView());
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewFinderDeleage.unregister();
    }

    public final  <V extends View> V getViewById(@IdRes int id) {
        return mViewFinderDeleage.get(id);
    }

    public TextView getTextViewById(@IdRes int id) {
        return mViewFinderDeleage.getTextView(id);
    }

    public EditText getEditTextById(@IdRes int id) {
        return mViewFinderDeleage.getEditText(id);
    }

    public ImageView getImageViewById(@IdRes int id) {
        return mViewFinderDeleage.getImageView(id);
    }

    public Button getButtonById(@IdRes int id) {
        return mViewFinderDeleage.getButton(id);
    }

    public final void setOnClickListener(View.OnClickListener listener, @IdRes int... viewIds) {
        for(int viewId : viewIds) {
            getViewById(viewId).setOnClickListener(listener);
        }
    }

    public abstract int initLayout();
    public abstract void initView();
    public abstract void initData();
}
