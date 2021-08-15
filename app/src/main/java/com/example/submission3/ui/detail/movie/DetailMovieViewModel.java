package com.example.submission3.ui.detail.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.submission3.data.source.DataRepository;
import com.example.submission3.data.source.local.entity.MovieEntity;
import com.example.submission3.vo.Resource;

public class DetailMovieViewModel extends ViewModel {

    private final MutableLiveData<String> movieId = new MutableLiveData<>();

    private final DataRepository dataRepository;

    public DetailMovieViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
        movie = Transformations.switchMap(movieId,
                dataRepository::getDetailMovie);
    }

    public void setSelectedMovie(String movieId) {
        this.movieId.setValue(movieId);
    }

    public LiveData<Resource<MovieEntity>> movie;

    public void setFavorite() {
        Resource<MovieEntity> movieResource = movie.getValue();
        if (movieResource != null) {
            MovieEntity movieEntity = movieResource.data;
            if (movieEntity != null) {
                final boolean newState = !movieEntity.isFavorited();
                dataRepository.setMovieFavorited(movieEntity, newState);
            }
        }
    }
}
