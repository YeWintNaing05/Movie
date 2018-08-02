package com.tritech.movies.domain.interactor;

import com.tritech.movies.domain.executor.PostExecutionThread;
import com.tritech.movies.domain.executor.ThreadExecutor;
import com.tritech.movies.domain.model.MovieTrailersDomainModel;
import com.tritech.movies.domain.repository.MoviesRepository;
import com.tritech.movies.persenter.model.MovieDataTrilerModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetMoviesTrialerUseCase extends UseCase<List<MovieTrailersDomainModel>,GetMoviesTrialerUseCase.Param> {

    private final MoviesRepository repository;

    @Inject
    GetMoviesTrialerUseCase(MoviesRepository repository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    Observable<List<MovieTrailersDomainModel>> buildUseCaseObservable(GetMoviesTrialerUseCase.Param param) {
        return repository.fetchDataMovieTrailer(param.movieId,param.api_key);
    }

    public static class Param{
        public long movieId;
        public String api_key;
    }
}
