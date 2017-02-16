package com.leeway.rssreader.di.component;

import com.leeway.rssreader.di.module.FragmentModule;
import com.leeway.rssreader.ui.rss.RssFragment;

import dagger.Component;

/**
 * Created by Lee Lorz on 2/15/2017.
 */

@Component(modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(RssFragment obj);
}
