package com.tritech.movies.domain.model.mapper;

import com.tritech.movies.data.net.model.MoviesDetail;
import com.tritech.movies.data.net.model.MoviesInfo;
import com.tritech.movies.data.net.model.Review;
import com.tritech.movies.data.net.model.Trailer;
import com.tritech.movies.data.net.response.MoviesResponse;
import com.tritech.movies.domain.model.MovieDomainDetailModel;
import com.tritech.movies.domain.model.MovieDomainModel;
import com.tritech.movies.domain.model.MovieTrailersDomainModel;
import com.tritech.movies.domain.model.ReviewDomainModel;

import java.util.ArrayList;
import java.util.List;

public class MovieDomainMapper {

    public static List<MovieDomainModel> toMovieDomainModel(MoviesResponse response) {
        List<MovieDomainModel> data = new ArrayList<>();

        for (MoviesInfo info : response.getResults()) {
            MovieDomainModel model = new MovieDomainModel(info.getVoteCount(), info.getId(), info.getVideo(),
                    info.getVoteAverage(), info.getTitle(), info.getPopularity(),
                    info.getPosterPath(), info.getOriginalLanguage(), info.getOriginalTitle(), info.getGenreIds(),
                    info.getBackdropPath(), info.getAdult(), info.getOverview(), info.getReleaseDate());
            data.add(model);
        }
        return data;
    }

    public static MovieDomainDetailModel toMovieDetailDomainModel(MoviesDetail response) {

        MovieDomainDetailModel model = new MovieDomainDetailModel(
                response.getAdult(), response.getBackdropPath(), response.getBelongsToCollection()
                , response.getBudget(), response.getGenres(),
                response.getHomepage(), response.getId(), response.getImdbId(),
                response.getOriginalLanguage(), response.getOriginalTitle(),
                response.getOverview(), response.getPopularity(), response.getPosterPath(),
                response.getProductionCompanies(), response.getProductionCountries(),
                response.getReleaseDate(), response.getRevenue(), response.getRuntime(),
                response.getSpokenLanguages(), response.getStatus(), response.getTagline(),
                response.getTitle(), response.getVideo(), response.getVoteAverage(), response.getVoteCount()
        );
        return model;
    }



    public static List<MovieTrailersDomainModel> toMovieTrailerDomainModel(List<Trailer> response) {

        List<MovieTrailersDomainModel> data = new ArrayList<>();

        for(Trailer info : response){
            MovieTrailersDomainModel model = new MovieTrailersDomainModel(
              info.getId(),info.getIso6391(),info.getIso31661(),info.getKey(),info.getName(),info.getSite(),info.getSize(),info.getType()


            );

            data.add(model);
        }


        return data;
    }

    public static List<ReviewDomainModel> toMovieReviewDomainModel(List<Review> response) {

        List<ReviewDomainModel> data = new ArrayList<>();

        for(Review info : response){
            ReviewDomainModel model = new ReviewDomainModel(
                info.getAuthor(),info.getContent(),info.getId(),info.getUrl()
            );

            data.add(model);
        }


        return data;
    }


}
