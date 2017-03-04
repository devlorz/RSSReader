package com.leeway.rssreader.ui.rss;

import com.leeway.rssreader.app.SessionData;
import com.leeway.rssreader.model.Feed;
import com.leeway.rssreader.model.RError;
import com.leeway.rssreader.model.RssItem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

/**
 * Created by Lee Lorz on 3/5/2017.
 */

public class RssPresenterTest {

    public static final String MOCK_URL = "MOCK_URL";
    private List<RssItem> MOCK_RSS_ITEMS = new ArrayList<>();
    private Feed mFeed = new Feed();

    @Mock
    private RssContract.View mView;

    @Captor
    private ArgumentCaptor<List<RssItem>> mCaptorRssItems;

    @Captor
    private ArgumentCaptor<RError> mCaptorError;

    private RssPresenter mRssPresenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        generateMockRssItems();

        SessionData sessionData = new SessionData();
        mRssPresenter = new RssPresenter(sessionData);
        mRssPresenter.getSessionData().addContent(
                MOCK_URL,
                MOCK_RSS_ITEMS
        );
        mRssPresenter.attach(mView);
    }

    private void generateMockRssItems() {
        RssItem rssItem = new RssItem();
        rssItem.setUrl("http://");
        rssItem.setTitle("title");
        rssItem.setDescription("description");

        MOCK_RSS_ITEMS.add(rssItem);

        mFeed.setUrl(MOCK_URL);
    }

    @Test
    public void testLoadRssItems() {
        mRssPresenter.onSuccess(MOCK_RSS_ITEMS, MOCK_URL);
        verify(mView).onRssItemLoaded(mCaptorRssItems.capture());
        verify(mView).hideLoading();

        assertTrue(mCaptorRssItems.getValue()
                .equals(MOCK_RSS_ITEMS));
    }

    @Test
    public void testLoadRssItemsFromCache() {
        mRssPresenter.loadRssItems(mFeed, true);
        verify(mView).onRssItemLoaded(MOCK_RSS_ITEMS);
    }

    @Test
    public void testLoadFail() {
        mRssPresenter.onFail(MOCK_URL);
        verify(mView).hideLoading();
        verify(mView).onFail(mCaptorError.capture());

        assertTrue(mCaptorError.getValue()
                .getMessage()
                .equals(RError.ERROR_FETCH));
    }
}
