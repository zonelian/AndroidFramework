package com.zonelian.framework.core.adapter.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kernel on 16/6/19.
 * Email: 372786297@qq.com
 */
public abstract class RecyclerViewAdapter<V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<ExtraItemView> mHeaders;
    private List<ExtraItemView> mFooters;
    private int mHeaderCount = 0;
    private int mFooterCount = 0;

    @Override
    public int getItemCount() {
        int headerCount = mHeaders != null ? mHeaders.size() : 0;
        int footerCount = mFooters != null ? mFooters.size() : 0;
        int temp = headerCount + footerCount + getContentItemCount();
        return temp;
    }

    @Override
    public int getItemViewType(int position) {
        int temp = getContentItemCount();
        if(position < mHeaderCount) {
            return mHeaders.get(position).viewType;
        }else if(position < mHeaderCount + temp) {
            return getContentViewType(position - mHeaderCount);
        }else {
            return mFooters.get(position - mHeaderCount - temp).viewType;
        }
    }

    /**
     *
     * @param position
     * @return must not smaller than 0
     */
    public abstract int getContentViewType(int position);

    public abstract int getContentItemCount();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mHeaders != null && mHeaders.size() > 0) {
            for(ExtraItemView header : mHeaders) {
                if(header.viewType == viewType) {
                    return header.viewHolder;
                }
            }
        }
        if(mFooters != null && mFooters.size() > 0) {
            for(ExtraItemView footer : mFooters) {
                if(footer.viewType == viewType) {
                    return footer.viewHolder;
                }
            }
        }
        return onCreateContentViewHolder(parent, viewType);
    }

    public abstract V onCreateContentViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(position >= mHeaderCount && position < mHeaderCount + getContentItemCount()) {
            onBindContentViewHolder((V)holder, position - mHeaderCount);
        }
    }

    public abstract void onBindContentViewHolder(V holder, int position);

    private int getHeaderCount() {
        return mHeaderCount;
    }

    private int getFooterCount() {
        return mFooterCount;
    }

    public boolean addHeader(int type, View view, int position) throws ExtraItemTypeDuplicateException, ViewTypeException{
        if(type >= 0) {
            throw new ViewTypeException("the type must smaller than 0");
        }
        if(position < 0) {
            return false;
        }
        if(mHeaders != null && mHeaders.size() <= position) {
            return false;
        }
        if(mHeaders != null) {
            for(ExtraItemView header : mHeaders) {
                if(header.viewType == type) {
                    throw new ExtraItemTypeDuplicateException("type 与已存在的Header的type重复");
                }
            }
        }
        if(mFooters != null) {
            for(ExtraItemView footer : mFooters) {
                if(footer.viewType == type) {
                    throw new ExtraItemTypeDuplicateException("type 与已存在的Footer的type重复");
                }
            }
        }
        if(mHeaders == null) {
            mHeaders = new ArrayList<>();
            if(position > 0 || position < 0) {
                return false;
            }
        }
        mHeaders.add(position, new ExtraItemView(view, type));
        mHeaderCount = mHeaders.size();
        notifyDataSetChanged();
        return true;
    }

    public void addHeader(int type, View view) throws ExtraItemTypeDuplicateException, ViewTypeException{
        if(type >= 0) {
            throw new ViewTypeException("the type must smaller than 0");
        }
        if(mHeaders != null) {
            for(ExtraItemView header : mHeaders) {
                if(header.viewType == type) {
                    throw new ExtraItemTypeDuplicateException("type 与已存在的Header的type重复");
                }
            }
        }
        if(mFooters != null) {
            for(ExtraItemView footer : mFooters) {
                if(footer.viewType == type) {
                    throw new ExtraItemTypeDuplicateException("type 与已存在的Footer的type重复");
                }
            }
        }
        if(mHeaders == null) {
            mHeaders = new ArrayList<>();
        }
        mHeaders.add(new ExtraItemView(view, type));
        mHeaderCount = mHeaders.size();
        notifyDataSetChanged();
    }

    public void removeHeader(int type) {
        if(mHeaders == null) {
            return;
        }
        for(int i = 0, len = mHeaders.size(); i < len; i ++) {
            if(mHeaders.get(i).viewType == type) {
                mHeaders.remove(i);
                mHeaderCount --;
                notifyDataSetChanged();
                break;
            }
        }
    }

    public boolean hasHeader(int type) {
        if(mHeaders == null) {
            return false;
        }
        for(ExtraItemView header : mHeaders) {
            if(header.viewType == type) {
                return true;
            }
        }
        return false;
    }

    public void addFooter(int type, View view) throws ExtraItemTypeDuplicateException, ViewTypeException{
        if(type >= 0) {
            throw new ViewTypeException("the type must smaller than 0");
        }
        if(mHeaders != null) {
            for(ExtraItemView header : mHeaders) {
                if(header.viewType == type) {
                    throw new ExtraItemTypeDuplicateException("type 与已存在的Header的type重复");
                }
            }
        }
        if(mFooters != null) {
            for(ExtraItemView footer : mFooters) {
                if(footer.viewType == type) {
                    throw new ExtraItemTypeDuplicateException("type 与已存在的Footer的type重复");
                }
            }
        }
        if(mFooters == null) {
            mFooters = new ArrayList<>();
        }
        mFooters.add(new ExtraItemView(view, type));
        mFooterCount = mFooters.size();
        notifyDataSetChanged();
    }

    public void removeFooter(int type) {
        if(mFooters == null) {
            return;
        }
        for(int i = 0, len = mFooters.size(); i < len; i ++) {
            if(mFooters.get(i).viewType == type) {
                mFooters.remove(i);
                mFooterCount --;
                break;
            }
        }
        notifyDataSetChanged();
    }

    public boolean hasFooter(int type) {
        if(mFooters == null) {
            return false;
        }
        for(ExtraItemView item : mFooters) {
            if(item.viewType == type) {
                return true;
            }
        }
        return false;
    }

    public class ExtraItemView {
        public RecyclerView.ViewHolder viewHolder;
        public int viewType = 0;

        public ExtraItemView(View content, int viewType) {
            viewHolder = new RecyclerView.ViewHolder(content) {
            };
            this.viewType = viewType;
        }
    }
}
