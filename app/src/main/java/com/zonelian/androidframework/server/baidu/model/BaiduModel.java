package com.zonelian.androidframework.server.baidu.model;

import com.google.gson.annotations.SerializedName;
import com.zonelian.framework.http.core.Result;

import java.io.Serializable;

/**
 * Created by kernel on 2016/10/29.
 * Email: 372786297@qq.com
 */

public class BaiduModel<T> implements Result<T>, Serializable {
    @SerializedName("errNum")
    private int code;
    @SerializedName("retMsg")
    private String msg;
    @SerializedName("retData")
    public T data;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public boolean isOk() {
        return code == 0;
    }

    @Override
    public T getData() {
        return data;
    }
}
