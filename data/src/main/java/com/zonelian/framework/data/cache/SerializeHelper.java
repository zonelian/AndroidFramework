package com.zonelian.framework.data.cache;

import android.text.TextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by kernel on 16/7/15.
 * Email: 372786297@qq.com
 */
public class SerializeHelper {
//    private static SerializeHelper sInstance;
//
//    public static SerializeHelper getInstance() {
//        if(sInstance == null) {
//            synchronized (SerializeHelper.class) {
//                sInstance = new SerializeHelper();
//            }
//        }
//        return sInstance;
//    }
//
//    private SerializeHelper() {
//    }

    public void putSerializable(String filePath, Object obj) {
        if(!TextUtils.isEmpty(filePath) || obj == null) {
            return;
        }
        File f = new File(filePath);
        try {
            if( f.exists()) {
                f.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getSerializable(String filePath) {
        if(TextUtils.isEmpty(filePath)) {
            return null;
        }
        File f = new File(filePath);
        if(!f.exists()) {
            return null;
        }
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return ois.readObject();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
