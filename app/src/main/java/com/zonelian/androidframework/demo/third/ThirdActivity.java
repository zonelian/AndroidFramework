package com.zonelian.androidframework.demo.third;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import com.zonelian.androidframework.demo.R;
import com.zonelian.framework.base.MVPActivity;
import com.zonelian.framework.base.presenter.IActivityPresenter;

/**
 * Created by kernel on 2017/9/3.
 * Email: 372786297@qq.com
 */

public class ThirdActivity extends MVPActivity implements ThirdView{
    private Messenger mClientMessenger = new Messenger(new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.d("ThirdActivity", "mClientMessenger handleMessage:" + msg.toString());
            super.handleMessage(msg);
        }
    });

    private Messenger mServiceMessenger = null;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mServiceMessenger = new Messenger(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public IActivityPresenter createPresenter() {
        return null;
    }

    @Override
    public int initLayout() {
        return R.layout.activity_third;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        bindService();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Message msg = Message.obtain();
                msg.what = 11;
                msg.replyTo = mClientMessenger;
                try {
                    mServiceMessenger.send(msg);
                }catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }, 2000);
    }

    private void bindService() {
        Intent intent = new Intent(this, RemoteService.class);
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
    }

    public static void launch(Context context) {
        context.startActivity(new Intent(context, ThirdActivity.class));
    }
}
