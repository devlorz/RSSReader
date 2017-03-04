package com.leeway.rssreader.ui.main;

import com.leeway.rssreader.base.BasePresenter;

import java.util.Random;

/**
 * Created by Lee Lorz on 2/13/2017.
 */

public class MainPresenter extends BasePresenter<MainContract.View>
        implements MainContract.Presenter {

    @Override
    public void loadRssFragments() {
        getView().onLoadRssFragments();
    }
}
