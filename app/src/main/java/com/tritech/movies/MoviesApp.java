package com.tritech.movies;

import android.app.Activity;
import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tritech.movies.di.components.DaggerAppComponent;
import com.tritech.movies.di.modules.AppModule;
import com.tritech.movies.di.modules.RetrofitModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MoviesApp  extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        DaggerAppComponent.builder().appModule(new AppModule(this)).retrofitModule(new RetrofitModule()).build().inject(this);

    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}