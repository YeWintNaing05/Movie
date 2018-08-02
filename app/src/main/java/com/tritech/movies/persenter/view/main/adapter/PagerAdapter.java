package com.tritech.movies.persenter.view.main.adapter;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import com.tritech.movies.persenter.view.main.fragment.NowPlayingFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return NowPlayingFragment.getInstance(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
