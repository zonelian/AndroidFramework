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
import android.view.inputmethod.InputMethodManager;

import com.zonelian.framework.async.base.AsyncTask;
import com.zonelian.framework.async.core.Task;
import com.zonelian.framework.async.core.TaskCompleteAction;
import com.zonelian.framework.async.core.TaskErrorAction;
import com.zonelian.framework.async.core.TaskExecutor;
import com.zonelian.framework.base.utils.HandlerUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by kernel on 16/7/3.
 * Email: 372786297@qq.com
 */
public class App extends Application{
    private OkHttpClient mOkHttpClientGlobal;
    private SharedPreferences mSharePreferencesGlobal;
    private static App sInstance;

    private List<AsyncTask> tasks;

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

        tasks = new ArrayList<>();
        for(int i = 0; i < 15 ; i ++) {
            AsyncTask task = new AsyncTask.Builder()
                    .execute(new TaskExecutor<Boolean>() {
                        @Override
                        public Boolean execute(Task.Request request) {
                            Request r = new Request.Builder().url("https://www.baidu.com").build();
                            try {
                                getOkHttpClient().newCall(r).execute();
                            }catch (IOException e) {
                                e.printStackTrace();
                            }
                            return true;
                        }
                    })
                    .complete(new TaskCompleteAction<Boolean>() {
                        @Override
                        public void action(Task task, Boolean output) {

                        }
                    })
                    .error(new TaskErrorAction() {
                        @Override
                        public void action(Task task, Exception exception) {

                        }
                    })
                    .consumePerformance(Task.Request.CONSUME_CPU)
                    .build();
            task.submit();
            tasks.add(task);
        }
        HandlerUtil.runDelay(new Runnable() {
            @Override
            public void run() {
                tasks.get(0).cancle();
                tasks.get(8).cancle();
                tasks.get(9).cancle();
            }
        }, 5000);
    }

    public OkHttpClient getOkHttpClient() {
        if(mOkHttpClientGlobal == null) {
            mOkHttpClientGlobal = new OkHttpClient.Builder()
                    .build();
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
