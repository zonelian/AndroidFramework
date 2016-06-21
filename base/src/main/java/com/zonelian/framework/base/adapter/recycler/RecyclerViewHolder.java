package com.zonelian.framework.base.adapter.recycler;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;

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

    public <V extends View> V getView(@IdRes int viewId) {
        if(childViews.get(viewId) != null) {
            return (V)childViews.get(viewId);
        }
        View child = itemView.findViewById(viewId);
        childViews.put(viewId, child);
        return (V)child;
    }
}
