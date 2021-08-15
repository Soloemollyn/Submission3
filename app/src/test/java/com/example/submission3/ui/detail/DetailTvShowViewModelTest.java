package com.example.submission3.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.submission3.data.source.DataRepository;
import com.example.submission3.data.source.local.entity.TvShowEntity;
import com.example.submission3.ui.detail.tvshow.DetailTvShowViewModel;
import com.example.submission3.utils.DataTvShow;
import com.example.submission3.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailTvShowViewModelTest {
    private DetailTvShowViewModel viewModel;
    private final TvShowEntity dummyTvShow = DataTvShow.generateDummyTvShow().get(0);
    private final String tvShowId = dummyTvShow.getTvShowId();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private DataRepository dataRepository;

    @Mock
    private Observer<Resource<TvShowEntity>> tvshowObserver;

    @Before
    public void setUp() {
        viewModel = new DetailTvShowViewModel(dataRepository);
        viewModel.setSelectedTvShow(tvShowId);
    }

    @Test
    public void getTvShow() {
        Resource<TvShowEntity> resDummyTvShow = Resource.success(dummyTvShow);
        MutableLiveData<Resource<TvShowEntity>> tvShow = new MutableLiveData<>();
        tvShow.setValue(resDummyTvShow);

        when(dataRepository.getDetailTvShow(tvShowId)).thenReturn(tvShow);

        viewModel.tvShow.observeForever(tvshowObserver);
        verify(tvshowObserver).onChanged(resDummyTvShow);
    }

    @Test
    public void setTvShowFavorite() {
        Resource<TvShowEntity> resDummyTvShow = Resource.success(dummyTvShow);
        MutableLiveData<Resource<TvShowEntity>> tvShow = new MutableLiveData<>();
        tvShow.setValue(resDummyTvShow);

        when(dataRepository.getDetailTvShow(tvShowId)).thenReturn(tvShow);
        viewModel.setSelectedTvShow(tvShowId);
        viewModel.tvShow.observeForever(tvshowObserver);

        boolean newState = !tvShow.getValue().data.isFavorited();
        doNothing().when(dataRepository).setTvShowFavorited(tvShow.getValue().data, newState);

        viewModel.setFavorite();
        verify(dataRepository, times(1)).setTvShowFavorited(tvShow.getValue().data, newState);
    }
}
