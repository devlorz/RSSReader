package com.leeway.rssreader.di.component;

import com.leeway.rssreader.RssApplication;
import com.leeway.rssreader.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Lee Lorz on 2/17/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(RssApplication rssApplication);
}
