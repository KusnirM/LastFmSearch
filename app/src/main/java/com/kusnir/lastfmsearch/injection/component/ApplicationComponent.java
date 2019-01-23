package com.kusnir.lastfmsearch.injection.component;

import android.content.Context;

import com.kusnir.lastfmsearch.injection.modules.ApplicationModule;
import com.kusnir.lastfmsearch.injection.modules.NetworkModule;
import com.kusnir.lastfmsearch.injection.modules.ViewModelModule;
import com.kusnir.lastfmsearch.injection.qualifier.ApplicationContext;
import com.kusnir.lastfmsearch.injection.scope.ApplicationScope;
import com.kusnir.lastfmsearch.service.DataManager;
import com.kusnir.lastfmsearch.service.SearchService;

import androidx.lifecycle.ViewModelProvider;
import dagger.Component;

@ApplicationScope
@Component(modules = {
        ApplicationModule.class,
        ViewModelModule.class,
        NetworkModule.class
        })
public interface ApplicationComponent {

    @ApplicationContext
    Context appContext();

    DataManager dataManager();

    ViewModelProvider.Factory viewModelFactory();

    SearchService searchService();

}
