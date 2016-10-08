package com.zonelian.framework.base.adapter.recycler;

import android.support.annotation.LayoutRes;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kernel on 16/6/19.
 * Email: 372786297@qq.com
 */
public abstract class BaseRecyclerAdapter<M, V extends RecyclerViewHolder> extends RecyclerViewAdapter<V>{
    private List<M> mList;

    private OnContentItemClickListener mContentItemClickListener;

    public BaseRecyclerAdapter() {
        mList = new ArrayList<>();
    }

    public BaseRecyclerAdapter(List<M> list) {
        this.mList = list;
    }

    public M getItem(int position) {
        return mList.get(position);
    }

    public void setItem(int position, M object) {
        mList.set(position, object);
    }

    public void addItem(M object) {
        mList.add(object);
    }

    public void addItem(int position, M object) {
        mList.add(position, object);
    }

    public void addItemAll(List<M> list) {
        mList.addAll(list);
    }

    public void removeItem(int position) {
        mList.remove(position);
    }

    public void removeItem(M object) {
        mList.remove(object);
    }

    public void replace(List list) {
        mList.clear();
        mList.addAll(list);
    }

    public List<M> getItemAll() {
        return mList;
    }

    public void clearItem() {
        mList.clear();
    }

    public boolean contains(M object) {
        return mList.contains(object);
    }

    public boolean containsAll(List list) {
        return mList.containsAll(list);
    }

    @Override
    public int getContentItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public @LayoutRes abstract int getContentLayoutResId(int viewType);

    @Override
    public void onBindContentViewHolder(RecyclerViewHolder holder, final int position) {
        onDataBindContentView(holder, getItem(position));
        if(!holder.isCustomClick()) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mContentItemClickListener != null) {
                        mContentItemClickListener.onContentItemClick(v, position);
                    }
                }
            });
        }else {
            holder.itemView.setOnClickListener(null);
            holder.getView(holder.getCustomeClickViewId()).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mContentItemClickListener != null) {
                        mContentItemClickListener.onContentItemClick(v, position);
                    }
                }
            });
        }
    }

    public abstract void onDataBindContentView(RecyclerViewHolder holder, M item);

    public void setOnContentItemClickListener(OnContentItemClickListener listener) {
        mContentItemClickListener = listener;
    }

    public interface OnContentItemClickListener {
        public void onContentItemClick(View view, int position);
    }
}
