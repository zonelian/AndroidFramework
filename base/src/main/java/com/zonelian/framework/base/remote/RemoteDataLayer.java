package com.zonelian.framework.base.remote;

import com.zonelian.framework.core.utils.HandlerUtil;
import com.zonelian.framework.http.core.Result;
import com.zonelian.framework.rx.RxHttpUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;

/**
 * Created by kernel on 2016/10/23.
 * Email: 372786297@qq.com
 */

public abstract class RemoteDataLayer {
    private OkHttpClient mOkHttpClient;

    public RemoteDataLayer() {
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    public OkHttpClient getDefaultOkHttpClient() {
        return mOkHttpClient;
    }

    public <T> Subscription subscribe(Observable source, Action1<T> onNext, Action1<Throwable> onError,
                                      Action0 onTimeout) {
        return RxHttpUtil.subscribe(source, onNext, onError, onTimeout, 30, TimeUnit.SECONDS);
    }


    public <T> Subscription subscribe(Observable source, Action1<T> onNext, Action0 onComplete,
                                      Action1<Throwable> onError, Action0 onTimeout) {
        return RxHttpUtil.subscribe(source, onNext, onComplete, onError, onTimeout, 30, TimeUnit.SECONDS);
    }

    public <T extends Result> Subscription subscribe(Observable source, final Action1<T> onSuccess, final Action2<Integer, String> onFailure,
                                                     final Action0 onTimeout, final Action1<Throwable> onError) {
        return RxHttpUtil.subscribe(source, new Action1<T>() {
            @Override
            public void call(T result) {
                if(result.isOk()) {
                    onSuccess.call(result);
                }else {
                    onFailure.call(result.getCode(), result.getMsg());
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                onError.call(throwable);
            }
        }, onTimeout, 30, TimeUnit.SECONDS);
    }

    public <T extends Result> Subscription subscribe(Observable source, final Action1<T> onSuccess, final Action2<Integer, String> onFailure,
                                                     final Action0 onComplete, final Action0 onTimeout, final Action1<Throwable> onError) {
        return RxHttpUtil.subscribe(source, new Action1<T>() {
            @Override
            public void call(T result) {
                if(result.isOk()) {
                    onSuccess.call(result);
                }else {
                    onFailure.call(result.getCode(), result.getMsg());
                }
            }
        }, onComplete, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                onError.call(throwable);
            }
        }, onTimeout, 30, TimeUnit.SECONDS);
    }



    public <T> Subscription subscribeOnUI(Observable source, final Action1<T> onNext, final Action0 onComplete, final Action1<Throwable> onError, final Action0 onTimeout) {
        return this.subscribe(source, new Action1<T>() {
            @Override
            public void call(final T t) {
                HandlerUtil.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        onNext.call(t);
                    }
                });
            }
        }, new Action0() {
            @Override
            public void call() {
                HandlerUtil.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        onComplete.call();
                    }
                });
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(final Throwable throwable) {
                HandlerUtil.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        onError.call(throwable);
                    }
                });
            }
        }, new Action0() {
            @Override
            public void call() {
                HandlerUtil.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        onTimeout.call();
                    }
                });
            }
        });
    }

    public <T> Subscription subscribeOnUI(Observable source, final Action1<T> onNext, final Action1<Throwable> onError, final Action0 onTimeout) {
        return this.subscribe(source, new Action1<T>() {
            @Override
            public void call(final T t) {
                HandlerUtil.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        onNext.call(t);
                    }
                });
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(final Throwable throwable) {
                HandlerUtil.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        onError.call(throwable);
                    }
                });
            }
        }, new Action0() {
            @Override
            public void call() {
                HandlerUtil.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        onTimeout.call();
                    }
                });
            }
        });
    }

    public <T extends Result> Subscription subscribeOnUI(Observable source, final Action1<T> onSuccess, final Action2<Integer, String> onFailure, final Action0 onComplete, final Action0 onTimeout, final Action1<Throwable> onError) {
        return this.subscribe(source, new Action1<T>() {
            @Override
            public void call(final T t) {
                HandlerUtil.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        onSuccess.call(t);
                    }
                });
            }
        }, new Action2<Integer, String>() {
            @Override
            public void call(final Integer integer, final String s) {
                HandlerUtil.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        onFailure.call(integer, s);
                    }
                });
            }
        }, new Action0() {
            @Override
            public void call() {
                HandlerUtil.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        onComplete.call();
                    }
                });
            }
        }, new Action0() {
            @Override
            public void call() {
                HandlerUtil.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        onTimeout.call();
                    }
                });
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(final Throwable throwable) {
                HandlerUtil.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        onError.call(throwable);
                    }
                });
            }
        });
    }

    public <T extends Result> Subscription subscribeOnUI(Observable source, final Action1<T> onSuccess, final Action2<Integer, String> onFailure, final Action0 onTimeout, final Action1<Throwable> onError) {
        return this.subscribe(source, new Action1<T>() {
            @Override
            public void call(final T t) {
                HandlerUtil.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        onSuccess.call(t);
                    }
                });
            }
        }, new Action2<Integer, String>() {
            @Override
            public void call(final Integer integer, final String s) {
                HandlerUtil.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        onFailure.call(integer, s);
                    }
                });
            }
        }, new Action0() {
            @Override
            public void call() {
                HandlerUtil.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        onTimeout.call();
                    }
                });
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(final Throwable throwable) {
                HandlerUtil.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        onError.call(throwable);
                    }
                });
            }
        });
    }
}
