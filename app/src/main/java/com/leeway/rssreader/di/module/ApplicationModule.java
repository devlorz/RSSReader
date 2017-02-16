package com.leeway.rssreader.di.module;

import com.leeway.rssreader.RssApplication;
import com.leeway.rssreader.app.SessionData;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Lee Lorz on 2/17/2017.
 */

@Module
public class ApplicationModule {

    private final RssApplication mApplication;

    public ApplicationModule(RssApplication application) {
        mApplication = application;
    }

    @Provides
    RssApplication providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    SessionData providesSessionData() {
        return new SessionData();
    }
}
