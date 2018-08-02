package com.tritech.movies.domain.interactor;

import com.tritech.movies.domain.executor.PostExecutionThread;
import com.tritech.movies.domain.executor.ThreadExecutor;
import com.tritech.movies.domain.model.MovieDomainDetailModel;
import com.tritech.movies.domain.repository.MoviesRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetMoviesDetailUseCase extends UseCase<MovieDomainDetailModel,GetMoviesDetailUseCase.Param> {

    private final MoviesRepository repository;

    @Inject
    GetMoviesDetailUseCase(MoviesRepository repository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    Observable<MovieDomainDetailModel> buildUseCaseObservable(GetMoviesDetailUseCase.Param param) {
        return repository.fetchDataMovieDetail(param.movieId,param.api_key) ;
    }

    public static class Param{
        public long movieId;
        public String api_key;
    }
}

