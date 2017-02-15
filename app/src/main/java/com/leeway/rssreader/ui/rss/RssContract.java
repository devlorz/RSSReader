package com.leeway.rssreader.ui.rss;

import com.leeway.rssreader.base.AsyncCallbackView;
import com.leeway.rssreader.base.BaseMvpPresenter;
import com.leeway.rssreader.base.BaseView;
import com.leeway.rssreader.model.Feed;
import com.leeway.rssreader.model.RssItem;

import java.util.List;

/**
 * Created by Lee Lorz on 2/15/2017.
 */

public interface RssContract {

    // User actions. Presenter will implement
    interface Presenter extends BaseMvpPresenter<RssContract.View> {
        void loadRssItems(Feed feed, boolean fromCache);
        void browseRssUrl(RssItem rssItem);
    };

    // Action callbacks. Activity/Fragment will implement
    interface View extends BaseView, AsyncCallbackView {
        void onRssItemLoaded(List<RssItem> rssItems);
        void onBrowse(RssItem rssItem);
    }
}
