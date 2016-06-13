package com.zonelian.framework.mvp.extend;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.zonelian.framework.mvp.MVP;

/**
 * Created by kernel on 16/6/13.
 * Email: 372786297@qq.com
 */
public interface BaseMVPPresenter extends MVP.MVPPresenter{

    public void init();

    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState);
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState);
    public void onSaveInstanceState(Bundle outState);

    public void onDestory();
}
