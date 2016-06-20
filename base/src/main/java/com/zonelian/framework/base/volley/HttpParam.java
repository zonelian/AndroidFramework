package com.zonelian.framework.base.volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kernel on 16/6/13.
 * Email: 372786297@qq.com
 */
public class HttpParam {
    private Map<String, String> values;

    public HttpParam() {
        this.values = new HashMap<>();
    }

    public void put(String key, String value) {
        values.put(key, value);
    }

    public String get(String key) {
        return values.get(key);
    }

    public void set(Map<String, String> values) {
        this.values = values;
    }

    public Map<String, String> get() {
        return this.values;
    }
}
