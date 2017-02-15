package com.leeway.rssreader.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Lee Lorz on 2/15/2017.
 */

public class Feed implements Serializable {

    @SerializedName("i") private Integer feedId;
    @SerializedName("n") private String title;
    @SerializedName("l") private String url;
    @SerializedName("e") private String encoding;

    public Integer getFeedId() {
        return feedId;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getEncoding() {
        return encoding;
    }
}
