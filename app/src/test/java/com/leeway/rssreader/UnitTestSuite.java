package com.leeway.rssreader;

import com.leeway.rssreader.ui.main.MainPresenter;
import com.leeway.rssreader.ui.main.MainPresenterTest;
import com.leeway.rssreader.ui.rss.RssPresenterTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Lee Lorz on 3/5/2017.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                MainPresenterTest.class,
                RssPresenterTest.class
        }
)
public class UnitTestSuite {
}
