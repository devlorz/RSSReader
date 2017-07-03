package com.leeway.rssreader.api;

import com.leeway.rssreader.model.Feed;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Lee Lorz on 7/3/2017.
 */

public interface RssService {

    @GET("feed.json")
    Observable<Feed[]> getFeed();
}
