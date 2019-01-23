package com.kusnir.lastfmsearch.injection.modules;

import com.kusnir.lastfmsearch.injection.scope.ApplicationScope;
import com.kusnir.lastfmsearch.ui.artist_detail.ArtistDetailViewModel;
import com.kusnir.lastfmsearch.ui.search.SearchViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public class ViewModelModule {

    @ApplicationScope
    @Provides
    ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory) {
        return viewModelFactory;
    }

    @Provides
    @IntoMap
    @ViewModelKey(SearchViewModel.class)
    ViewModel bindSearchViewModel(SearchViewModel searchViewModel) {
        return searchViewModel;
    }

    @Provides
    @IntoMap
    @ViewModelKey(ArtistDetailViewModel.class)
    ViewModel bindArtistDetailViewModel(ArtistDetailViewModel artistDetailViewModel) {
        return artistDetailViewModel;
    }
}