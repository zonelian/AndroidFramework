package com.zonelian.androidframework;

import android.app.AlarmManager;
import android.app.Application;
import android.app.DownloadManager;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ClipboardManager;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.display.DisplayManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.view.inputmethod.InputMethodManager;

import okhttp3.OkHttpClient;

/**
 * Created by kernel on 16/7/3.
 * Email: 372786297@qq.com
 */
public class App extends Application{
    private OkHttpClient mOkHttpClientGlobal;
    private SharedPreferences mSharePreferencesGlobal;
    private static App sInstance;

//    private AppComponent mAppComponent;
//    @Inject  AppRepository mRepository;

    public static final App getInstance(){
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        initInject();
        sInstance = this;
        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap bmJpg = BitmapFactory.decodeResource(getResources(), R.mipmap.bg_login_1230);
                Bitmap bmPng = BitmapFactory.decodeResource(getResources(), R.mipmap.img_guide_third);
                long jpgSize = bmJpg.getByteCount();
                long pngSize = bmPng.getByteCount();
            }
        }).start();
    }

//    private void initInject() {
//        mAppComponent = DaggerAppComponent.builder()
//                .appRepositoryComponent(DaggerAppRepositoryComponent.builder().build())
//                .build();
//        mAppComponent.inject(this);
//    }

//    public AppComponent getAppComponent() {
//        return mAppComponent;
//    }
//
//    public AppRepository getRepository() {
//        return mRepository;
//    }

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
