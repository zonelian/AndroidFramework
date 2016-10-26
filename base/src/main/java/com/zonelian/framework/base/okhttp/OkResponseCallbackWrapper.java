package com.zonelian.framework.base.okhttp;

import android.os.Handler;
import android.os.Looper;

import com.zonelian.framework.core.http.HttpResponseParser;
import com.zonelian.framework.core.http.Result;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by kernel on 16/6/19.
 * Email: 372786297@qq.com
 */
public class OkResponseCallbackWrapper {
    protected Callback mCallback;
    private HttpResponseParser mResponseParser;
    private OkHttpResultCallback mResultCallback;
    protected long mStartTime = 0L;
    protected long mTimeout;
    private Class mBeanClass;

    protected OkResponseCallbackWrapper() {
    }

    public Callback enqueue() {
        mCallback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                    if(call.isCanceled()) {
                        onResultCanceled(call);
                        return;
                    }
                    if(System.nanoTime() - mStartTime >= mTimeout) {
                        onResultTimeout(call);
                        return;
                    }
                    onResultError(call, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Result obj = null;
                if(mResponseParser != null) {
                    obj = mResponseParser.parse(response.body().string(), mBeanClass);
                }
                if(obj != null ) {
                    if(obj.isOk()) {
                        onResultSuccess(call, response, obj);
                    }else {
                        onResultFaild(call, response, obj.getCode(), obj.getMsg());
                    }
                }
            }
        };
        mStartTime = System.nanoTime();
        return mCallback;
    }

    private void onResultSuccess(final Call call,final Response response,final Result result) {
        if(mResultCallback != null) {
            runOnUi(new Runnable() {
                @Override
                public void run() {
                    mResultCallback.onResultSuccess(call, response, result);
                }
            });
        }
    }

    private void onResultFaild(final Call call,final Response response,final int code ,final String msg) {
        if(mResultCallback != null) {
            runOnUi(new Runnable() {
                @Override
                public void run() {
                    mResultCallback.onResultFaild(call, response, code, msg);
                }
            });
        }
    }

    private void onResultCanceled(final Call call) {
        if(mResultCallback != null) {
            runOnUi(new Runnable() {
                @Override
                public void run() {
                    mResultCallback.onResultCanceled(call);
                }
            });
        }
    }

    private void onResultTimeout(final Call call) {
        if(mResultCallback != null) {
            runOnUi(new Runnable() {
                @Override
                public void run() {
                    mResultCallback.onResultTimeout(call);
                }
            });
        }
    }

    private void onResultError(final Call call,final Exception e) {
        if(mResultCallback != null) {
            runOnUi(new Runnable() {
                @Override
                public void run() {
                    mResultCallback.onResultError(call, e);
                }
            });
        }
    }

    private void runOnUi(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public static class Builder {
        private HttpResponseParser responseParser;
        private OkHttpResultCallback resultCallback;
        private Class beanClass;
        private long timeout;


        public Builder() {
        }

        public Builder responseParser(HttpResponseParser parser) {
            responseParser = parser;
            return this;
        }

        public Builder resultCallback(OkHttpResultCallback callback) {
            resultCallback = callback;
            return this;
        }

        public Builder timeout(long nanoseconds) {
            this.timeout = nanoseconds;
            return this;
        }

        public Builder beanClass(Class clazz) {
            this.beanClass = clazz;
            return this;
        }

        public OkResponseCallbackWrapper build() {
            OkResponseCallbackWrapper wrapper = new OkResponseCallbackWrapper();
            wrapper.mBeanClass = beanClass;
            wrapper.mResponseParser = responseParser;
            wrapper.mResultCallback = resultCallback;
            wrapper.mTimeout = timeout;
            return wrapper;
        }
    }
}
