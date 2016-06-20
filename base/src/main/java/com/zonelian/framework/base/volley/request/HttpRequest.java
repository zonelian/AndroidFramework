package com.zonelian.framework.base.volley.request;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.zonelian.framework.base.volley.HttpHeader;
import com.zonelian.framework.base.volley.HttpParam;
import com.zonelian.framework.base.volley.HttpRequestCallback;
import com.zonelian.framework.base.volley.response.HttpResponseParser;

import java.util.Map;

/**
 * Created by kernel on 16/6/13.
 * Email: 372786297@qq.com
 */
public abstract class HttpRequest<M> extends Request{
    protected Class mBeanClass;
    protected String mUrl;
    protected HttpHeader mHttpHeader;
    protected HttpParam mHttpParam;
    protected HttpRequestCallback mResultCallback;
    protected HttpResponseParser mResponseParser;


    public HttpRequest(int method, String url) {
        super(method, url, null);
        mUrl = url;
    }

    public HttpRequest(int method, String url, Response.ErrorListener listener) {
        super(method, url, listener);
        mUrl = url;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return mHttpHeader != null ? mHttpHeader.get() : super.getHeaders();
    }

    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        if(isCanceled()) {
            return null;
        }
        if(response.statusCode == 200) {
            if(mResponseParser != null) {
                return mResponseParser.parse(response, mBeanClass);
            }else {
                return null;
            }
        }else {
            return Response.error(new ServerError());
        }
    }

    @Override
    protected void deliverResponse(Object response) {
        if(isCanceled()) {
            return;
        }
        deliverResult((M)response);
    }

    public abstract void deliverResult(M data);

    @Override
    public void deliverError(VolleyError error) {
        if(isCanceled()) {
            return;
        }
        if(error instanceof TimeoutError) {
            if(mResultCallback != null) {
                mResultCallback.onTimeout();
                return;
            }
        }
        if(mResultCallback != null) {
            mResultCallback.onError(error);
            return;
        }
        super.deliverError(error);
    }

    public static abstract class Build {
        protected Class mBeanClass;
        protected String url;
        protected HttpHeader headers;
        protected HttpParam params;
        protected HttpResponseParser responseParser;
        protected HttpRequestCallback callback;

        public Build setBeanClass(Class clazz) { this.mBeanClass = clazz;
            return this;
        }

        public Build setUrl(String url) {
            this.url = url;
            return this;
        }

        public Build setParams(HttpParam params) {
            this.params = params;
            return this;
        }

        public Build setHeaders(HttpHeader headers) {
            this.headers = headers;
            return this;
        }

        public Build setResponseParser(HttpResponseParser responseParser) {
            this.responseParser = responseParser;
            return this;
        }

        public Build setCallback(HttpRequestCallback callback) {
            this.callback = callback;
            return this;
        }


        public abstract HttpRequest build();
    }
}
