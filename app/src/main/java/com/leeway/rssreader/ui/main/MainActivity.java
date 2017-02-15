package com.leeway.rssreader.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.leeway.rssreader.R;
import com.leeway.rssreader.base.BaseActivity;
import com.leeway.rssreader.chrome.ChromeTabsWrapper;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements
        MainContract.View {

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
        //List<>
    }

    @Override
    protected void onStart() {
        super.onStart();
        mChromeTabsWrapper.bindCustomTabsService();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mChromeTabsWrapper.unbindCustomTabsService();
    }

}
