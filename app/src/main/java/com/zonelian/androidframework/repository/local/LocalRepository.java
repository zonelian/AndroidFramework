package com.zonelian.androidframework.repository.local;

import com.zonelian.androidframework.repository.BasicRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kernel on 16/7/9.
 * Email: 372786297@qq.com
 */
public class LocalRepository extends BasicRepository{

    private Map<String, Object> mCaches;

    public LocalRepository() {
        mCaches = new HashMap<>();
    }

    @Override
    public Object get(String key) {
        return mCaches.get(key);
    }

    @Override
    public void put(String key, Object data) {
        mCaches.put(key, data);
    }
}
