package com.tritech.movies.persenter.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        this.setContentView(getLayoutID());
        ButterKnife.bind(this);
        
        
        main();
        
    }

    protected abstract void main();

    protected abstract int getLayoutID();
}
