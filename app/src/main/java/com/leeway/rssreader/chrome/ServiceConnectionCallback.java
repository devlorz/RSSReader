package com.leeway.rssreader.chrome;

import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;

/**
 * Created by Lee Lorz on 2/14/2017.
 */

public interface ServiceConnectionCallback {

    /**
     * Called when the service is connected.
     * @param client a CustomTabsClient
     */
    void onServiceConnected(CustomTabsClient client);

    /**
     * Called when the service is disconnected
     */
    void onServiceDisconnected();
}
