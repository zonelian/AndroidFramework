package com.zonelian.androidframework;

import com.zonelian.framework.mvp.usecase.UseCase;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by kernel on 16/6/14.
 * Email: 372786297@qq.com
 */
public class TestRxTask implements UseCase{
    private ResultCallBack mResultCallback = null;

    public TestRxTask(ResultCallBack resultCallback) {
        this.mResultCallback = resultCallback;
    }

    @Override
    public void start() {
        List<String> in = new ArrayList<>();
        Observable observable = Observable.from(in)
                .observeOn(Schedulers.computation())
                .subscribeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                if(mResultCallback != null) {
                    mResultCallback.onResult(o);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        });
    }

    @Override
    public void stop() {

    }

    @Override
    public void cancel() {

    }

    public static interface ResultCallBack<M> {
        public void onResult(M result);
    }
}
