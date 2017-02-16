package com.leeway.rssreader.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leeway.rssreader.di.component.DaggerFragmentComponent;
import com.leeway.rssreader.di.component.FragmentComponent;
import com.leeway.rssreader.di.module.FragmentModule;

import javax.inject.Inject;

import butterknife.ButterKnife;

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
        mFragmentComponent = DaggerFragmentComponent.builder()
                .fragmentModule(new FragmentModule())
                .build();
        injectDependencies();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentResource(), container, false);
        ButterKnife.bind(this, view);
        mPresenter.attach(this);
        init(savedInstanceState);
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.detach();
    }

    public FragmentComponent getFragmentComponent() {
        return mFragmentComponent;
    }

    /**
     * Getter for the presenter
     *
     * @return the present for the fragment
     */
    protected T getPresenter() {
        return mPresenter;
    }

    /**
     * Initializations
     *
     * @param state
     */
    protected abstract void init(@Nullable Bundle state);

    /**
     * Layout resource to be inflated
     *
     * @return
     */
    @LayoutRes
    protected abstract int getContentResource();

    /**
     * Injecting dependencies
     */
    protected abstract void injectDependencies();
}
