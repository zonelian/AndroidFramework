package com.zonelian.androidframework.demo.second.remote.entity;

/**
 * Created by kernel on 2016/10/26.
 * Email: 372786297@qq.com
 */

public class FailureMsgEntity {
    public static final int CODE_NOT_NEW = 211;
    public static final int CODE_NOT_MORE = 212;

    private int mCode;

    public int getCode() {
        return mCode;
    }

    public void setCode(int mCode) {
        this.mCode = mCode;
    }

    public boolean isNotNew() {
        return mCode == CODE_NOT_NEW;
    }

    public boolean isNotMore() {
        return mCode == CODE_NOT_MORE;
    }
}
