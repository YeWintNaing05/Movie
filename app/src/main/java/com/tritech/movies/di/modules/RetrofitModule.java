package com.tritech.movies.di.modules;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.tritech.movies.data.net.ApiService;
import com.tritech.movies.data.repository.MovieDataRepository;
import com.tritech.movies.domain.repository.MoviesRepository;
import com.tritech.movies.utils.Constants;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    @Provides
    @Singleton
    ApiService providesApiService(){
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.MOVIE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(ApiService.class);

    }

    @Singleton
    @Provides
    MoviesRepository productRepository(ApiService service) {
        return new MovieDataRepository(service);
    }

}
