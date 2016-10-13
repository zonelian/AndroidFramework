package com.zonelian.androidframework;

import android.app.AlarmManager;
import android.app.Application;
import android.app.DownloadManager;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ClipboardManager;
import android.content.SharedPreferences;
import android.hardware.display.DisplayManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import com.zonelian.framework.base.okhttp.OkPrirotyClient;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.OkRequestBuilder;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by kernel on 16/7/3.
 * Email: 372786297@qq.com
 */
public class App extends Application{
    private OkHttpClient mOkHttpClientGlobal;
    private SharedPreferences mSharePreferencesGlobal;
    private static App sInstance;

    public static final App getInstance(){
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        test();
    }

    private void test() {
        OkHttpClient client = OkPrirotyClient.get();
        for(int i = 0; i < 10; i ++) {
            Request request = new OkRequestBuilder().setPriority(i)
                    .url("https://www.baidu.com").get().build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    try {
                        Thread.sleep(5000);
                    }catch (InterruptedException ee) {
                        ee.printStackTrace();
                    }
                    Log.d("wuzhimu", "background failure");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        Thread.sleep(5000);
                    }catch (InterruptedException ee) {
                        ee.printStackTrace();
                    }
                    Log.d("wuzhimu", "background response");
                }
            });
        }
        for(int i = 0; i < 10; i ++) {
            Request request = new OkRequestBuilder().setPriority(10 + i)
                    .url("https://www.baidu.com").get().build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    try {
                        Thread.sleep(5000);
                    }catch (InterruptedException ee) {
                        ee.printStackTrace();
                    }
                    Log.d("wuzhimu", "foreground failure");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        Thread.sleep(5000);
                    }catch (InterruptedException ee) {
                        ee.printStackTrace();
                    }
                    Log.d("wuzhimu", "foreground response");
                }
            });
        }
    }

    public OkHttpClient getOkHttpClient() {
        if(mOkHttpClientGlobal == null) {
            mOkHttpClientGlobal = new OkHttpClient.Builder().build();
        }
        return mOkHttpClientGlobal;
    }

    public SharedPreferences getSharedPreferences() {
        if(mSharePreferencesGlobal == null) {
            mSharePreferencesGlobal = getSharedPreferences("Application", MODE_PRIVATE);
        }
        return mSharePreferencesGlobal;
    }

    public SharedPreferences getSharePreferences(String name) {
        return getSharedPreferences(name, MODE_PRIVATE);
    }

    public WifiManager getWiFiManager() {
        return (WifiManager)getSystemService(Service.WIFI_SERVICE);
    }

    public ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager)getSystemService(Service.CONNECTIVITY_SERVICE);
    }


    public AlarmManager getAlarmManager() {
        return (AlarmManager)getSystemService(Service.ALARM_SERVICE);
    }

    public NotificationManager getNotificationManager() {
        return (NotificationManager)getSystemService(Service.NOTIFICATION_SERVICE);
    }

    public ClipboardManager getClipboardManager() {
        return (ClipboardManager)getSystemService(Service.CLIPBOARD_SERVICE);
    }

    public InputMethodManager getInputMethodManager() {
        return (InputMethodManager)getSystemService(Service.INPUT_METHOD_SERVICE);
    }

    public DownloadManager getDownloadManager() {
        return (DownloadManager)getSystemService(Service.DOWNLOAD_SERVICE);
    }

    public DisplayManager getDisplayManager() {
        return (DisplayManager)getSystemService(Service.DISPLAY_SERVICE);
    }

}
