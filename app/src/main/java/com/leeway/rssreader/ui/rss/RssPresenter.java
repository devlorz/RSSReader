package com.leeway.rssreader.ui.rss;

import com.leeway.rssreader.app.SessionData;
import com.leeway.rssreader.base.BasePresenter;
import com.leeway.rssreader.model.Feed;
import com.leeway.rssreader.model.RError;
import com.leeway.rssreader.model.RssItem;
import com.leeway.rssreader.parser.RssReader;
import com.leeway.rssreader.util.Logger;
import com.squareup.leakcanary.CanaryLog;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Lee Lorz on 2/15/2017.
 */

public class RssPresenter extends BasePresenter<RssContract.View> implements RssContract.Presenter
            , OnRssParserListener {

    private SessionData mSessionData;

    @Inject
    public RssPresenter(SessionData sessionData) {
        mSessionData = sessionData;
    }

    @Override
    public void loadRssItems(Feed feed, boolean fromCache) {
        if (mSessionData.hasUrl(feed.getUrl()) && fromCache) {
//            Logger.logv("Read from cache: " + feed.getUrl());
            getView().onRssItemLoaded(mSessionData.getContent(feed.getUrl()));
        } else {
            RssReader request = new RssReader(this, feed.getUrl());
            request.execute();
            getView().showLoading();
        }
    }

    @Override
    public void browseRssUrl(RssItem rssItem) {
        if (isAttached()) {
            getView().onBrowse(rssItem);
        }
    }

    @Override
    public void onSuccess(List<RssItem> rssItemList, String rssUrl) {
        mSessionData.addContent(rssUrl, rssItemList);
        if (isAttached()) {
            getView().onRssItemLoaded(rssItemList);
            getView().hideLoading();
        }
    }

    @Override
    public void onFail(String rssUrl) {
        if (isAttached()) {
            getView().hideLoading();
            getView().onFail(new RError("Failed to fetch RSS!"));
        }
    }

    public SessionData getSessionData() {
        return mSessionData;
    }
}
