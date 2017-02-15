package com.leeway.rssreader.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.leeway.rssreader.di.component.DaggerFragmentComponent;
import com.leeway.rssreader.di.component.FragmentComponent;

import javax.inject.Inject;

/**
 * Created by Lee Lorz on 2/15/2017.
 */

public abstract class BaseFragment<T extends BaseMvpPresenter> extends Fragment implements BaseView {

    @Inject
    T mPresenter;

    FragmentComponent mFragmentComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mFragmentComponent = DaggerFragmentComponent.builder()
    }
}
