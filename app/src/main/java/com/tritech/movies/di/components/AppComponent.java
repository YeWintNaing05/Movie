package com.tritech.movies.di.components;


import com.tritech.movies.MoviesApp;
import com.tritech.movies.di.modules.AppModule;
import com.tritech.movies.di.modules.BuilderModule;
import com.tritech.movies.di.modules.RetrofitModule;
import com.tritech.movies.di.modules.FragmentBuilderModule;

import com.tritech.movies.domain.repository.MoviesRepository;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        AppModule.class,
        RetrofitModule.class,
        FragmentBuilderModule.class,
        BuilderModule.class})
public interface AppComponent {

    MoviesRepository productRepository();
    void inject(MoviesApp app);

}
