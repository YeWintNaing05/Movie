package com.tritech.movies.data.net.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tritech.movies.data.net.model.Trailer;

import java.util.List;

public class TrailerResponse {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("results")
    @Expose
    private List<Trailer> results = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Trailer> getTrailers() {
        return results;
    }

    public void setTrailers(List<Trailer> results) {
        this.results = results;
    }
}
