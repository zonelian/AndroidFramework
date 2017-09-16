package com.zonelian.framework.data.cache;

/**
 * Created by kernel on 16/7/11.
 * Email: 372786297@qq.com
 */
public interface Cache<K, V> {
    V get(K key);
    void put(K key, V value);
    void clear(K key);
}
