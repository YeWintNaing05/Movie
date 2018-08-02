package com.tritech.movies.di.modules;

import android.content.Context;

import com.tritech.movies.MoviesApp;
import com.tritech.movies.UiThread;
import com.tritech.movies.data.executor.JobExecutor;
import com.tritech.movies.data.net.ApiService;
import com.tritech.movies.data.repository.MovieDataRepository;
import com.tritech.movies.di.subcomponent.DetailActivitySubComponent;
import com.tritech.movies.di.subcomponent.MainActivitySubComponent;
import com.tritech.movies.di.subcomponent.NowPlayingFragmentSubComponent;
import com.tritech.movies.domain.executor.PostExecutionThread;
import com.tritech.movies.domain.executor.ThreadExecutor;
import com.tritech.movies.domain.repository.MoviesRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = {MainActivitySubComponent.class, NowPlayingFragmentSubComponent.class,
        DetailActivitySubComponent.class})
public class AppModule {


    private MoviesApp mApplication;

    public AppModule(MoviesApp application) {
        mApplication = application;
    }

    @Provides
    Context provideContext() {
        return mApplication.getApplicationContext();
    }

    @Singleton
    @Provides
    ThreadExecutor provideExecutor(JobExecutor executor) {
        return executor;
    }

    @Singleton
    @Provides
    PostExecutionThread providePostExecutionThread(UiThread thread) {
        return thread;
    }



}
