package com.zonelian.androidframework.component;

import com.zonelian.androidframework.App;
import com.zonelian.androidframework.module.AppModule;

import dagger.Component;

/**
 * Created by kernel on 16/7/9.
 * Email: 372786297@qq.com
 */
@Component(dependencies = AppRepositoryComponent.class,
        modules = AppModule.class)
public interface AppComponent extends Injector<App>{
    @Override
    void inject(App template);
}
