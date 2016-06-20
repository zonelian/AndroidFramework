package com.zonelian.androidframework;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by kernel on 16/6/16.
 * Email: 372786297@qq.com
 */
public class TestOkHttp {

    public void test() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(null)
                .addNetworkInterceptor(null)
                .connectTimeout(0, TimeUnit.SECONDS)
                .readTimeout(0, TimeUnit.SECONDS)
                .writeTimeout(0, TimeUnit.SECONDS)
                .build();

        MultipartBody.Part stringPart = MultipartBody.Part.createFormData("", "");

        RequestBody fileBody = RequestBody.create(MediaType.parse("file"), new File(""));
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("", "abd", fileBody);

        MultipartBody multipartBody = new MultipartBody.Builder()
                .addPart(stringPart)
                .addPart(filePart)
                .build();

        final Request request = new Request.Builder()
                .url("")
                .headers(null)
                .post(multipartBody)
                .build();

        Call call = okHttpClient.newCall(request);
        try {
            call.execute();
        }catch (IOException e) {
            e.printStackTrace();
        }
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            }
        });
    }
}
