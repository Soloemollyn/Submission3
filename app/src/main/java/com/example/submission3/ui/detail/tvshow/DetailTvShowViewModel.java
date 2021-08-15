package com.example.submission3.ui.detail.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.submission3.data.source.DataRepository;
import com.example.submission3.data.source.local.entity.TvShowEntity;
import com.example.submission3.vo.Resource;

public class DetailTvShowViewModel extends ViewModel {

    private final MutableLiveData<String> tvShowId = new MutableLiveData<>();
    private final DataRepository dataRepository;

    public DetailTvShowViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
        tvShow = Transformations.switchMap(tvShowId,
                dataRepository::getDetailTvShow);
    }

    public void setSelectedTvShow(String tvShowId) {
        this.tvShowId.setValue(tvShowId);
    }

    public LiveData<Resource<TvShowEntity>> tvShow;

    public void setFavorite() {
        Resource<TvShowEntity> tvShowResource = tvShow.getValue();
        if (tvShowResource != null) {
            TvShowEntity tvShowEntity = tvShowResource.data;
            if (tvShowEntity != null) {
                final boolean newState = !tvShowResource.data.isFavorited();
                dataRepository.setTvShowFavorited(tvShowResource.data, newState);
            }
        }
    }
}
