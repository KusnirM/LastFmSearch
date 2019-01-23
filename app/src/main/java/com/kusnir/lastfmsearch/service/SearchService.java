package com.kusnir.lastfmsearch.service;


import com.kusnir.lastfmsearch.injection.scope.ApplicationScope;
import com.kusnir.lastfmsearch.models.artist_models.ArtistResults;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

@ApplicationScope
public interface SearchService {

    @POST(".")
    Observable<ArtistResults> getArtists(@Query("method") String method,
                                         @Query("artist") String artist,
                                         @Query("limit") int limit,
                                         @Query("format") String format,
                                         @Query("api_key") String apiKey);

}
