package com.leeway.rssreader.ui.rss;

import com.leeway.rssreader.model.RssItem;

import java.util.List;

/**
 * Created by Lee Lorz on 2/15/2017.
 */

public interface OnRssParserListener {

    void onSuccess(List<RssItem> rssItemList, String rssUrl);

    void onFail(String rssUrl);
}
