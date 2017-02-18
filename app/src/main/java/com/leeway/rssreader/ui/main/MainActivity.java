package com.leeway.rssreader.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.leeway.rssreader.R;
import com.leeway.rssreader.base.BaseActivity;
import com.leeway.rssreader.chrome.ChromeTabsWrapper;
import com.leeway.rssreader.model.Feed;
import com.leeway.rssreader.model.RssItem;
import com.leeway.rssreader.ui.rss.RssFragment;
import com.leeway.rssreader.ui.rss.RssFragmentAdapter;
import com.leeway.rssreader.util.FeedParser;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements
        MainContract.View , RssFragment.OnItemSelectListener{

    @Inject
    ChromeTabsWrapper mChromeTabsWrapper;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tablayout)
    TabLayout mTablayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    @Override
    protected int getContentResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(@Nullable Bundle state) {
        getPresenter().loadRssFragments();
    }

    @Override
    protected void injectDependencies() {
        getActivityComponent().inject(this);
    }

    @Override
    public void onLoadRssFragments() {
        setUpViewPager();
    }

    private void setUpViewPager() {
        List<RssFragment> fragmentList = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (Feed feed :
                new FeedParser().parseFeeds(this)) {
            titles.add(feed.getTitle());
        }

        RssFragmentAdapter adapter = new RssFragmentAdapter(getSupportFragmentManager()
                , fragmentList, titles);
        mViewPager.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mChromeTabsWrapper.bindCustomTabsService();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mChromeTabsWrapper.unbindCustomTabsService();
    }

    @Override
    public void onItemSelected(RssItem rssItem) {
        mChromeTabsWrapper.openCustomtab(rssItem.getUrl());
    }

}
