package com.tritech.movies.persenter.view.detail.holder;

import android.view.View;
import android.widget.TextView;

import com.tritech.movies.R;
import com.tritech.movies.persenter.base.BaseViewHolder;
import com.tritech.movies.persenter.model.MovieDataReviewsModel;

import butterknife.BindView;
import butterknife.OnClick;

public class ReviewHolder extends BaseViewHolder<MovieDataReviewsModel> {

    @BindView(R.id.txtAuthor)
    TextView txtAuthor;

    @BindView(R.id.txtContent)
    TextView txtContent;

    public ReviewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(MovieDataReviewsModel data) {
        txtAuthor.setText(data.getAuthor());
        txtContent.setText(data.getContent());
    }

    @Override
    public void onClick(View v) {

    }

    @OnClick(R.id.btnMore)
    void more(){

    }
}
