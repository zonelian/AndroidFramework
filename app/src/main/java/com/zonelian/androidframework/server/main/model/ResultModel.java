package com.zonelian.androidframework.server.main.model;

import com.google.gson.annotations.SerializedName;
import com.zonelian.androidframework.server.entity.FailureMsgEntity;
import com.zonelian.framework.core.http.Result;

import java.io.Serializable;

/**
 * Created by kernel on 2016/10/26.
 * Email: 372786297@qq.com
 */

public class ResultModel<T> implements Result<T>, Serializable{
    public static final int CODE_OK = 200;
    private int code;
    private String msg;
    @SerializedName("data")
    public T data;
    public FailureMsgEntity mFailureMsgEntity;

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
        return code == CODE_OK;
    }

    public void setCode(int code) {
        this.code = code;
        if(code != 200) {
            mFailureMsgEntity = new FailureMsgEntity();
            mFailureMsgEntity.setCode(code);
        }
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public T getData() {
        return data;
    }
}
