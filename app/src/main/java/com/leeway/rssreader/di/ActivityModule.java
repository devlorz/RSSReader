package com.leeway.rssreader.di;

import android.content.Context;

import com.leeway.rssreader.base.BasePresenter;
import com.leeway.rssreader.chrome.ChromeTabsWrapper;
import com.leeway.rssreader.ui.main.MainContract;
import com.leeway.rssreader.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Lee Lorz on 2/14/2017.
 */

@Module
public class ActivityModule {

    private Context mContext;

    public ActivityModule(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    ChromeTabsWrapper providesChromeTabsWrapper() {
        return new ChromeTabsWrapper(mContext);
    }

    @Provides
    @Singleton
    MainContract.Presenter providesMainPresenter() {
        return new MainPresenter();
    }
}
