package com.zonelian.androidframework.demo.second;

import android.os.Bundle;

import com.zonelian.androidframework.demo.second.remote.baidu.model.IDBean;
import com.zonelian.framework.base.presenter.BaseActivityPresenter;

/**
 * Created by kernel on 2016/11/17.
 * Email: 372786297@qq.com
 */

public class SecondPresenter extends BaseActivityPresenter<SecondView> {
    private SecondView mView;

    @Override
    public void setView(SecondView view) {
        mView = view;
    }

    @Override
    public SecondView getView() {
        return mView;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    public void initData() {
//        // try read from disk cache
//        try {
//            IDBean cache = (IDBean) App.getInstance().getLocalDataLayer().getFileHelper().getSerializable(App.getInstance().getCacheDir() + "/usr_info");
//            if(cache != null) {
//                onInitSuccess(cache);
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // try read from server
//        BaiduDataServer server = App.getInstance().getRemoteDataLayer().getBaiduServer();
//        Subscription subscription = App.getInstance().getRemoteDataLayer().subscribeOnUI(server.getID("420984198704207896"),
//                new Action1<BaiduModel<IDBean>>() {
//                    @Override
//                    public void call(BaiduModel<IDBean> bean) {
//                        App.getInstance().getLocalDataLayer().getFileHelper().putSerializable(App.getInstance().getCacheDir() + "/usr_info",
//                                bean.data);
//                        onInitSuccess(bean.data);
//                    }
//                }, new Action2<Integer, String>() {
//                    @Override
//                    public void call(Integer integer, String s) {
//                        onInitFailure(integer, s);
//                    }
//                }, new Action0() {
//                    @Override
//                    public void call() {
//                        onInitTimeout();
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Exception e = new Exception(throwable.getMessage());
//                        e.setStackTrace(throwable.getStackTrace());
//                        onInitException(e);
//                    }
//                });
//        addSubscription(subscription);
    }

    private void onInitSuccess(IDBean bean) {
        if(getView() != null) {
            getView().showData(bean.sex, bean.birthday, bean.address);
        }
    }

    private void onInitFailure(int errorCode, String msg) {
        if(getView() != null) {
            getView().showToast("init failure errorCode:" + errorCode + " errorMsg:" + msg);
        }
    }

    private void onInitTimeout() {
        if(getView() != null) {
            getView().showToast("init timeout");
        }
    }

    private void onInitException(Exception e) {
        if(getView() != null) {
            getView().showToast("init exception:" + e.getMessage());
        }
    }
}
