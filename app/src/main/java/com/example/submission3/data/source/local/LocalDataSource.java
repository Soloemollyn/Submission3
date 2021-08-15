package com.example.submission3.data.source.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.example.submission3.data.source.local.entity.MovieEntity;
import com.example.submission3.data.source.local.entity.TvShowEntity;
import com.example.submission3.data.source.local.room.DataDao;

import java.util.List;

public class LocalDataSource {
    private static LocalDataSource INSTANCE;
    private final DataDao mDataDao;

    private LocalDataSource(DataDao mDataDao) {
        this.mDataDao = mDataDao;
    }

    public static LocalDataSource getInstance(DataDao dataDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSource(dataDao);
        }
        return INSTANCE;
    }

    public DataSource.Factory<Integer, MovieEntity> getAllMovies() {
        return mDataDao.getMovies();
    }

    public DataSource.Factory<Integer, TvShowEntity> getAllTvShows() {
        return mDataDao.getTvShows();
    }

    public DataSource.Factory<Integer, MovieEntity> getFavoritedMovies() {
        return mDataDao.getFavoritedMovie();
    }

    public DataSource.Factory<Integer, TvShowEntity> getFavoritedTvShows() {
        return mDataDao.getFavoritedTvShows();
    }

    public LiveData<MovieEntity> getSelectedMovie(String movieId) {
        return mDataDao.getSelectedMovie(movieId);
    }

    public LiveData<TvShowEntity> getSelectedTvShow(String tvShowId) {
        return mDataDao.getSelectedTvShow(tvShowId);
    }

    public void insertMovies(List<MovieEntity> movies) {
        mDataDao.insertMovies(movies);
    }

    public void insertTvShows(List<TvShowEntity> tvShows) {
        mDataDao.insertTvShows(tvShows);
    }

    public void setMovieFavorite(MovieEntity movie, boolean newState) {
        movie.setFavorited(newState);
        mDataDao.updateMovie(movie);
    }

    public void setTvShowFavorite(TvShowEntity tvShow, boolean newState) {
        tvShow.setFavorited(newState);
        mDataDao.updateTvShow(tvShow);
    }
}
