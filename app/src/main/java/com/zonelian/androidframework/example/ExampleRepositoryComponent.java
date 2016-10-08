package com.zonelian.androidframework.example;

import dagger.Component;

/**
 * Created by kernel on 16/7/9.
 * Email: 372786297@qq.com
 */
@Component(modules = ExampleRepositoryModule.class)
public interface ExampleRepositoryComponent {

    ExampleRepository getExampleRepository();
}
