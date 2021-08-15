package com.example.submission3.data.source;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.example.submission3.data.source.local.entity.MovieEntity;
import com.example.submission3.data.source.local.entity.TvShowEntity;
import com.example.submission3.vo.Resource;

public interface DataSource {
    LiveData<Resource<PagedList<MovieEntity>>> getAllMovies();

    LiveData<Resource<MovieEntity>> getDetailMovie(String movieId);

    LiveData<Resource<PagedList<TvShowEntity>>> getAllTvShows();

    LiveData<Resource<TvShowEntity>> getDetailTvShow(String tvShowId);

    LiveData<PagedList<MovieEntity>> getFavoritedMovies();

    LiveData<PagedList<TvShowEntity>> getFavoritedTvShows();

    void setMovieFavorited(MovieEntity movie, boolean state);

    void setTvShowFavorited(TvShowEntity tvShow, boolean state);
}
