
package com.kusnir.lastfmsearch.models.artist_models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artist {

    public static final String TYPE = "ARTIST_TYPE";


    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("listeners")
    @Expose
    private String listeners;
    @SerializedName("mbid")
    @Expose
    private String mbid;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("streamable")
    @Expose
    private String streamable;
    @SerializedName("image")
    @Expose
    private List<Image> image = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Artist() {
    }

    /**
     * 
     * @param listeners
     * @param mbid
     * @param name
     * @param image
     * @param streamable
     * @param url
     */
    public Artist(String name, String listeners, String mbid, String url, String streamable, List<Image> image) {
        super();
        this.name = name;
        this.listeners = listeners;
        this.mbid = mbid;
        this.url = url;
        this.streamable = streamable;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist withName(String name) {
        this.name = name;
        return this;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public Artist withListeners(String listeners) {
        this.listeners = listeners;
        return this;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public Artist withMbid(String mbid) {
        this.mbid = mbid;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Artist withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    public Artist withStreamable(String streamable) {
        this.streamable = streamable;
        return this;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public Artist withImage(List<Image> image) {
        this.image = image;
        return this;
    }

}
