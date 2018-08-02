package com.tritech.movies.di.modules;


import android.app.Fragment;

import com.tritech.movies.di.subcomponent.NowPlayingFragmentSubComponent;
import com.tritech.movies.persenter.view.main.fragment.NowPlayingFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module
public abstract class FragmentBuilderModule {
    @Binds
    @IntoMap
    @FragmentKey(NowPlayingFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment>
    bindNowPlayingFragmentInjectorFactory(NowPlayingFragmentSubComponent.Builder builder);
}
