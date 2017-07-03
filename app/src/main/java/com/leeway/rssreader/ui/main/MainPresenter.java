package com.leeway.rssreader.ui.main;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.leeway.rssreader.api.RssService;
import com.leeway.rssreader.base.BasePresenter;
import com.leeway.rssreader.model.Feed;

import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lee Lorz on 2/13/2017.
 */

public class MainPresenter extends BasePresenter<MainContract.View>
        implements MainContract.Presenter {

    @Override
    public void loadRssFragments() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://rssreader-6137f.firebaseio.com/")
                .build();
        RssService rssService = retrofit.create(RssService.class);
        Observable<Feed[]> feedListObservable = rssService.getFeed();
        feedListObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Feed[]>() {
                    @Override
                    public void accept(@NonNull Feed[] feeds) throws Exception {
                        getView().onLoadRssFragments(feeds);
                    }
                });
    }
}
