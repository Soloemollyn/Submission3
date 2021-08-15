package com.example.submission3.data.source.local.room;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.submission3.data.source.local.entity.MovieEntity;
import com.example.submission3.data.source.local.entity.TvShowEntity;

import java.util.List;

@Dao
public interface DataDao {
    @Query("SELECT * FROM movieentities")
    DataSource.Factory<Integer, MovieEntity> getMovies();

    @Transaction
    @Query("SELECT * FROM movieentities where movieId = :movieId")
    LiveData<MovieEntity> getSelectedMovie(String movieId);

    @Query("SELECT * FROM movieentities where favorited = 1")
    DataSource.Factory<Integer, MovieEntity> getFavoritedMovie();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovies(List<MovieEntity> movies);

    @Update
    void updateMovie(MovieEntity movie);

    @Query("SELECT * FROM tvshowentities")
    DataSource.Factory<Integer, TvShowEntity> getTvShows();

    @Query("SELECT * FROM tvshowentities where tvShowId = :tvShowId")
    LiveData<TvShowEntity> getSelectedTvShow(String tvShowId);

    @Query("SELECT * FROM tvshowentities where favorited = 1")
    DataSource.Factory<Integer, TvShowEntity> getFavoritedTvShows();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTvShows(List<TvShowEntity> tvShows);

    @Update
    void updateTvShow(TvShowEntity tvShows);
}
