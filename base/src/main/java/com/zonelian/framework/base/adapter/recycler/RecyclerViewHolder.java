package com.zonelian.framework.base.adapter.recycler;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kernel on 16/6/19.
 * Email: 372786297@qq.com
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder{
    private SparseArray<View> childViews;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        childViews = new SparseArray<>();
    }

    public RecyclerViewHolder(LayoutInflater layoutInflater, @LayoutRes int layoutResId) {
        this(layoutInflater.inflate(layoutResId, null));
    }

    public View getView(@IdRes int viewId) {
        if(childViews.get(viewId) != null) {
            return childViews.get(viewId);
        }
        View child = itemView.findViewById(viewId);
        childViews.put(viewId, child);
        return child;
    }

    public TextView getTextView(@IdRes int viewId) {
        return (TextView)getView(viewId);
    }

    public EditText getEditText(@IdRes int viewId) {
        return (EditText)getView(viewId);
    }

    public ImageView getImageView(@IdRes int viewId) {
        return (ImageView)getView(viewId);
    }

    public Button getButton(@IdRes int viewId) {
        return (Button)getView(viewId);
    }

}
