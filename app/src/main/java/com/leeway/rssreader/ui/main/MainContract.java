package com.leeway.rssreader.ui.main;

import com.leeway.rssreader.base.BaseMvpPresenter;
import com.leeway.rssreader.base.BaseView;

/**
 * Created by Lee Lorz on 2/13/2017.
 */

public interface MainContract {

    // User actions. Presenter will implement
    interface Presenter extends BaseMvpPresenter<MainContract.View> {
        void loadHelloText();
    }

    // Action callbacks. Activity/Fragment will implement
    interface View extends BaseView {
        void onTextLoaded(String text);
    }
}
