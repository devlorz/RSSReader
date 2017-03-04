package com.leeway.rssreader.model;

/**
 * Created by Lee Lorz on 3/5/2017.
 */

public class RError {

    public static final String ERROR_FETCH = "Failed to fetch RSS!";

    private final String mMessage;

    public RError(String message) {
        mMessage = message;
    }

    public String getMessage() {
        return mMessage;
    }
}
