package com.leeway.rssreader.base;

/**
 * Created by Lee Lorz on 2/13/2017.
 */

public class BasePresenter<V extends BaseView> implements BaseMvpPresenter<V> {

    /**
     *
     * @param view
     */
    V mView;

    @Override
    public void attach(V view) {
        mView = view;
    }

    @Override
    public void detach() {
        mView = null;
    }

    @Override
    public boolean isAttached() {
        return mView != null;
    }

    public V getView() {
        return mView;
    }
}
