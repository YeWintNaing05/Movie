package com.tritech.movies.persenter.view.detail.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tritech.movies.R;
import com.tritech.movies.persenter.base.BaseRecyclerAdapter;
import com.tritech.movies.persenter.model.MovieDataTrilerModel;
import com.tritech.movies.persenter.view.detail.holder.TrailerHolder;

public class TrailerAdapter extends BaseRecyclerAdapter<TrailerHolder,MovieDataTrilerModel> {

    TrailerClick trailerClick;
    public TrailerAdapter(Context context) {
        super(context);
    }

    public void setTrailerClick(TrailerClick trailerClick) {
        this.trailerClick = trailerClick;
    }

    @NonNull
    @Override
    public TrailerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.trailer_items,parent,false);
        return new TrailerHolder(view,trailerClick);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailerHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    public interface TrailerClick{
        void trailerItemClick(String key);
    }
}
