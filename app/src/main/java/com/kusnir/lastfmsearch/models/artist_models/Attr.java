
package com.kusnir.lastfmsearch.models.artist_models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attr {

    @SerializedName("for")
    @Expose
    private String _for;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attr() {
    }

    /**
     * 
     * @param _for
     */
    public Attr(String _for) {
        super();
        this._for = _for;
    }

    public String getFor() {
        return _for;
    }

    public void setFor(String _for) {
        this._for = _for;
    }

    public Attr withFor(String _for) {
        this._for = _for;
        return this;
    }

}
