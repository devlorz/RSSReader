package com.leeway.rssreader.di.module;

import com.leeway.rssreader.app.SessionData;
import com.leeway.rssreader.ui.rss.RssContract;
import com.leeway.rssreader.ui.rss.RssPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Lee Lorz on 2/15/2017.
 */

@Module
public class FragmentModule {

    @Provides
    RssContract.Presenter providesRssPresenter(SessionData sessionData) {
        return new RssPresenter(sessionData);
    }
}
