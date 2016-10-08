package com.zonelian.androidframework.module;

import com.zonelian.androidframework.App;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kernel on 16/7/9.
 * Email: 372786297@qq.com
 */
@Module
public class AppModule {
    private App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides App getApplication() {
        return application;
    }
}
