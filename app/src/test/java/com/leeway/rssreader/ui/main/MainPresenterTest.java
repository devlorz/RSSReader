package com.leeway.rssreader.ui.main;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by Lee Lorz on 3/4/2017.
 */

public class MainPresenterTest {

    @Mock
    private MainContract.View mView;

    private MainPresenter mMainPresenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mMainPresenter = new MainPresenter();
        mMainPresenter.attach(mView);
    }

    @Test
    public void testLoadRssItems() {
        mMainPresenter.loadRssFragments();
        verify(mView).onLoadRssFragments();
    }
}
