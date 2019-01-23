package com.kusnir.lastfmsearch.service;

import com.kusnir.lastfmsearch.injection.scope.ApplicationScope;
import com.kusnir.lastfmsearch.models.artist_models.ArtistResults;
import com.kusnir.lastfmsearch.util.Constants;

import javax.inject.Inject;

import io.reactivex.Observable;

@ApplicationScope
public class DataManagerImpl implements DataManager {

    private final SearchService searchService;

    @Inject
    public DataManagerImpl(SearchService searchService) {
        this.searchService = searchService;
    }

    @Override
    public Observable<ArtistResults> searchArtist(String artistName) {
        return searchService.getArtists(Constants.ARTIST_METHOD,
                artistName,
                Constants.LIMIT,
                Constants.FORMAT,
                Constants.API_KEY);
    }
}