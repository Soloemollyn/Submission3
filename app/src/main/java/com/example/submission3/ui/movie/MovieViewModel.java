package com.example.submission3.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.example.submission3.data.source.DataRepository;
import com.example.submission3.data.source.local.entity.MovieEntity;
import com.example.submission3.vo.Resource;

public class MovieViewModel extends ViewModel {

    private final DataRepository dataRepository;

    public MovieViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public LiveData<Resource<PagedList<MovieEntity>>> getMovies() {
        return dataRepository.getAllMovies();
    }
}
