package com.zonelian.androidframework.demo.third;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by kernel on 2017/9/3.
 * Email: 372786297@qq.com
 */

public class RemoteService extends Service {

    private Messenger mMessenger = new Messenger(new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.d("RemoteService", "messenger handleMessage:" + msg.toString());
            Message reply = Message.obtain();
            reply.what = 12;
            try {
                msg.replyTo.send(reply);
            }catch (RemoteException e) {
                e.printStackTrace();
            }
            super.handleMessage(msg);
        }
    });

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
