package com.zonelian.framework.base.adapter.recycler;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kernel on 16/6/19.
 * Email: 372786297@qq.com
 */
public abstract class BaseRecyclerAdapter<M> extends RecyclerViewAdapter<RecyclerViewHolder>{
    private List<M> mList;

    public BaseRecyclerAdapter() {
        mList = new ArrayList<>();
    }

    public BaseRecyclerAdapter(List<M> list) {
        this.mList = list;
    }

    public M getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getContentItemCount() {
        return mList != null ? mList.size() : 0;
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

    @Override
    public void onBindItemViewHolder(RecyclerViewHolder holder, int position) {
        onDataBindView(holder, getItem(position));
    }

    public abstract void onDataBindView(RecyclerViewHolder holder, M item);

    public static class BaseRecyclerViewHolder extends RecyclerViewHolder{

        public BaseRecyclerViewHolder(LayoutInflater layoutInflater, @LayoutRes int layoutResId) {
            super(layoutInflater, layoutResId);
        }
    }
}
