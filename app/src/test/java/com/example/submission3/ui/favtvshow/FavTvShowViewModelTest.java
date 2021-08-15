package com.example.submission3.ui.favtvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.example.submission3.data.source.DataRepository;
import com.example.submission3.data.source.local.entity.TvShowEntity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FavTvShowViewModelTest {

    private FavTvShowViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private DataRepository dataRepository;

    @Mock
    private Observer<PagedList<TvShowEntity>> observer;

    @Mock
    private PagedList<TvShowEntity> pagedList;

    @Before
    public void setUp() {
        viewModel = new FavTvShowViewModel(dataRepository);
    }

    @Test
    public void getFavTvShow() {
        PagedList<TvShowEntity> dummyTvShow = pagedList;
        when(dummyTvShow.size()).thenReturn(10);
        MutableLiveData<PagedList<TvShowEntity>> tvShow = new MutableLiveData<>();
        tvShow.setValue(dummyTvShow);

        when(dataRepository.getFavoritedTvShows()).thenReturn(tvShow);
        List<TvShowEntity> tvShowEntities = viewModel.getFavoritedTvShows().getValue();
        verify(dataRepository).getFavoritedTvShows();
        assertNotNull(tvShowEntities);
        assertEquals(10, tvShowEntities.size());

        viewModel.getFavoritedTvShows().observeForever(observer);
        verify(observer).onChanged(dummyTvShow);
    }
}
