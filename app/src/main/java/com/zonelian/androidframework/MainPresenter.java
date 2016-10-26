package com.zonelian.androidframework;

import android.os.Bundle;

import com.zonelian.androidframework.server.model.DetailBean;
import com.zonelian.androidframework.server.model.ResultModel;
import com.zonelian.framework.base.presenter.BaseActivityPresenter;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by kernel on 2016/10/22.
 * Email: 372786297@qq.com
 */

public class MainPresenter extends BaseActivityPresenter<MainView> {
    private MainView mView;

    @Override
    public void setView(MainView view) {
        this.mView = view;
    }

    @Override
    public MainView getView() {
        return mView;
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

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

    }

    public void initData() {
        Subscription subscription =
        App.getInstance().getRemoteDataLater().getMainServer().getDetail("0")
                .observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResultModel<DetailBean>>() {
                    @Override
                    public void call(ResultModel<DetailBean> detailBeanResultModel) {
                        if(detailBeanResultModel.isOk()) {
                            onInitSuccess(detailBeanResultModel.data);
                        }else if(detailBeanResultModel.mFailureMsgEntity.isNotMore()) {
                            onInitNotMore();
                        }else if(detailBeanResultModel.mFailureMsgEntity.isNotNew()) {
                            onInitNotNew();
                        }else {
                            onInitFailure(detailBeanResultModel.mFailureMsgEntity.getCode());
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        onInitThrowable(throwable);
                    }
                });
        addSubscription(subscription);
    }

    private void onInitSuccess(DetailBean data) {
        if(getView() != null) {
            getView().showData(data.name, data.age);
        }
    }

    private void onInitNotMore() {
        if(getView() != null) {
            getView().showToast("");
        }
    }

    private void onInitNotNew() {
        if(getView() != null) {
            getView().showToast("");
        }
    }

    private void onInitFailure(int code) {
        if(getView() != null) {
            getView().showToast("");
        }
    }

    private void onInitThrowable(Throwable throwable) {
        if(getView() != null) {
            getView().showToast("");
        }
    }
}
