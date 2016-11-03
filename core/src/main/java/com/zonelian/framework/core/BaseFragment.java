package com.zonelian.framework.core;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public abstract class BaseFragment extends Fragment{
    private View mView;
    private ViewFinderDelegate mViewFinderDelegete;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(initLayout(), null);
        mViewFinderDelegete = new ViewFinderDelegate();
        mViewFinderDelegete.register(mView);
        initView();
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mViewFinderDelegete.unregister();
        mViewFinderDelegete = null;
        mView = null;
    }

    public void showToast(String msg) {
        if(getActivity() == null) {
            return;
        }
        makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    public void showToast(int resId) {
        if(getActivity() == null) {
            return;
        }
        makeText(getActivity(), resId, Toast.LENGTH_SHORT).show();
    }

    public void showCenterToast(String msg) {
        if(getActivity() == null) {
            return;
        }
        Toast toast = Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void showCenterToast(int resId) {
        if(getActivity() == null) {
            return;
        }
        Toast toast = Toast.makeText(getActivity(), resId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public abstract int initLayout();
    public abstract void initView();
    public abstract void initData();


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d("MemoryOptimizer", getClass().getSimpleName() + "onLowMemory");
    }
}
