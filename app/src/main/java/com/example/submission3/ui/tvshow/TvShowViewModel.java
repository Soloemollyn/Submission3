package com.example.submission3.ui.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.example.submission3.data.source.DataRepository;
import com.example.submission3.data.source.local.entity.TvShowEntity;
import com.example.submission3.vo.Resource;

public class TvShowViewModel extends ViewModel {

    private final DataRepository dataRepository;

    public TvShowViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public LiveData<Resource<PagedList<TvShowEntity>>> getTvShow() {
        return dataRepository.getAllTvShows();
    }
}
