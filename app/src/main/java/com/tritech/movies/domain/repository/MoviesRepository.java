package com.tritech.movies.domain.repository;


import com.tritech.movies.domain.model.MovieDomainDetailModel;
import com.tritech.movies.domain.model.MovieDomainModel;
import com.tritech.movies.domain.model.MovieTrailersDomainModel;
import com.tritech.movies.domain.model.ReviewDomainModel;

import java.util.List;

import io.reactivex.Observable;

public interface MoviesRepository {

    //get movies list
    Observable<List<MovieDomainModel>> fetchDataNowPlaying(String api_key);
    Observable<List<MovieDomainModel>> fetchDataPopular(String api_key);
    Observable<List<MovieDomainModel>> fetchDataUpcoming(String api_key);

    //get movies detail
    Observable<MovieDomainDetailModel>  fetchDataMovieDetail(long movieId, String api_key);

    //get movies trialers
    Observable<List<MovieTrailersDomainModel>>  fetchDataMovieTrailer(long movieId, String api_key);

    //get movie reviews
    Observable<List<ReviewDomainModel>>  fetchDataMovieReview(long movieId, String api_key);

}
