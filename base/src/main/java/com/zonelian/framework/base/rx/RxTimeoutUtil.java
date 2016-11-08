package com.zonelian.framework.base.rx;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by kernel on 2016/10/28.
 * Email: 372786297@qq.com
 */

public class RxTimeoutUtil {

    public static <T> Subscription subscribeOn(Observable source, final Action1<T> onNext, final Action1<Throwable> onError,
                                  final Action0 onTimeout, long timeout, TimeUnit timeUnit) {
        return source.timeout(timeout, timeUnit).subscribe(new Action1<T>() {
            @Override
            public void call(T result) {
                onNext.call(result);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                if(throwable instanceof TimeoutException) {
                    onTimeout.call();
                }else {
                    onError.call(throwable);
                }
            }
        });
    }

    public static <T> Subscription subscribeOn(Observable source, final Action1<T> onNext, final Action0 onComplete,
                                    final Action1<Throwable> onError, final Action0 onTimeout,
                                    long timeout, TimeUnit timeUnit) {
        return source.timeout(timeout, timeUnit).subscribe(new Action1<T>() {
            @Override
            public void call(T result) {
                onNext.call(result);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                if (throwable instanceof TimeoutException) {
                    onTimeout.call();
                } else {
                    onError.call(throwable);
                }
            }
        }, new Action0() {
            @Override
            public void call() {
                onComplete.call();
            }
        });
    }
}
