package com.tritech.movies.persenter.view.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.tritech.movies.R;
import com.tritech.movies.persenter.base.BaseRecyclerAdapter;
import com.tritech.movies.persenter.model.MovieDataModel;
import com.tritech.movies.persenter.view.main.holder.MovieViewHolder;


public class MoviesAdapter extends BaseRecyclerAdapter<MovieViewHolder, MovieDataModel> {
    public MoviesAdapter(Context context) {
        super(context);
    }

    private Event event;

    public void setEvent(Event event) {
        this.event = event;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.fragment_movie, parent, false);

        return new MovieViewHolder(v,event);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }


    public interface Event{
        void navigateToDetailActivity(long movieId);
    }
}
