package com.tritech.movies.di.subcomponent;

import com.tritech.movies.persenter.view.detail.DetailActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface DetailActivitySubComponent extends AndroidInjector<DetailActivity> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<DetailActivity> {}



}