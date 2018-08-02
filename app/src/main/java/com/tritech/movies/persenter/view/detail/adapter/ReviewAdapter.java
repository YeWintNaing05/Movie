package com.tritech.movies.persenter.view.detail.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tritech.movies.R;
import com.tritech.movies.persenter.base.BaseRecyclerAdapter;
import com.tritech.movies.persenter.model.MovieDataReviewsModel;
import com.tritech.movies.persenter.view.detail.holder.ReviewHolder;


public class ReviewAdapter extends BaseRecyclerAdapter<ReviewHolder, MovieDataReviewsModel> {




    public ReviewAdapter(Context context) {
        super(context);
    }



    @NonNull
    @Override
    public ReviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.reviews_item, parent, false);
        return new ReviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewHolder holder, int position) {
        holder.bind(mData.get(position));
    }


}

