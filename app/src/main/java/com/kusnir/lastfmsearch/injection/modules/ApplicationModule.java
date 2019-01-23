package com.kusnir.lastfmsearch.injection.modules;

import android.content.Context;

import com.kusnir.lastfmsearch.LastFmSearchApp;
import com.kusnir.lastfmsearch.injection.qualifier.ApplicationContext;
import com.kusnir.lastfmsearch.injection.scope.ApplicationScope;
import com.kusnir.lastfmsearch.service.DataManager;
import com.kusnir.lastfmsearch.service.DataManagerImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final LastFmSearchApp lastFmSearchApp;


    public ApplicationModule(LastFmSearchApp lastFmSearchApp) {
        this.lastFmSearchApp = lastFmSearchApp;
    }

    @ApplicationScope
    @ApplicationContext
    @Provides
    Context provideApplicationContext() {
        return lastFmSearchApp;
    }

    @ApplicationScope
    @Provides DataManager provideDataManager(DataManagerImpl dataManager) {
        return dataManager;
    }

}
