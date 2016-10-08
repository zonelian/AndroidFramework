package com.zonelian.androidframework.presenter;

import com.zonelian.androidframework.repository.BasicRepository;
import com.zonelian.androidframework.view.BasicView;

/**
 * Created by kernel on 16/7/9.
 * Email: 372786297@qq.com
 */
public abstract class BasicPresenter implements BaseMVPPresenter{
    private BasicView mView;
    private BasicRepository mRepository;

    public BasicPresenter(BasicView mView, BasicRepository repository) {
        this.mView = mView;
        this.mRepository = repository;
    }

    public BasicRepository getRepository() {
        return mRepository;
    }

    @Override
    public void onDestory() {
        mRepository = null;
        mView = null;
    }
}
