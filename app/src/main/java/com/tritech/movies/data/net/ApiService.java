package com.tritech.movies.data.net;


import com.tritech.movies.data.net.model.MoviesDetail;
import com.tritech.movies.data.net.model.MoviesInfo;
import com.tritech.movies.data.net.response.MoviesResponse;
import com.tritech.movies.data.net.response.ReviewResponse;
import com.tritech.movies.data.net.response.TrailerResponse;
import com.tritech.movies.utils.Constants;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET(Constants.API_GET_NOW_PLAYING_MOVIE_LIST)
    Observable<MoviesResponse> getNowPlaying(
            @Query(Constants.PARA_API_KEY) String apiKey
    );

    @GET(Constants.API_GET_POPULAR_MOVIE_LIST)
    Observable<MoviesResponse> getPopularMovie(
            @Query(Constants.PARA_API_KEY) String apiKey
    );

    @GET(Constants.API_GET_UPCOMING_MOVIE_LIST)
    Observable<MoviesResponse> getUpcomingMovie(
            @Query(Constants.PARA_API_KEY) String apiKey
    );


    @GET(Constants.API_GET_MOVIE_DETAIL)
    Observable<MoviesDetail> getMovieDetails(
            @Path(Constants.PARA_MOVIE_ID) long movieId,
            @Query(Constants.PARA_API_KEY) String apiKey
    );

    @GET(Constants.API_GET_MOVIE_TRAILER)
    Observable<TrailerResponse> getMovieTrailers(
            @Path(Constants.PARA_MOVIE_ID) long movieId,
            @Query(Constants.PARA_API_KEY) String apiKey
    );

    @GET(Constants.API_SEARCH_MOVIE)
    Observable<MoviesResponse> searchMovies(
            @Query(Constants.PARA_QUERY) String query,
            @Query(Constants.PARA_API_KEY) String apiKey
    );


    @GET(Constants.API_GET_MOVIE_REVIEW)
    Observable<ReviewResponse> getReview(
            @Path(Constants.PARA_MOVIE_ID) long movieId,
            @Query(Constants.PARA_API_KEY) String apiKey
    );







}
