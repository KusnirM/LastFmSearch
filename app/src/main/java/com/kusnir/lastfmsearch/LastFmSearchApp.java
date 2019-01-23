package com.kusnir.lastfmsearch;

import android.app.Application;

import com.kusnir.lastfmsearch.injection.component.ApplicationComponent;
import com.kusnir.lastfmsearch.injection.component.DaggerApplicationComponent;
import com.kusnir.lastfmsearch.injection.modules.ApplicationModule;

public class LastFmSearchApp extends Application {

    private static LastFmSearchApp instance;
    private ApplicationComponent applicationComponent;

    public static LastFmSearchApp getInstance() {
        return instance;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
