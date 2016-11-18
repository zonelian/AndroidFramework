package com.zonelian.framework.core.view;

import android.support.annotation.IdRes;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kernel on 16/9/5.
 * Email: 372786297@qq.com
 */
public class ViewFinderDelegate {
    private View mParent;
    private SparseArray<View> mViews;
    private boolean mIsRigisted;

    public ViewFinderDelegate() {
    }

    public void register(View parent) {
        if(mIsRigisted) {
            return;
        }
        mIsRigisted = true;
        mParent = parent;
        mViews = new SparseArray<>();
    }

    public void unregister() {
        if(mIsRigisted) {
            mIsRigisted = false;
            mViews.clear();
            mParent = null;
        }
    }

    public <V extends View> V get(@IdRes int resId) {
        View view = mViews.get(resId);
        if(view == null) {
            view = mParent.findViewById(resId);
            mViews.put(resId, view);
        }
        return (V)view;
    }

    public TextView getTextView(@IdRes int resId) {
        return (TextView)get(resId);
    }

    public Button getButton(@IdRes int resId) {
        return (Button)get(resId);
    }

    public ImageView getImageView(@IdRes int resId) {
        return (ImageView)get(resId);
    }

    public EditText getEditText(@IdRes int resId) {
        return (EditText)get(resId);
    }
}
