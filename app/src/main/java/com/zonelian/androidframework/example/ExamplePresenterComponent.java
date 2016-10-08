package com.zonelian.androidframework.example;

import com.zonelian.androidframework.component.Injector;

import dagger.Component;

/**
 * Created by kernel on 16/7/9.
 * Email: 372786297@qq.com
 */
@Component(dependencies = ExampleRepositoryComponent.class,
        modules = ExamplePresenterModule.class)
public interface ExamplePresenterComponent extends Injector<ExampleActivity>{

    @Override
    void inject(ExampleActivity template);
}
