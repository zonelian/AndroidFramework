package com.zonelian.androidframework.demo.first;

import com.zonelian.androidframework.demo.base.app.BaseAppView;

import java.util.List;

/**
 * Created by kernel on 2016/10/30.
 * Email: 372786297@qq.com
 */

public interface FirstView extends BaseAppView{
    String getInsertName();
    void showInsertEnable(boolean enable);
    void showQueryEnable(boolean enable);
    void showQuerying();
    void showQueryComplete();
    void showQueryResult(List<UserData> result);
}
