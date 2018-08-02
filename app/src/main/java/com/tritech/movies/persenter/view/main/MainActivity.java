package com.tritech.movies.persenter.view.main;


import android.app.Fragment;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.widget.Button;

import com.tritech.movies.R;
import com.tritech.movies.persenter.base.BaseActivity;
import com.tritech.movies.persenter.view.main.adapter.PagerAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;


public class MainActivity extends BaseActivity  implements HasFragmentInjector {


    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

//    @Inject
//    MainPresenter presenter;

    @BindView(R.id.vPager)
    ViewPager viewPager;

    @BindView(R.id.btnNow)
    Button now;

    @BindView(R.id.btnPopular)
    Button popular;

    @BindView(R.id.btnUpcoming)
    Button upcoming;

    public void changeActive(int pos) {
        switch (pos) {
            case 0:
                now.setBackgroundColor(getResources().getColor(R.color.activeColor));
                popular.setBackgroundColor(Color.WHITE);
                upcoming.setBackgroundColor(Color.WHITE);
                break;
            case 1:
                popular.setBackgroundColor(getResources().getColor(R.color.activeColor));
                now.setBackgroundColor(Color.WHITE);
                upcoming.setBackgroundColor(Color.WHITE);
                break;
            case 2:
                upcoming.setBackgroundColor(getResources().getColor(R.color.activeColor));
                now.setBackgroundColor(Color.WHITE);
                popular.setBackgroundColor(Color.WHITE);
                break;


        }
    }

    @Override
    protected void main() {
 now.setBackgroundColor(getResources().getColor(R.color.activeColor));
        viewPager.setAdapter(new PagerAdapter(getFragmentManager()));

        viewPager.setCurrentItem(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeActive(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.btnNow)
    public void now() {
        viewPager.setCurrentItem(0);
    }

    @OnClick(R.id.btnPopular)
    public void popular() {
        viewPager.setCurrentItem(1);

    }

    @OnClick(R.id.btnUpcoming)
    public void upcoming() {
        viewPager.setCurrentItem(2);

    }


    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }
}
