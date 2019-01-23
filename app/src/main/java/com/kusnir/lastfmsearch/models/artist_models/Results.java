
package com.kusnir.lastfmsearch.models.artist_models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {


    @SerializedName("opensearch:Query")
    @Expose
    private OpensearchQuery opensearchQuery;
    @SerializedName("opensearch:totalResults")
    @Expose
    private String opensearchTotalResults;
    @SerializedName("opensearch:startIndex")
    @Expose
    private String opensearchStartIndex;
    @SerializedName("opensearch:itemsPerPage")
    @Expose
    private String opensearchItemsPerPage;
    @SerializedName("artistmatches")
    @Expose
    private Artistmatches artistmatches;
    @SerializedName("attr")
    @Expose
    private Attr attr;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Results() {
    }

    /**
     * 
     * @param opensearchItemsPerPage
     * @param opensearchQuery
     * @param artistmatches
     * @param opensearchStartIndex
     * @param attr
     * @param opensearchTotalResults
     */
    public Results(OpensearchQuery opensearchQuery, String opensearchTotalResults, String opensearchStartIndex, String opensearchItemsPerPage, Artistmatches artistmatches, Attr attr) {
        super();
        this.opensearchQuery = opensearchQuery;
        this.opensearchTotalResults = opensearchTotalResults;
        this.opensearchStartIndex = opensearchStartIndex;
        this.opensearchItemsPerPage = opensearchItemsPerPage;
        this.artistmatches = artistmatches;
        this.attr = attr;
    }

    public OpensearchQuery getOpensearchQuery() {
        return opensearchQuery;
    }

    public void setOpensearchQuery(OpensearchQuery opensearchQuery) {
        this.opensearchQuery = opensearchQuery;
    }

    public Results withOpensearchQuery(OpensearchQuery opensearchQuery) {
        this.opensearchQuery = opensearchQuery;
        return this;
    }

    public String getOpensearchTotalResults() {
        return opensearchTotalResults;
    }

    public void setOpensearchTotalResults(String opensearchTotalResults) {
        this.opensearchTotalResults = opensearchTotalResults;
    }

    public Results withOpensearchTotalResults(String opensearchTotalResults) {
        this.opensearchTotalResults = opensearchTotalResults;
        return this;
    }

    public String getOpensearchStartIndex() {
        return opensearchStartIndex;
    }

    public void setOpensearchStartIndex(String opensearchStartIndex) {
        this.opensearchStartIndex = opensearchStartIndex;
    }

    public Results withOpensearchStartIndex(String opensearchStartIndex) {
        this.opensearchStartIndex = opensearchStartIndex;
        return this;
    }

    public String getOpensearchItemsPerPage() {
        return opensearchItemsPerPage;
    }

    public void setOpensearchItemsPerPage(String opensearchItemsPerPage) {
        this.opensearchItemsPerPage = opensearchItemsPerPage;
    }

    public Results withOpensearchItemsPerPage(String opensearchItemsPerPage) {
        this.opensearchItemsPerPage = opensearchItemsPerPage;
        return this;
    }

    public Artistmatches getArtistmatches() {
        return artistmatches;
    }

    public void setArtistmatches(Artistmatches artistmatches) {
        this.artistmatches = artistmatches;
    }

    public Results withArtistmatches(Artistmatches artistmatches) {
        this.artistmatches = artistmatches;
        return this;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

    public Results withAttr(Attr attr) {
        this.attr = attr;
        return this;
    }
}
