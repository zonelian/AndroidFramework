package com.zonelian.framework.core;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zonelian.framework.core.view.ViewFinderDelegate;

import static android.widget.Toast.makeText;


/**
 * Created by kernel on 16/6/13.
 * Email: 372786297@qq.com
 */
public abstract class SimpleActivity extends FragmentActivity{
    private ViewFinderDelegate mViewFinderDelegete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewFinderDelegete = new ViewFinderDelegate();
        setContentView(initLayout());
        mViewFinderDelegete.register(getWindow().getDecorView());
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewFinderDelegete.unregister();
        mViewFinderDelegete = null;
    }

    public final  <V extends View> V getViewById(@IdRes int id) {
        return mViewFinderDelegete.get(id);
    }

    public TextView getTextViewById(@IdRes int id) {
        return mViewFinderDelegete.getTextView(id);
    }

    public EditText getEditTextById(@IdRes int id) {
        return mViewFinderDelegete.getEditText(id);
    }

    public ImageView getImageViewById(@IdRes int id) {
        return mViewFinderDelegete.getImageView(id);
    }

    public Button getButtonById(@IdRes int id) {
        return mViewFinderDelegete.getButton(id);
    }

    public final void setOnClickListener(View.OnClickListener listener, @IdRes int... viewIds) {
        for(int viewId : viewIds) {
            getViewById(viewId).setOnClickListener(listener);
        }
    }

    public void showToast(String msg) {
        makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void showToast(int resId) {
        makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    public void showCenterToast(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void showCenterToast(int resId) {
        Toast toast = Toast.makeText(this, resId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public abstract int initLayout();
    public abstract void initView();
    public abstract void initData();

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.d("MemoryOptimizer", getClass().getSimpleName() + "onTrimMemory:" + level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d("MemoryOptimizer", getClass().getSimpleName() + "onLowMemory");
    }
}
