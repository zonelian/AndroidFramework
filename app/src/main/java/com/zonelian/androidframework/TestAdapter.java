package com.zonelian.androidframework;

import android.view.LayoutInflater;

import com.zonelian.framework.base.adapter.recycler.BaseRecyclerAdapter;
import com.zonelian.framework.base.adapter.recycler.RecyclerViewHolder;

/**
 * Created by kernel on 16/6/21.
 * Email: 372786297@qq.com
 */
public class TestAdapter extends BaseRecyclerAdapter<String>{

    @Override
    public LayoutInflater getLayoutInflater() {
        return null;
    }

    @Override
    public int getLayoutResId(int viewType) {
        return 0;
    }

    @Override
    public void onDataBindView(RecyclerViewHolder holder, String item) {

    }
}
