package com.zonelian.androidframework.demo.first;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zonelian.androidframework.demo.R;
import com.zonelian.framework.base.MVPActivity;

import java.util.List;

/**
 * Created by kernel on 2016/10/30.
 * Email: 372786297@qq.com
 */

public class FirstActivity extends MVPActivity<FirstPresenter> implements FirstView {
    private WebView mWebview;

    @Override
    public FirstPresenter createPresenter() {
        return new FirstPresenter();
    }

    @Override
    public void initPresenter(FirstPresenter presenter) {
        presenter.setView(this);
    }

    @Override
    public int initLayout() {
        return R.layout.activity_first;
    }

    @Override
    public void initView() {
        mWebview = getViewById(R.id.webview);
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.setWebViewClient(new WebViewClient());
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mWebview.loadUrl("artist://first/enter");
            }
        }, 2000);
    }

    @Override
    public void initData() {
        getPresenter().initData();
    }

    @Override
    public void showInsertEnable(boolean enable) {
    }

    @Override
    public String getInsertName() {
        return "";
    }

    @Override
    public void showQueryEnable(boolean enable) {
    }

    @Override
    public void showQuerying() {
    }

    @Override
    public void showQueryComplete() {
    }

    @Override
    public void showQueryResult(List<UserData> result) {
    }

    public static void launch(Context context) {
        context.startActivity(new Intent(context, FirstActivity.class));
    }
}
