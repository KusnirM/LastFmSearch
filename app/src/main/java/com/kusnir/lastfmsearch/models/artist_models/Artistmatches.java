
package com.kusnir.lastfmsearch.models.artist_models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artistmatches {

    @SerializedName("artist")
    @Expose
    private List<Artist> artist = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Artistmatches() {
    }

    /**
     * 
     * @param artist
     */
    public Artistmatches(List<Artist> artist) {
        super();
        this.artist = artist;
    }

    public List<Artist> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist> artist) {
        this.artist = artist;
    }

    public Artistmatches withArtist(List<Artist> artist) {
        this.artist = artist;
        return this;
    }

}
