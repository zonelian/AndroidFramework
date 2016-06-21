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
    private Callback mCallback;
    private Request mRequest;
    private Response mResponse;

    @Override
    public void execute(Request request) {
        this.mRequest = request;
        List<String> in = new ArrayList<>();
        Observable observable = Observable.from(in)
                .observeOn(Schedulers.computation())
                .subscribeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                if(mCallback != null) {
                    mCallback.onSuccess(o);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        });
    }

    @Override
    public Request getRequest() {
        return mRequest;
    }

    @Override
    public Response getResponse() {
        return mResponse;
    }

    @Override
    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    @Override
    public Callback getCallback() {
        return mCallback;
    }
}
