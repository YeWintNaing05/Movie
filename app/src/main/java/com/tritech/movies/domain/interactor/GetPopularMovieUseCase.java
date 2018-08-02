package com.tritech.movies.domain.interactor;

import com.tritech.movies.domain.executor.PostExecutionThread;
import com.tritech.movies.domain.executor.ThreadExecutor;
import com.tritech.movies.domain.model.MovieDomainModel;
import com.tritech.movies.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetPopularMovieUseCase extends UseCase<List<MovieDomainModel>,GetPopularMovieUseCase.Param> {

    private final MoviesRepository repository;

    @Inject
    GetPopularMovieUseCase(MoviesRepository repository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    Observable<List<MovieDomainModel>> buildUseCaseObservable(GetPopularMovieUseCase.Param param) {
        return repository.fetchDataPopular(param.api_key) ;
    }

    public static class Param{
        public String api_key;
    }
}