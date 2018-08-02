package com.tritech.movies.persenter.view.main.holder;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tritech.movies.R;
import com.tritech.movies.persenter.base.BaseViewHolder;
import com.tritech.movies.persenter.model.MovieDataModel;
import com.tritech.movies.persenter.view.detail.DetailActivity;
import com.tritech.movies.persenter.view.main.adapter.MoviesAdapter;
import com.tritech.movies.utils.Constants;

import butterknife.BindView;

public class MovieViewHolder extends BaseViewHolder<MovieDataModel> {


    private  MoviesAdapter.Event event;
    private MovieDataModel data;
    @BindView(R.id.imgFav)
    ImageView draweeView;

    public MovieViewHolder(View itemView) {
        super(itemView);
    }

    public MovieViewHolder(View v, MoviesAdapter.Event event) {
        this(v);
        this.event = event;
    }

    @Override
    public void bind(MovieDataModel data) {

        this.data = data;
        //noinspection deprecation
       /* final Drawable failureDrawable = draweeView.getContext().getResources().getDrawable(R.drawable.ic_error_black_96dp);
        DrawableCompat.setTint(failureDrawable, Color.RED);

        draweeView.getHierarchy().setProgressBarImage(new CircleProgressBarDrawable());
        draweeView.getHierarchy().setFailureImage(failureDrawable, ScalingUtils.ScaleType.CENTER_INSIDE);
        draweeView.setController(Fresco.newDraweeControllerBuilder()
                .setOldController(draweeView.getController())
                .setTapToRetryEnabled(true)
                .setUri(Constants.BASE_LOW_IMG_URL + data.getPosterPath())

                .build());*/

       /* Glide.with(draweeView.getContext())
               .load(Constants.BASE_LOW_IMG_URL + data.getPosterPath())
                .placeholder(R.drawable.tri_tech)
                .into(draweeView);
*/
        Glide.with(draweeView.getContext())
                .load(Constants.BASE_LOW_IMG_URL + data.getPosterPath())
                .apply(
                        new RequestOptions()
                                .placeholder(R.drawable.tri_tech)
                )
                .into(draweeView);

    }

    @Override
    public void onClick(View v) {
        event.navigateToDetailActivity(data.getId());
    }


}
