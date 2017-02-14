package com.leeway.rssreader.base;

import android.support.v4.app.Fragment;

import javax.inject.Inject;

/**
 * Created by Lee Lorz on 2/15/2017.
 */

public abstract class BaseFragment<T extends BaseMvpPresenter> extends Fragment implements BaseView {

    @Inject
    T mPresenter;

    //Fra
}
