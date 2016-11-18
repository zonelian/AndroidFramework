package com.zonelian.androidframework.demo.base.datasource.local.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by kernel on 2016/11/17.
 * Email: 372786297@qq.com
 */
@Entity
public class User {
    private String name;

    @Generated(hash = 422536127)
    public User(String name) {
        this.name = name;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
