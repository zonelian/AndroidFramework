package com.zonelian.framework.data.cache;

import android.support.v4.util.ArrayMap;
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
public class FileHelper {
    private ArrayMap<String, Cache> mCaChes;
    private static FileHelper sInstance;

    public static FileHelper getInstance() {
        if(sInstance == null) {
            synchronized (FileHelper.class) {
                sInstance = new FileHelper();
            }
        }
        return sInstance;
    }

    private FileHelper() {
        mCaChes = new ArrayMap<>();
    }

    public boolean isRegisted(String key) {
        if(mCaChes.containsKey(key)) {
            return true;
        }
        return false;
    }

    public boolean registerCache(String key, Cache cache) {
        if(mCaChes.containsKey(key)) {
            return false;
        }
        mCaChes.put(key, cache);
        return true;
    }

    public boolean unregisterCache(String key) {
        if( !mCaChes.containsKey(key)) {
            return false;
        }
        mCaChes.remove(key);
        return true;
    }

    public Object get(String cacheKey, Object key) {
        if(isRegisted(cacheKey)) {
            return mCaChes.get(cacheKey).get(key);
        }else {
            return null;
        }
    }

    public void put(String cacheKey, Object key, Object value) {
        if(isRegisted(cacheKey)) {
            mCaChes.get(cacheKey).put(key, value);
        }
    }

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
