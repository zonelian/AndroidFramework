package com.zonelian.framework.base.adapter.recycler;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kernel on 16/6/19.
 * Email: 372786297@qq.com
 */
public abstract class RecyclerViewAdapter<V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private SparseArray<ExtraItemView> mHeaders;
    private SparseArray<ExtraItemView> mFooters;
    private int mHeaderCount = 0;
    private int mFooterCount = 0;

    @Override
    public int getItemCount() {
        int headerCount = mHeaders != null ? mHeaders.size() : 0;
        int footerCount = mFooters != null ? mFooters.size() : 0;
        return headerCount + footerCount + getContentItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        if(position < mHeaderCount) {
            return mHeaders.indexOfKey(position);
        }else if(position < mHeaderCount + getContentItemCount()) {
            return getContentItemViewType(position - mHeaderCount);
        }else {
            return mFooters.indexOfKey(position - mHeaderCount - getContentItemCount());
        }
    }

    public abstract int getContentItemViewType(int position);

    public abstract int getContentItemCount();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mHeaders != null && mHeaders.indexOfKey(viewType) >= 0) {
            return mHeaders.get(viewType).viewHolder;
        }
        if(mFooters != null && mFooters.indexOfKey(viewType) >= 0) {
            return mFooters.get(viewType).viewHolder;
        }
        return onCreateItemViewHolder(parent, viewType);
    }

    public abstract V onCreateItemViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position >= mHeaderCount && position < mHeaderCount + getContentItemCount()) {
            onBindItemViewHolder((V)holder, position - mHeaderCount);
        }
    }

    public abstract void onBindItemViewHolder(V holder, int position);

    private int getHeaderCount() {
        return mHeaderCount;
    }

    private int getFooterCount() {
        return mFooterCount;
    }

    public void addHeader(int type, View view) {
        if(mHeaders == null) {
            mHeaders = new SparseArray<>();
        }
        mHeaders.put(type, new ExtraItemView(view));
        mHeaderCount = mHeaders.size();
        notifyDataSetChanged();
    }

    public void removeHeader(int type) {
        if(mHeaders == null) {
            return;
        }
        mHeaders.remove(type);
        mHeaderCount = mHeaders.size();
        notifyDataSetChanged();
    }

    public boolean hasHeader(int type) {
        if(mHeaders == null) {
            return false;
        }
        return mHeaders.indexOfKey(type) >= 0;
    }

    public void addFooter(int type, View view) {
        if(mFooters == null) {
            mFooters = new SparseArray<>();
        }
        mFooters.put(type, new ExtraItemView(view));
        mFooterCount = mFooters.size();
        notifyDataSetChanged();
    }

    public void removeFooter(int type) {
        if(mFooters == null) {
            return;
        }
        mFooters.remove(type);
        mFooterCount = mFooters.size();
        notifyDataSetChanged();
    }

    public boolean hasFooter(int type) {
        if(mFooters == null) {
            return false;
        }
        return mFooters.indexOfKey(type) >= 0;
    }

    public class ExtraItemView {
        public RecyclerView.ViewHolder viewHolder;

        public ExtraItemView(View content) {
            viewHolder = new RecyclerView.ViewHolder(content) {
            };
        }
    }
}
