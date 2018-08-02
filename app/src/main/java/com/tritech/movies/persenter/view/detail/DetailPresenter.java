package com.tritech.movies.persenter.view.detail;

import com.tritech.movies.domain.exception.DefaultErrorBundle;
import com.tritech.movies.domain.exception.ErrorBundle;
import com.tritech.movies.domain.interactor.DefaultObserver;
import com.tritech.movies.domain.interactor.GetMovieReviewUseCase;
import com.tritech.movies.domain.interactor.GetMoviesDetailUseCase;
import com.tritech.movies.domain.interactor.GetMoviesTrialerUseCase;
import com.tritech.movies.domain.model.MovieDomainDetailModel;
import com.tritech.movies.domain.model.MovieTrailersDomainModel;
import com.tritech.movies.domain.model.ReviewDomainModel;
import com.tritech.movies.persenter.base.BasePresenter;
import com.tritech.movies.persenter.exception.ErrorMessageFactory;
import com.tritech.movies.persenter.model.mapper.MovieDataMapper;

import java.util.List;

import javax.inject.Inject;

public class DetailPresenter implements BasePresenter {

    private final GetMoviesDetailUseCase detailUseCase;
    private final GetMoviesTrialerUseCase trialerUseCase;
    private GetMovieReviewUseCase reviewUseCase;
    private DetailView view;

    @Inject
    public DetailPresenter(GetMovieReviewUseCase reviewUseCase,GetMoviesDetailUseCase detailUseCase, GetMoviesTrialerUseCase trialerUseCase){
        this.reviewUseCase = reviewUseCase;

        this.detailUseCase = detailUseCase;
        this.trialerUseCase = trialerUseCase;
    }

    public void setView(DetailView view) {
        this.view = view;
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

        view = null;
        detailUseCase.dispose();
        trialerUseCase.dispose();
    }

    public void initialize(String api_key,long movieId) {
        this.loadData(api_key,movieId);
    }


    private void loadData(String api_key,long movieId){
        this.view.showLoading();

        getMovieDetail(movieId,api_key);
        getMovieTrailer(movieId,api_key);
        getMovieReview(movieId,api_key);
    }

    private void getMovieReview(long movieId,String api_key) {
        GetMovieReviewUseCase.Param  param= new GetMovieReviewUseCase.Param();
        param.api_key = api_key;
        param.movieId = movieId;
        this.reviewUseCase.execute(new MovieReviewObserver(), param);
    }


    private void getMovieDetail(long movieId,String api_key) {
        GetMoviesDetailUseCase.Param  param= new GetMoviesDetailUseCase.Param();
        param.api_key = api_key;
        param.movieId = movieId;
        this.detailUseCase.execute(new MovieDetailObserver(), param);
    }

    private void getMovieTrailer(long movieId,String api_key) {
        GetMoviesTrialerUseCase.Param  param= new GetMoviesTrialerUseCase.Param();
        param.api_key = api_key;
        param.movieId = movieId;
        this.trialerUseCase.execute(new MovieTrailerObserver(), param);
    }

    private void showTrailerInView(List<MovieTrailersDomainModel> data) {
        this.view.fetchMovieTrailer(MovieDataMapper.toMovieTrailerDataModel(data));
    }

    private void showDetailInView(MovieDomainDetailModel data) {
        this.view.fetchMovieDetail(MovieDataMapper.toMovieDetailDataModel(data));

    }


    private void showReviewInView(List<ReviewDomainModel> data) {
        this.view.fetchMovieReviews(MovieDataMapper.toMovieReviewDomainModel(data));
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(
                errorBundle.getException());
        this.view.showError(errorMessage);
    }
    private final class MovieDetailObserver extends DefaultObserver<MovieDomainDetailModel> {

        @Override
        public void onComplete() {
            DetailPresenter.this.view.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            DetailPresenter.this.view.hideLoading();
            DetailPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            DetailPresenter.this.view.showRetry();
        }

        @Override
        public void onNext(MovieDomainDetailModel data) {
            DetailPresenter.this.showDetailInView(data);
        }
    }

    private final class MovieTrailerObserver extends DefaultObserver<List<MovieTrailersDomainModel>> {

        @Override
        public void onComplete() {
            DetailPresenter.this.view.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            DetailPresenter.this.view.hideLoading();
            DetailPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            DetailPresenter.this.view.showRetry();
        }

        @Override
        public void onNext(List<MovieTrailersDomainModel> data) {
            DetailPresenter.this.showTrailerInView(data);
        }






    }

    private final class MovieReviewObserver extends DefaultObserver<List<ReviewDomainModel>> {

        @Override
        public void onComplete() {
            DetailPresenter.this.view.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            DetailPresenter.this.view.hideLoading();
            DetailPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            DetailPresenter.this.view.showRetry();
        }

        @Override
        public void onNext(List<ReviewDomainModel> data) {
            DetailPresenter.this.showReviewInView(data);
        }
    }


}

