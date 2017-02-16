package com.leeway.rssreader.util;

import android.support.annotation.Nullable;

/**
 * Created by Lee Lorz on 2/17/2017.
 */

public class NullUtils {

    public static boolean notEmpty(@Nullable String string) {
        return string != null && string.length() > 0;
    }
}
