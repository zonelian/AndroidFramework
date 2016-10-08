package com.zonelian.androidframework.example;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.zonelian.androidframework.presenter.BasicPresenter;

import javax.inject.Inject;

/**
 * Created by kernel on 16/7/9.
 * Email: 372786297@qq.com
 */
public class ExamplePresenter extends BasicPresenter{

    @Inject
    public ExamplePresenter(ExampleView mView, ExampleRepository repository) {
        super(mView, repository);
    }

    @Override
    public MVP.MVPView getView() {
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onDestory() {
        super.onDestory();
    }

    @Override
    public void setView(MVP.MVPView view) {

    }
}
