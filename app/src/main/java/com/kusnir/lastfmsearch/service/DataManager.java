package com.kusnir.lastfmsearch.service;


import com.kusnir.lastfmsearch.models.artist_models.ArtistResults;

import io.reactivex.Observable;

public interface DataManager {

    Observable<ArtistResults> searchArtist(String artistName);

}
