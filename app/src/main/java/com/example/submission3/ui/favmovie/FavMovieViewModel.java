package com.example.submission3.ui.favmovie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.example.submission3.data.source.DataRepository;
import com.example.submission3.data.source.local.entity.MovieEntity;

public class FavMovieViewModel extends ViewModel {

    private final DataRepository dataRepository;

    public FavMovieViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public LiveData<PagedList<MovieEntity>> getFavoritedMovies() {
        return dataRepository.getFavoritedMovies();
    }

    public void setFavorite(MovieEntity movieEntity) {
        final boolean newState = !movieEntity.isFavorited();
        dataRepository.setMovieFavorited(movieEntity, newState);
    }
}
