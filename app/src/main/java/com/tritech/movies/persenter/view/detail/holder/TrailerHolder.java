package com.tritech.movies.persenter.view.detail.holder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tritech.movies.R;
import com.tritech.movies.persenter.base.BaseViewHolder;
import com.tritech.movies.persenter.model.MovieDataTrilerModel;
import com.tritech.movies.persenter.view.detail.adapter.TrailerAdapter;
import com.tritech.movies.utils.Constants;

import butterknife.BindView;
import butterknife.OnClick;

public class TrailerHolder extends BaseViewHolder<MovieDataTrilerModel> {

    private  TrailerAdapter.TrailerClick trailerClick;
    private MovieDataTrilerModel data;
    @BindView(R.id.btnPlay)
    ImageButton btnPlay;

    @BindView(R.id.imgTrailerPreview)
    ImageView imgTrailerPriview;


    public TrailerHolder(View itemView) {
        super(itemView);
    }

    public TrailerHolder(View view, TrailerAdapter.TrailerClick trailerClick) {
        this(view);
        this.trailerClick = trailerClick;
    }

    @Override
    public void bind(MovieDataTrilerModel data) {
        this.data = data;
        Glide.with(imgTrailerPriview.getContext())
                .load(String.format(Constants.YOUTUBE_TRAILER_PREVIEW_PATH,data.getKey()))
                .apply(
                        new RequestOptions()
                                .placeholder(R.drawable.tri_tech)
                )
                .into(imgTrailerPriview);

    }

    @Override
    public void onClick(View v) {
      trailerClick.trailerItemClick(data.getKey());
    }

    @OnClick(R.id.btnPlay)
    void play(){
        trailerClick.trailerItemClick(data.getKey());

    }
}
