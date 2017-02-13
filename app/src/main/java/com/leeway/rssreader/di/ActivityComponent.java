package com.leeway.rssreader.di;

import com.leeway.rssreader.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Lee Lorz on 2/14/2017.
 */

@Singleton
@Component(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity obj);

}
