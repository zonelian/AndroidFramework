package com.zhonglian.widget.pull.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zhonglian.widget.R;
import com.zhonglian.widget.pull.ILoadingLayout;
import com.zhonglian.widget.pull.PullToRefreshBase.Mode;
import com.zhonglian.widget.pull.PullToRefreshBase.Orientation;

/**
 * Created by kernel on 16/2/23.
 * Email: 372786297@qq.com
 */
public class DefaultLoadingLayout extends FrameLayout implements ILoadingLayout {
    protected  Mode mMode;
    protected  Orientation mScrollDirection;

    private View mRootView;
    TextView mTvContent;
    ProgressBar mPbLoad;

    public DefaultLoadingLayout(Context context, Mode mode, Orientation orientation) {
        this(context, null, 0, mode, orientation);
    }

    public DefaultLoadingLayout(Context context, AttributeSet attrs, Mode mode, Orientation orientation) {
        this(context, attrs, 0 , mode, orientation);
    }

    public DefaultLoadingLayout(Context context, AttributeSet attrs, int defStyleAttr, Mode mode, Orientation orientation) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, mode, orientation);
    }

    private void init(Context context, AttributeSet attributeSet, Mode mode, Orientation orientation) {
        mMode = mode;
        mScrollDirection = orientation;

        LayoutInflater.from(context).inflate(R.layout.connected_pull_up_getmore_connect_suc, this);
        mRootView = findViewById(R.id.rl_load_root);
        mTvContent = (TextView) mRootView.findViewById(R.id.tx_pull_more);
        mPbLoad = (ProgressBar) mRootView.findViewById(R.id.refresh_loading_more);
    }

    @Override
    public int getContentSize() {
        switch (mScrollDirection) {
            case HORIZONTAL:
                return mRootView.getWidth();
            case VERTICAL:
            default:
                return mRootView.getHeight();
        }
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
    }

    @Override
    public void pullToRefresh() {
        mTvContent.setText("上拉加载更多");
    }

    @Override
    public void refreshing() {
        mTvContent.setVisibility(GONE);
        mPbLoad.setVisibility(VISIBLE);
    }

    @Override
    public void releaseToRefresh() {
        mTvContent.setText("松手加载");
    }

    @Override
    public void reset() {
        mPbLoad.setVisibility(GONE);
        mTvContent.setVisibility(VISIBLE);
        mTvContent.setText("上拉加载更多");
    }

    @Override
    public void setWidth(int width) {
        ViewGroup.LayoutParams lp = getLayoutParams();
        lp.width = width;
        requestLayout();
    }

    @Override
    public void setHeight(int height) {
        ViewGroup.LayoutParams lp = getLayoutParams();
        lp.height = height;
        requestLayout();
    }

    @Override
    public void onPull(float scale) {
    }
}
