package com.zonelian.androidframework.example;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kernel on 16/7/9.
 * Email: 372786297@qq.com
 */
@Module
public class ExamplePresenterModule {
    ExampleView mView;

    public ExamplePresenterModule(ExampleView mView) {
        this.mView = mView;
    }

    @Provides ExampleView provideExampleView() {
        return mView;
    }
}
