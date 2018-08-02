package com.tritech.movies.persenter.view.detail;

import com.tritech.movies.persenter.base.BaseView;
import com.tritech.movies.persenter.model.MovieDataDetailModel;
import com.tritech.movies.persenter.model.MovieDataReviewsModel;
import com.tritech.movies.persenter.model.MovieDataTrilerModel;

import java.util.List;

public interface DetailView  extends BaseView{
    public void fetchMovieDetail(MovieDataDetailModel data);
    public void fetchMovieTrailer(List<MovieDataTrilerModel> data);
    public void fetchMovieReviews(List<MovieDataReviewsModel> data);


}
