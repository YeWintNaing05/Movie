package com.tritech.movies.data.net.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tritech.movies.data.net.model.Dates;
import com.tritech.movies.data.net.model.MoviesInfo;

import java.util.List;

public class MoviesResponse {

    @SerializedName("results")
    @Expose
    private List<MoviesInfo> results = null;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("dates")
    @Expose
    private Dates dates;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;

    public List<MoviesInfo> getResults() {
        return results;
    }

    public void setResults(List<MoviesInfo> results) {
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
