package com.tritech.movies.persenter.view.main.fragment;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tritech.movies.R;
import com.tritech.movies.persenter.model.MovieDataModel;
import com.tritech.movies.persenter.view.detail.DetailActivity;
import com.tritech.movies.persenter.view.main.MainPresenter;
import com.tritech.movies.persenter.view.main.MainView;
import com.tritech.movies.persenter.view.main.adapter.MoviesAdapter;
import com.tritech.movies.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;


public class NowPlayingFragment extends Fragment implements MainView, MoviesAdapter.Event {


    private static final String ARG_PARAM ="type" ;
    @Inject
    MainPresenter presenter;

    private int type;
   private RecyclerView recyclerView;
    private MoviesAdapter adapter;

    public NowPlayingFragment() {
    }


    public static NowPlayingFragment getInstance(int type){
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_PARAM,type);
        NowPlayingFragment fragment = new NowPlayingFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            type = getArguments().getInt(ARG_PARAM);
        }
    }

 @Override
    public void onAttach(Activity activity) {
        AndroidInjection.inject(this);
        super.onAttach(activity);
        // ...


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =  inflater.inflate(R.layout.fragment_recycler, container, false);
        adapter =  new MoviesAdapter(getActivity());
        adapter.setEvent(this);
        presenter.setMainView(this);
        presenter.initialize(Constants.MOVIE_API_KEY,type);

        recyclerView = v.findViewById(R.id.rcView);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));


        return v;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void fetchDataMovie(List<MovieDataModel> data) {
        adapter.setNewData(data);
        recyclerView.setAdapter(adapter);

    }



    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void navigateToDetailActivity(long movieId) {
        DetailActivity.start(getActivity(),movieId);
    }
}
