package com.zonelian.androidframework.repository;

import com.zonelian.androidframework.repository.local.LocalRepository;

import javax.inject.Inject;

/**
 * Created by kernel on 16/7/9.
 * Email: 372786297@qq.com
 */
public class AppRepository extends LocalRepository{

    @Inject
    public AppRepository() {
        super();
    }
}
