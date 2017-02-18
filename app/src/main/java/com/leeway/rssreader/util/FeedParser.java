package com.leeway.rssreader.util;

import android.content.Context;

import com.google.gson.Gson;
import com.leeway.rssreader.model.Feed;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Lee Lorz on 2/18/2017.
 */

public class FeedParser {

    private static final String RSS_FILE = "rss.json";

    public FeedParser() {
    }

    public List<Feed> parseFeeds(Context context) {
        String jsonString = Utils.readFromAssets(context, RSS_FILE);
        Gson gson = new Gson();
        Feed[] feeds = gson.fromJson(jsonString, Feed[].class);
        return Arrays.asList(feeds);
    }
}
