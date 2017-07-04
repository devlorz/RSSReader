package com.leeway.rssreader.ui.main;

import com.leeway.rssreader.base.AsyncCallbackView;
import com.leeway.rssreader.base.BaseMvpPresenter;
import com.leeway.rssreader.base.BaseView;
import com.leeway.rssreader.model.Feed;

/**
 * Created by Lee Lorz on 2/13/2017.
 */

public interface MainContract {

    // User actions. Presenter will implement
    interface Presenter extends BaseMvpPresenter<MainContract.View> {
        void loadRssFragments();
    }

    // Action callbacks. Activity/Fragment will implement
    interface View extends BaseView, AsyncCallbackView{
        void onLoadRssFragments(Feed[] feeds);
    }
}
