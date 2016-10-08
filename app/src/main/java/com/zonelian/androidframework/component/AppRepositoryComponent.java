package com.zonelian.androidframework.component;

import com.zonelian.androidframework.module.AppRepositoryModule;
import com.zonelian.androidframework.repository.AppRepository;

import dagger.Component;

/**
 * Created by kernel on 16/7/9.
 * Email: 372786297@qq.com
 */
@Component(modules = AppRepositoryModule.class)
public interface AppRepositoryComponent {

    public AppRepository getAppRepository();
}
