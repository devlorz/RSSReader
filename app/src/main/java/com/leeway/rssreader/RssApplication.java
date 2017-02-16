package com.leeway.rssreader;

import android.app.Application;

import com.leeway.rssreader.app.SessionData;
import com.leeway.rssreader.di.component.ApplicationComponent;
import com.leeway.rssreader.di.component.DaggerApplicationComponent;
import com.leeway.rssreader.di.module.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

import javax.inject.Inject;

/**
 * Created by Lee Lorz on 2/14/2017.
 */

public class RssApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Inject
    SessionData mSessionData;

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public SessionData getSessionData() {
        return mSessionData;
    }
}
