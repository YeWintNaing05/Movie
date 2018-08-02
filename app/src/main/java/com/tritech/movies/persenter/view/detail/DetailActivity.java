package com.tritech.movies.persenter.view.detail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tritech.movies.R;
import com.tritech.movies.persenter.base.BaseActivity;
import com.tritech.movies.persenter.model.MovieDataDetailModel;
import com.tritech.movies.persenter.model.MovieDataReviewsModel;
import com.tritech.movies.persenter.model.MovieDataTrilerModel;
import com.tritech.movies.persenter.view.detail.adapter.ReviewAdapter;
import com.tritech.movies.persenter.view.detail.adapter.TrailerAdapter;
import com.tritech.movies.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class DetailActivity extends BaseActivity implements DetailView, TrailerAdapter.TrailerClick {


    @BindView(R.id.rvTrailer)
    RecyclerView rvTrailer;

    @BindView(R.id.rvReview)
    RecyclerView rvReview;

    @BindView(R.id.imgMovie)
    ImageView imgMovie;

    @BindView(R.id.movieTitle)
    TextView txtMovie;

    @BindView(R.id.txtVote)
    TextView txtVote;

    @BindView(R.id.txtOverview)
    TextView txtOverview;



    @Inject
    DetailPresenter presenter;

    TrailerAdapter trailerAdapter;

    ReviewAdapter reviewAdapter;
    public static void start(Context context, long movieId) {
        Intent starter = new Intent(context, DetailActivity.class);
        starter.putExtra("movie_id",movieId);
        context.startActivity(starter);
    }


    @Override
    protected void onStart() {
        super.onStart();

        long movieId = 0;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            movieId = bundle.getLong("movie_id");
        }
        presenter.setView(this);
        presenter.initialize(Constants.MOVIE_API_KEY,movieId);

        rvReview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        rvTrailer.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        trailerAdapter = new TrailerAdapter(this);
        reviewAdapter = new ReviewAdapter(this);

        trailerAdapter.setTrailerClick(this);
    }

    @Override
    protected void main() {



    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_detail;
    }

    @Override
    public void fetchMovieDetail(MovieDataDetailModel data) {
        Log.d("data detail",data.getOverview());

        Glide.with(imgMovie.getContext())
                .load(Constants.BASE_HIGH_IMG_URL+data.getBackdropPath())
                .apply(
                        new RequestOptions()
                                .placeholder(R.drawable.tri_tech)
                )
                .into(imgMovie);

        txtMovie.setText(data.getTitle());
        txtVote.setText(String.valueOf(data.getVoteAverage()));
        txtOverview.setText(data.getOverview());
    }

    @Override
    public void fetchMovieTrailer(List<MovieDataTrilerModel> data) {
        if(!data.isEmpty())
        Log.d("data trailer",data.get(0).getName());
        trailerAdapter.setNewData(data);
        rvTrailer.setAdapter(trailerAdapter);
    }

    @Override
    public void fetchMovieReviews(List<MovieDataReviewsModel> data) {
        reviewAdapter.setNewData(data);
        rvReview.setAdapter(reviewAdapter);
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
        return this;
    }

    @Override
    public void trailerItemClick(String key) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.BASE_YOTUBE_URL+key)));
    }
}
