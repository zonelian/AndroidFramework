package com.zonelian.framework.base.okhttp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zonelian.framework.base.mock.PhoneNumAttributionBean;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by kernel on 16/6/26.
 * Email: 372786297@qq.com
 */
public class OkResponseCallbackWrapperTest extends TestCase{
    private static final String TAG = "OkResponseCallback";
    private long mStartTime = 0L;
    Object object = new Object();

    @Test
    public void testEnqueue() throws Exception {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();

        Headers headers = new Headers.Builder()
                .add("Accept", "application/json")
                .add("apikey", "8592f55d547e45b639f442c90ca10cd6")
                .build();

        UrlBuilder urlBuilder = new UrlBuilder();
        urlBuilder.setUrl("http://apis.baidu.com/showapi_open_bus/mobile/find")
                .addParam("num", "15750780583");
        Request request = new Request.Builder()
                .headers(headers)
                .url(urlBuilder.build())
                .get()
                .build();
        Call call = client.newCall(request);
        OkResponseCallbackWrapper callback = new OkResponseCallbackWrapper.Builder()
                .timeout(TimeUnit.SECONDS.toNanos(5))
                .responseParser(new ResponseGsonParser())
                .resultCallback(new OkHttpResultCallback() {
                    @Override
                    public void onResultSuccess(Call call, Response response, Result result) {
                        Assert.assertEquals(201, response.code());
                        try {
                            System.out.println("onResultSuccess:" + response.body().string());
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                        object.notify();
                    }

                    @Override
                    public void onResultCanceled(Call call) {
                        Assert.assertEquals(true, call.isCanceled());
                        System.out.println("onResultCanceled:" + call.isCanceled());
                        object.notify();
                    }

                    @Override
                    public void onResultTimeout(Call call) {
                        Assert.assertEquals("http://www", call.request().url().host());
                        System.out.println("onResultTimeout:" + (System.currentTimeMillis() - mStartTime));
                        object.notify();
                    }

                    @Override
                    public void onResultFaild(Call call, Response response, int code, String msg) {
                        Assert.assertEquals("123", response.message());
                        System.out.println("onResultFaild:" + msg);
                        object.notify();
                    }

                    @Override
                    public void onResultError(Call call, Exception e) {
                        Assert.assertEquals("ex", e.getMessage());
                        System.out.println("onResultError:" + e.getMessage());
                        object.notify();
                    }
                })
                .build();
        call.enqueue(callback.enqueue());
        mStartTime = System.currentTimeMillis();
        object.wait();
    }

    private class ResponseGsonParser implements HttpResponseParser<PhoneNumAttributionBean> {

        @Override
        public PhoneNumAttributionBean parse(String response, Class beanClass) {
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(response, PhoneNumAttributionBean.class);
        }
    }

}
