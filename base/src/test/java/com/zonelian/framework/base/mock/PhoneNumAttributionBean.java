package com.zonelian.framework.base.mock;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kernel on 16/6/28.
 * Email: 372786297@qq.com
 */
public class PhoneNumAttributionBean implements Result{
    @SerializedName("showapi_res_code")
    public int code;
    @SerializedName("showapi_res_error")
    public String msg;

    @SerializedName("showapi_res_body")
    public PhoneNumAttributionData data;


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return null;
    }

    @Override
    public boolean isOk() {
        return getCode() == 0;
    }
}
