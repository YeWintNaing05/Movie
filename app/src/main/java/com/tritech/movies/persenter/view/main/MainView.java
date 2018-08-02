package com.tritech.movies.persenter.view.main;

import com.tritech.movies.persenter.base.BaseView;
import com.tritech.movies.persenter.model.MovieDataModel;

import java.util.List;

public interface MainView extends BaseView {
    void pause();
    void resume();
    void destroy();

    void fetchDataMovie(List<MovieDataModel> data);

}
