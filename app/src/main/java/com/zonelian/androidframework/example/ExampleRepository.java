package com.zonelian.androidframework.example;

import com.zonelian.androidframework.repository.local.LocalRepository;

import javax.inject.Inject;

/**
 * Created by kernel on 16/7/9.
 * Email: 372786297@qq.com
 */
public class ExampleRepository extends LocalRepository{

    @Inject
    public ExampleRepository() {
        super();
    }
}
