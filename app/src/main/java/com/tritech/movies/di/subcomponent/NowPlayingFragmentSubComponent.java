package com.tritech.movies.di.subcomponent;

import com.tritech.movies.persenter.view.main.fragment.NowPlayingFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface NowPlayingFragmentSubComponent extends AndroidInjector<NowPlayingFragment> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<NowPlayingFragment> {}
}