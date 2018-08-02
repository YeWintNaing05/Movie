package com.tritech.movies.domain.interactor;

import com.tritech.movies.domain.executor.PostExecutionThread;
import com.tritech.movies.domain.executor.ThreadExecutor;
import com.tritech.movies.domain.model.MovieDomainModel;
import com.tritech.movies.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


public class GetNowPlayingUseCase extends UseCase<List<MovieDomainModel>,GetNowPlayingUseCase.Param> {

    private final MoviesRepository repository;

    @Inject
    GetNowPlayingUseCase(MoviesRepository repository,ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    Observable<List<MovieDomainModel>> buildUseCaseObservable(GetNowPlayingUseCase.Param param) {
        return repository.fetchDataNowPlaying(param.api_key) ;
    }

    public static class Param{
        public String api_key;
    }
}
