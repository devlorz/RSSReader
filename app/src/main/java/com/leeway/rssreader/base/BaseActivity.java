package com.leeway.rssreader.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.leeway.rssreader.di.ActivityComponent;
import com.leeway.rssreader.di.ActivityModule;
import com.leeway.rssreader.di.DaggerActivityComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Lee Lorz on 2/13/2017.
 */

public abstract class BaseActivity<T extends BaseMvpPresenter> extends AppCompatActivity implements BaseView {

    /**
     * Injected presenter
     */
    @Inject
    T mPresenter;

    ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResource());
        ButterKnife.bind(this);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .build();
        injectDependencies();
        mPresenter.attach(this);
        init(savedInstanceState);
    }

    /**
     * Detach presenter
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }


    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    /**
     * Getter for the presenter
     *
     * @return the present for the activity
     */
    public T getPresenter() {
        return mPresenter;
    }

    /**
     * Layout resource to be inflated
     *
     * @return layout resource
     */
    @LayoutRes
    protected abstract int getContentResource();

    /**
     * Initializations
     */
    protected abstract void init(@Nullable Bundle state);

    /**
     * Injecting dependencies
     */
    protected abstract void injectDependencies();
}


