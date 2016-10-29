package com.zonelian.framework.base.rx;

import com.zonelian.framework.core.utils.HandlerUtil;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by kernel on 2016/10/28.
 * Email: 372786297@qq.com
 */

public class RxHttpUtil {

    public static <T> Subscription subscribe(Observable source, final Action1<T> onNext, final Action1<Throwable> onError,
                                               final Action0 onTimeout, long timeout, TimeUnit timeUnit, final boolean subscribeOnUI) {
        source.observeOn(Schedulers.io());
        Observable temp = source.timeout(timeout, timeUnit);
        return temp.subscribe(new Action1<T>() {
            @Override
            public void call(final T result) {
                if(subscribeOnUI) {
                    HandlerUtil.runOnMainThread(new Runnable() {
                        @Override
                        public void run() {
                            onNext.call(result);
                        }
                    });
                }else {
                    onNext.call(result);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(final Throwable throwable) {
                if(subscribeOnUI) {
                    HandlerUtil.runOnMainThread(new Runnable() {
                        @Override
                        public void run() {
                            if(throwable instanceof TimeoutException) {
                                onTimeout.call();
                            }else {
                                onError.call(throwable);
                            }
                        }
                    });
                }else {
                    if(throwable instanceof TimeoutException) {
                        onTimeout.call();
                    }else {
                        onError.call(throwable);
                    }
                }
            }
        });
    }

    public static <T> Subscription subscribe(Observable source, final Action1<T> onNext, final Action0 onComplete,
                                               final Action1<Throwable> onError, final Action0 onTimeout,
                                               long timeout, TimeUnit timeUnit, final boolean subscribeOnUI) {
        source.observeOn(Schedulers.io());
        Observable temp = source.timeout(timeout, timeUnit);
        return temp.subscribe(new Action1<T>() {
            @Override
            public void call(final T result) {
                if(subscribeOnUI) {
                    HandlerUtil.runOnMainThread(new Runnable() {
                        @Override
                        public void run() {
                            onNext.call(result);
                        }
                    });
                }else {
                    onNext.call(result);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(final Throwable throwable) {
                if(subscribeOnUI) {
                    HandlerUtil.runOnMainThread(new Runnable() {
                        @Override
                        public void run() {
                            if (throwable instanceof TimeoutException) {
                                onTimeout.call();
                            } else {
                                onError.call(throwable);
                            }
                        }
                    });
                }else {
                    if (throwable instanceof TimeoutException) {
                        onTimeout.call();
                    } else {
                        onError.call(throwable);
                    }
                }
            }
        }, new Action0() {
            @Override
            public void call() {
                if(subscribeOnUI) {
                    HandlerUtil.runOnMainThread(new Runnable() {
                        @Override
                        public void run() {
                            onComplete.call();
                        }
                    });
                }else {
                    onComplete.call();
                }
            }
        });
    }
}
