package com.zhonglian.widget.pull.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.zhonglian.widget.pull.ILoadingLayout;
import com.zhonglian.widget.pull.PullToRefreshBase;


/**
 * Created by kernel on 16/2/23.
 * Email: 372786297@qq.com
 */
public class PullToRefreshRecyclerView extends PullToRefreshBase<RecyclerView> {

    public PullToRefreshRecyclerView(Context context) {
        super(context);
    }

    public PullToRefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullToRefreshRecyclerView(Context context, Mode mode) {
        super(context, mode);
    }

    @Override
    public ILoadingLayout createLoadingLayout(Context context, Mode mode, TypedArray attrs) {
        switch (mode) {
            case PULL_FROM_END:
                return new DefaultLoadingLayout(context, mode, getPullToRefreshScrollDirection());
            case PULL_FROM_START:
                return new DefaultRefreshLayout(context, mode, getPullToRefreshScrollDirection());
            default:
                return null;
        }
    }

    @Override
    public Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    @Override
    protected RecyclerView createRefreshableView(Context context, AttributeSet attrs) {
        RecyclerView recyclerView = new RecyclerView(context, attrs);
        recyclerView.setId(attrs.getIdAttributeResourceValue(0) + 1);
        return recyclerView;
    }

    @Override
    protected boolean isReadyForPullEnd() {
//        View child = getRefreshableView().getChildAt(getRefreshableView().getChildCount() - 1);
//        if(child != null) {
//            return child.getBottom() <= getRefreshableView().getBottom();
//        }
        RecyclerView.LayoutManager layoutManager = getRefreshableView().getLayoutManager();
        View child = layoutManager.findViewByPosition(layoutManager.getItemCount() - 1);
        if(child != null) {
            return child.getBottom() <= getRefreshableView().getBottom();
        }
        return false;
    }

    @Override
    protected boolean isReadyForPullStart() {
        View child = getRefreshableView().getChildAt(0);
        if(child != null) {
            return child.getTop() >= getRefreshableView().getTop();
        }
        return false;
    }
}
