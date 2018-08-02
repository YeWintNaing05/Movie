package com.tritech.movies.data.repository;

import android.util.Log;

import com.tritech.movies.data.net.ApiService;
import com.tritech.movies.data.net.model.MoviesDetail;
import com.tritech.movies.data.net.response.MoviesResponse;
import com.tritech.movies.data.net.response.ReviewResponse;
import com.tritech.movies.data.net.response.TrailerResponse;
import com.tritech.movies.domain.model.MovieDomainDetailModel;
import com.tritech.movies.domain.model.MovieDomainModel;
import com.tritech.movies.domain.model.MovieTrailersDomainModel;
import com.tritech.movies.domain.model.ReviewDomainModel;
import com.tritech.movies.domain.model.mapper.MovieDomainMapper;
import com.tritech.movies.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

@Singleton
public class MovieDataRepository implements MoviesRepository {

    @Inject
    ApiService service;

    public MovieDataRepository(ApiService service) {

        this.service = service;
    }

    @Override
    public Observable<List<MovieDomainModel>> fetchDataNowPlaying(String api_key) {
        return service.getNowPlaying(api_key).map(new Function<MoviesResponse, List<MovieDomainModel>>() {
            @Override
            public List<MovieDomainModel> apply(MoviesResponse moviesResponse) throws Exception {
                Log.d("data", moviesResponse.getResults().get(0).getTitle());
                return MovieDomainMapper.toMovieDomainModel(moviesResponse);
            }
        });
    }

    @Override
    public Observable<List<MovieDomainModel>> fetchDataPopular(String api_key) {

        return service.getPopularMovie(api_key).map(new Function<MoviesResponse, List<MovieDomainModel>>() {
            @Override
            public List<MovieDomainModel> apply(MoviesResponse moviesResponse) throws Exception {
                Log.d("data", moviesResponse.getResults().get(0).getTitle());
                return MovieDomainMapper.toMovieDomainModel(moviesResponse);
            }
        });
    }



    @Override
    public Observable<List<MovieDomainModel>> fetchDataUpcoming(String api_key) {
        return service.getUpcomingMovie(api_key).map(new Function<MoviesResponse, List<MovieDomainModel>>() {
            @Override
            public List<MovieDomainModel> apply(MoviesResponse moviesResponse) throws Exception {
                Log.d("data", moviesResponse.getResults().get(0).getTitle());
                return MovieDomainMapper.toMovieDomainModel(moviesResponse);
            }
        });
    }

    @Override
    public Observable<MovieDomainDetailModel> fetchDataMovieDetail(long movieId, String api_key) {
        return service.getMovieDetails(movieId,api_key).map(new Function<MoviesDetail, MovieDomainDetailModel>() {
            @Override
            public MovieDomainDetailModel apply(MoviesDetail moviesDetail) throws Exception {
                return MovieDomainMapper.toMovieDetailDomainModel(moviesDetail);
            }
        });
    }

    @Override
    public Observable<List<MovieTrailersDomainModel>> fetchDataMovieTrailer(long movieId, String api_key) {
        return service.getMovieTrailers(movieId,api_key).map(new Function<TrailerResponse, List<MovieTrailersDomainModel>>() {
            @Override
            public List<MovieTrailersDomainModel> apply(TrailerResponse trailerResponse) throws Exception {
                return MovieDomainMapper.toMovieTrailerDomainModel(trailerResponse.getTrailers());
            }
        });
    }

    @Override
    public Observable<List<ReviewDomainModel>> fetchDataMovieReview(long movieId, String api_key) {
        return service.getReview(movieId,api_key).map(new Function<ReviewResponse, List<ReviewDomainModel>>() {
            @Override
            public List<ReviewDomainModel> apply(ReviewResponse reviewResponse) throws Exception {
                return MovieDomainMapper.toMovieReviewDomainModel(reviewResponse.getResults());
            }
        });
    }
}

