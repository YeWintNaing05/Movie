package com.tritech.movies.utils;

import com.tritech.movies.BuildConfig;

public class Constants {

    // api url, key, etc...
    public static final String MOVIE_BASE_URL = "http://api.themoviedb.org/3/";
    public static final String BASE_LOW_IMG_URL = "http://image.tmdb.org/t/p/w500";
    public static final String BASE_HIGH_IMG_URL = "http://image.tmdb.org/t/p/original";

    public static final String YOUTUBE_TRAILER_PREVIEW_PATH = "http://img.youtube.com/vi/%s/0.jpg";

    public static final String BASE_YOTUBE_URL = "http://www.youtube.com/watch?v=";

    //TODO: enter your own  api key here!
    public static final String MOVIE_API_KEY = BuildConfig.MovieApiKey;

    public static final String API_GET_NOW_PLAYING_MOVIE_LIST = "movie/now_playing";
    public static final String API_GET_UPCOMING_MOVIE_LIST = "movie/upcoming";
    public static final String API_GET_POPULAR_MOVIE_LIST = "movie/popular";
    public static final String API_GET_MOVIE_DETAIL = "movie/{movieId}";
    public static final String API_GET_MOVIE_TRAILER = "movie/{movieId}/videos";
    public static final String API_SEARCH_MOVIE = "search/movie";
    public static final String API_GET_MOVIE_REVIEW = "movie/{movieId}/reviews";



    public static final String PARA_API_KEY = "api_key";
    public static final String PARA_PAGE = "page";
    public static final String PARA_MOVIE_ID = "movieId";
    public static final String PARA_QUERY = "query";


}
