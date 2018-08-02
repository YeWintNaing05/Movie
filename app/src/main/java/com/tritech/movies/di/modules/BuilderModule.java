package com.tritech.movies.di.modules;

import android.app.Activity;

import com.tritech.movies.di.subcomponent.DetailActivitySubComponent;
import com.tritech.movies.di.subcomponent.MainActivitySubComponent;
import com.tritech.movies.persenter.view.detail.DetailActivity;
import com.tritech.movies.persenter.view.main.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module
public abstract class BuilderModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindYourMainActivityInjectorFactory(MainActivitySubComponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(DetailActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindYourDetailActivityInjectorFactory(DetailActivitySubComponent.Builder builder);


/*
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindYourMainActivityInjectorFactory(TodoActivitySubComponent.Builder builder);


    @Binds
    @IntoMap
    @ActivityKey(DetailActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindYourDetailActivityInjectorFactory(TodoDetailActivitySubCompnent.Builder builder);

*/

}