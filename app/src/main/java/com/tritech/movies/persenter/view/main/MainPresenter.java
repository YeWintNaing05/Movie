package com.tritech.movies.persenter.view.main;

import com.tritech.movies.domain.exception.DefaultErrorBundle;
import com.tritech.movies.domain.exception.ErrorBundle;
import com.tritech.movies.domain.interactor.DefaultObserver;
import com.tritech.movies.domain.interactor.GetNowPlayingUseCase;
import com.tritech.movies.domain.interactor.GetPopularMovieUseCase;
import com.tritech.movies.domain.interactor.GetUpComingUseCase;
import com.tritech.movies.domain.model.MovieDomainModel;
import com.tritech.movies.persenter.base.BasePresenter;
import com.tritech.movies.persenter.exception.ErrorMessageFactory;
import com.tritech.movies.persenter.model.mapper.MovieDataMapper;

import java.util.List;

import javax.inject.Inject;



public class MainPresenter implements BasePresenter {


    private MainView mainView;
    private GetNowPlayingUseCase nowPlayingUseCase;
    private GetPopularMovieUseCase popularMovieUseCase;
    private GetUpComingUseCase upComingUseCase;


    @Inject
    MainPresenter(GetNowPlayingUseCase useCase, GetPopularMovieUseCase popularMovieUseCase, GetUpComingUseCase upComingUseCase){

        this.nowPlayingUseCase = useCase;
        this.popularMovieUseCase = popularMovieUseCase;
        this.upComingUseCase = upComingUseCase;
    }

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void resume() {
        mainView.resume();
    }

    @Override
    public void pause() {
        mainView.pause();
    }

    @Override
    public void destroy() {
        mainView.destroy();
        nowPlayingUseCase.dispose();
        upComingUseCase.dispose();
        popularMovieUseCase.dispose();

        mainView =null;
    }



    public void initialize(String api_key,int type) {
        this.loadData(api_key,type);
    }

    private void loadData(String api_key,int type){
        this.showViewLoading();

        switch (type){
            case 0:getNowPlayingMovie(api_key);break;
            case 1:getPopularPlayingMovie(api_key);break;
            case 2:getUpcomingPlayingMovie(api_key);break;
        }
    }


    private void showViewLoading() {
        this.mainView.showLoading();
    }

    private void hideViewLoading() {
        this.mainView.hideLoading();
    }

    private void showViewRetry() {
        this.mainView.showRetry();
    }


    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(
                errorBundle.getException());
        this.mainView.showError(errorMessage);
    }


    private void getNowPlayingMovie(String api_key) {
        GetNowPlayingUseCase.Param  param= new GetNowPlayingUseCase.Param();
        param.api_key = api_key;
        this.nowPlayingUseCase.execute(new MoviePlayingObserver(), param);
    }

    private void getPopularPlayingMovie(String api_key) {
        GetPopularMovieUseCase.Param  param= new GetPopularMovieUseCase.Param();
        param.api_key = api_key;
        this.popularMovieUseCase.execute(new MoviePlayingObserver(), param);
    }

    private void getUpcomingPlayingMovie(String api_key) {
        GetUpComingUseCase.Param  param= new GetUpComingUseCase.Param();
        param.api_key = api_key;
        this.upComingUseCase.execute(new MoviePlayingObserver(), param);
    }

    private final class MoviePlayingObserver extends DefaultObserver<List<MovieDomainModel>> {

        @Override
        public void onComplete() {
            MainPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            MainPresenter.this.hideViewLoading();
            MainPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            MainPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(List<MovieDomainModel> data) {
            MainPresenter.this.showCollectionInView(data);
        }
    }

    private void showCollectionInView(List<MovieDomainModel> data) {

        this.mainView.fetchDataMovie(MovieDataMapper.toMovieDomainModel(data));
    }

}
