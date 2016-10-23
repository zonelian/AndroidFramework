package com.zonelian.framework.core.adapter.recycler;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zonelian.framework.base.view.ViewFinderDelegate;

/**
 * Created by kernel on 16/6/19.
 * Email: 372786297@qq.com
 */
public abstract class RecyclerViewHolder extends RecyclerView.ViewHolder{
//    private SparseArray<View> childViews;
    private ViewFinderDelegate mViewFinderDelegate;
    private boolean isCustomClick = false;
    private int customeClickViewId = 0;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        mViewFinderDelegate = new ViewFinderDelegate();
        mViewFinderDelegate.register(this.itemView);
    }

    public RecyclerViewHolder(ViewGroup parent, int layoutResId) {
        this(LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false));
    }

    public boolean isCustomClick() {
        return isCustomClick;
    }

    public void setCustomClick(boolean customClick) {
        isCustomClick = customClick;
    }

    public int getCustomeClickViewId() {
        return customeClickViewId;
    }

    public void setCustomeClickViewId(int customeClickViewId) {
        this.customeClickViewId = customeClickViewId;
    }

    public <V extends View> V getView(@IdRes int viewId) {
        return mViewFinderDelegate.get(viewId);
    }

    public TextView getTextView(int id) {
        return mViewFinderDelegate.getTextView(id);
    }

    public EditText getEditText(int id) {
        return mViewFinderDelegate.getEditText(id);
    }

    public ImageView getImageView(int id) {
        return mViewFinderDelegate.getImageView(id);
    }

    public Button getButton(int id) {
        return mViewFinderDelegate.getButton(id);
    }
}
