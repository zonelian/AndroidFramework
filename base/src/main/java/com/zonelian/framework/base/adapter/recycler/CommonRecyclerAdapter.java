package com.zonelian.framework.base.adapter.recycler;

import android.view.ViewGroup;

/**
 * Created by kernel on 16/8/29.
 * Email: 372786297@qq.com
 */
public class CommonRecyclerAdapter<M> extends BaseRecyclerAdapter<M, CommonRecyclerViewHolder>{
    private int mLayoutResIdDefault;

    public CommonRecyclerAdapter(int layoutResId) {
        super();
        mLayoutResIdDefault = layoutResId;
    }

    @Override
    public int getContentLayoutResId(int viewType) {
        return mLayoutResIdDefault;
    }

    @Override
    public int getContentViewType(int position) {
        return 0;
    }

    @Override
    public CommonRecyclerViewHolder onCreateContentViewHolder(ViewGroup parent, int viewType) {
        return new CommonRecyclerViewHolder(parent, getContentLayoutResId(viewType));
    }

    @Override
    public void onDataBindContentView(RecyclerViewHolder holder, M item) {

    }
}
