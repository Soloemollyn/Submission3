package com.example.submission3.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.submission3.data.source.DataRepository;
import com.example.submission3.di.Injection;
import com.example.submission3.ui.favmovie.FavMovieViewModel;
import com.example.submission3.ui.favtvshow.FavTvShowViewModel;
import com.example.submission3.ui.detail.movie.DetailMovieViewModel;
import com.example.submission3.ui.detail.tvshow.DetailTvShowViewModel;
import com.example.submission3.ui.movie.MovieViewModel;
import com.example.submission3.ui.tvshow.TvShowViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;
    private final DataRepository dataRepository;

    private ViewModelFactory(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public static ViewModelFactory getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(context));
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(dataRepository);
        } else if (modelClass.isAssignableFrom(TvShowViewModel.class)) {
            return (T) new TvShowViewModel(dataRepository);
        } else if (modelClass.isAssignableFrom(DetailMovieViewModel.class)) {
            return (T) new DetailMovieViewModel(dataRepository);
        } else if (modelClass.isAssignableFrom(DetailTvShowViewModel.class)) {
            return (T) new DetailTvShowViewModel(dataRepository);
        } else if (modelClass.isAssignableFrom(FavMovieViewModel.class)) {
            return (T) new FavMovieViewModel(dataRepository);
        } else if (modelClass.isAssignableFrom(FavTvShowViewModel.class)) {
            return (T) new FavTvShowViewModel(dataRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
