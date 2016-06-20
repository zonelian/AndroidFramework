package com.zonelian.framework.base.adapter.recycler;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by kernel on 16/6/19.
 * Email: 372786297@qq.com
 */
public abstract class BaseRecyclerAdapter extends RecyclerViewAdapter<RecyclerViewHolder>{

    @Override
    public int getContentItemCount() {
        return 0;
    }

    @Override
    public int getContentItemViewType(int position) {
        return 0;
    }

    public @LayoutRes abstract int getLayoutResId(int viewType);

    public abstract LayoutInflater getLayoutInflater();

    @Override
    public RecyclerViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        return new BaseRecyclerViewHolder(getLayoutInflater(), getLayoutResId(viewType));
    }

    public abstract void onBindItemViewHolder(RecyclerViewHolder holder, int position);

    public static class BaseRecyclerViewHolder extends RecyclerViewHolder{

        public BaseRecyclerViewHolder(LayoutInflater layoutInflater, @LayoutRes int layoutResId) {
            super(layoutInflater, layoutResId);
        }
    }
}
