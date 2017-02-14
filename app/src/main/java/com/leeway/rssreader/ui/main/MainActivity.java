package com.leeway.rssreader.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.leeway.rssreader.R;
import com.leeway.rssreader.base.BaseActivity;
import com.leeway.rssreader.chrome.ChromeTabsWrapper;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements
        MainContract.View {


    @BindView(R.id.tvHello)
    TextView mTextView;

    @Inject
    ChromeTabsWrapper mChromeTabsWrapper;

    @Override
    protected int getContentResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(@Nullable Bundle state) {
        getPresenter().loadHelloText();
    }

    @Override
    protected void injectDependencies() {
        getActivityComponent().inject(this);
    }

    @Override
    public void onTextLoaded(String text) {
        mTextView.setText(text);
    }

    @OnClick(R.id.tvHello)
    public void onClick() {
        getPresenter().loadHelloText();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mChromeTabsWrapper.bindCustomTabsService();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mChromeTabsWrapper.unbindCustomTabsService();
    }
}
