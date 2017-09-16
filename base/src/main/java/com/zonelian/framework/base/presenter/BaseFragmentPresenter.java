package com.zonelian.framework.base.presenter;

import android.os.Bundle;

import com.zonelian.framework.mvp.core.MVP;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * Created by kernel on 2016/10/12.
 * Email: 372786297@qq.com
 */

public abstract class BaseFragmentPresenter<T extends MVP.MVPView> implements IFragmentPresenter<T> {
    private List<Subscription> mSubscriptions;
    private T mView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mSubscriptions = new ArrayList<>();
    }

    @Override
    public void onDestory() {
        if(mSubscriptions != null) {
            if(!mSubscriptions.isEmpty()) {
                for(Subscription subscription : mSubscriptions) {
                    if( !subscription.isUnsubscribed()) {
                        subscription.unsubscribe();
                    }
                }
                mSubscriptions.clear();
            }
            mSubscriptions = null;
        }
    }

    public void unsubscribeAll() {
        if(mSubscriptions != null) {
            if(!mSubscriptions.isEmpty()) {
                for(Subscription subscription : mSubscriptions) {
                    if( !subscription.isUnsubscribed()) {
                        subscription.unsubscribe();
                    }
                }
                mSubscriptions.clear();
            }
        }
    }

    public void onSubscriptionComplete(Subscription subscription) {
        if(mSubscriptions != null && mSubscriptions.contains(subscription)) {
            mSubscriptions.remove(subscription);
        }
    }

    public void addSubscription(Subscription subscription) {
        if(mSubscriptions != null) {
            mSubscriptions.add(subscription);
        }
    }

    @Override
    public void setView(T view) {
        mView = view;
    }

    @Override
    public T getView() {
        return mView;
    }
}
