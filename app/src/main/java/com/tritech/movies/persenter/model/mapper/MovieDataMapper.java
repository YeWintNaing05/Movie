package com.tritech.movies.persenter.model.mapper;

import com.tritech.movies.data.net.model.Trailer;
import com.tritech.movies.domain.model.MovieDomainDetailModel;
import com.tritech.movies.domain.model.MovieDomainModel;
import com.tritech.movies.domain.model.MovieTrailersDomainModel;
import com.tritech.movies.domain.model.ReviewDomainModel;
import com.tritech.movies.persenter.model.MovieDataDetailModel;
import com.tritech.movies.persenter.model.MovieDataModel;
import com.tritech.movies.persenter.model.MovieDataReviewsModel;
import com.tritech.movies.persenter.model.MovieDataTrilerModel;

import java.util.ArrayList;
import java.util.List;

public class MovieDataMapper {
    public static List<MovieDataModel> toMovieDomainModel(List<MovieDomainModel> response){
        List<MovieDataModel> data = new ArrayList<>();

        for(MovieDomainModel info : response) {
            MovieDataModel model = new MovieDataModel(info.getVoteCount(),info.getId(),info.getVideo(),
                    info.getVoteAverage(),info.getTitle(),info.getPopularity(),
                    info.getPosterPath(),info.getOriginalLanguage(),info.getOriginalTitle(),info.getGenreIds(),
                    info.getBackdropPath(),info.getAdult(),info.getOverview(),info.getReleaseDate());
            data.add(model);
        }
        return data;
    }

    public static MovieDataDetailModel toMovieDetailDataModel(MovieDomainDetailModel response) {
        MovieDataDetailModel model = new MovieDataDetailModel(
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

    public static List<MovieDataTrilerModel> toMovieTrailerDataModel(List<MovieTrailersDomainModel> response) {

        List<MovieDataTrilerModel> data = new ArrayList<>();

        for(MovieTrailersDomainModel info : response){
            MovieDataTrilerModel model = new MovieDataTrilerModel(
                    info.getId(),info.getIso6391(),info.getIso31661(),info.getKey(),info.getName(),info.getSite(),info.getSize(),info.getType()


            );

            data.add(model);
        }


        return data;
    }

    public static List<MovieDataReviewsModel> toMovieReviewDomainModel(List<ReviewDomainModel> response) {

        List<MovieDataReviewsModel> data = new ArrayList<>();

        for(ReviewDomainModel info : response){
            MovieDataReviewsModel model = new MovieDataReviewsModel(
                    info.getAuthor(),info.getContent(),info.getId(),info.getUrl()
            );

            data.add(model);
        }


        return data;
    }
}
