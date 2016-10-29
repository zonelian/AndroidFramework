package com.zonelian.androidframework;

import android.os.Bundle;

import com.zonelian.androidframework.server.BaiduDataServer;
import com.zonelian.androidframework.server.baidu.model.BaiduModel;
import com.zonelian.androidframework.server.baidu.model.IDBean;
import com.zonelian.androidframework.server.main.model.DetailBean;
import com.zonelian.framework.base.presenter.BaseActivityPresenter;

import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;

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
//        MainDataServer server = App.getInstance().getRemoteDataLater().getMainServer();
//        Subscription subscription = server.subscribe(server.getDetail("420984198704207896"),
//                new Action1<ResultModel<DetailBean>>() {
//                    @Override
//                    public void call(ResultModel<DetailBean> detailBeanResultModel) {
//                        if(detailBeanResultModel.isOk()) {
//                            onInitSuccess(detailBeanResultModel.data);
//                        }else if(detailBeanResultModel.mFailureMsgEntity.isNotMore()) {
//                            onInitNotMore();
//                        }else if(detailBeanResultModel.mFailureMsgEntity.isNotNew()) {
//                            onInitNotNew();
//                        }else {
//                            onInitFailure(detailBeanResultModel.mFailureMsgEntity.getCode());
//                        }
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        onInitThrowable(throwable);
//                    }
//                }, new Action0() {
//                    @Override
//                    public void call() {
//                        onInitTimeout();
//                    }
//                });
//        addSubscription(subscription);
        initTest();
    }

    private void initTest() {
        BaiduDataServer server = App.getInstance().getRemoteDataLater().getBaiduServer();
        Subscription subscription = server.subscribe(server.getID("420984198704207896"),
                new Action1<BaiduModel<IDBean>>() {
            @Override
            public void call(BaiduModel<IDBean> idBeanBaiduModel) {
                onInitNotNew();
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                onInitThrowable(throwable);
            }
        }, new Action0() {
            @Override
            public void call() {
                onInitTimeout();
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
            getView().showToast("失败");
        }
    }

    private void onInitThrowable(Throwable throwable) {
        if(getView() != null) {
            getView().showToast("异常");
        }
    }

    private void onInitTimeout() {
        if(getView() != null) {
            getView().showToast("超时");
        }
    }
}
