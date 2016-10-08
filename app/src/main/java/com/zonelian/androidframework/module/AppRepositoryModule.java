package com.zonelian.androidframework.module;

import com.zonelian.androidframework.repository.AppRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kernel on 16/7/9.
 * Email: 372786297@qq.com
 */
@Module
public class AppRepositoryModule {

    @Provides
    AppRepository provideAppRepository() {
        return new AppRepository();
    }
}
