package com.example.submission3.ui.favtvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.example.submission3.data.source.DataRepository;
import com.example.submission3.data.source.local.entity.TvShowEntity;

public class FavTvShowViewModel extends ViewModel {

    private final DataRepository dataRepository;

    public FavTvShowViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public LiveData<PagedList<TvShowEntity>> getFavoritedTvShows() {
        return dataRepository.getFavoritedTvShows();
    }

    public void setFavorite(TvShowEntity tvShowEntity) {
        final boolean newState = !tvShowEntity.isFavorited();
        dataRepository.setTvShowFavorited(tvShowEntity, newState);
    }
}
