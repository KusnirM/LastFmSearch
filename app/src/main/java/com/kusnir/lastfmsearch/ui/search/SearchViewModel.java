package com.kusnir.lastfmsearch.ui.search;


import com.kusnir.lastfmsearch.models.artist_models.ArtistResults;
import com.kusnir.lastfmsearch.service.DataManager;
import com.kusnir.lastfmsearch.ui.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.Observable;

public class SearchViewModel extends BaseViewModel {

    private final DataManager dataManager;

    @Inject
    public SearchViewModel(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public Observable<ArtistResults> searchKeyword(String keyword) {
        return dataManager.searchArtist(keyword);
    }

}