package com.zonelian.androidframework.demo.first;

import android.os.Bundle;

import com.zonelian.androidframework.demo.App;
import com.zonelian.androidframework.demo.base.datasource.local.db.User;
import com.zonelian.framework.base.presenter.BaseActivityPresenter;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by kernel on 2016/10/30.
 * Email: 372786297@qq.com
 */

public class FirstPresenter extends BaseActivityPresenter<FirstView> {
    private FirstView mView;

    @Override
    public void onPause() {

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
    public void onStop() {

    }

    @Override
    public void setView(FirstView view) {
        this.mView = view;
    }

    @Override
    public FirstView getView() {
        return mView;
    }

    public void initData() {

    }

    public void insert(String name) {
        User usr = new User();
        usr.setName(name);
        App.getInstance().getLocalDataLayer().getUserDao().insert(usr);
    }

    public void query() {
        if(getView() != null) {
            getView().showQueryEnable(false);
            getView().showQuerying();
        }
        Subscription subscription = Observable.create(new Observable.OnSubscribe<List<UserData>>() {
            @Override
            public void call(Subscriber<? super List<UserData>> subscriber) {
                List<UserData> result = null;
                try {
                    List<User> output = App.getInstance().getLocalDataLayer().getUserDao().loadAll();
                    if(output != null) {
                        result = new ArrayList<>(output.size());
                        UserData temp = null;
                        for(User item : output) {
                            temp = new UserData();
                            temp.name = item.getName();
                            result.add(temp);
                        }
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                    subscriber.onError(e);
                    return;
                }
                subscriber.onNext(result);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<UserData>>() {
                    @Override
                    public void call(List<UserData> result) {
                        if(getView() != null) {
                            getView().showQueryComplete();
                            getView().showQueryResult(result);
                            getView().showQueryEnable(true);
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        if(getView() != null) {
                            getView().showQueryComplete();
                            getView().showToast(throwable.getMessage());
                            getView().showQueryEnable(true);
                        }
                    }
                });
        addSubscription(subscription);
    }
}
