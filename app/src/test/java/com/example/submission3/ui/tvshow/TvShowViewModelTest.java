package com.example.submission3.ui.tvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.example.submission3.data.source.DataRepository;
import com.example.submission3.data.source.local.entity.TvShowEntity;
import com.example.submission3.vo.Resource;

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
public class TvShowViewModelTest {
    private TvShowViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private DataRepository dataRepository;

    @Mock
    private Observer<Resource<PagedList<TvShowEntity>>> observer;

    @Mock
    private PagedList<TvShowEntity> pagedList;

    @Before
    public void setUp() {
        viewModel = new TvShowViewModel(dataRepository);
    }

    @Test
    public void getTvShows() {
        Resource<PagedList<TvShowEntity>> dummyTvShows = Resource.success(pagedList);
        when(dummyTvShows.data.size()).thenReturn(10);
        MutableLiveData<Resource<PagedList<TvShowEntity>>> tvShows = new MutableLiveData<>();
        tvShows.setValue(dummyTvShows);

        when(dataRepository.getAllTvShows()).thenReturn(tvShows);
        List<TvShowEntity> tvshowEntities = viewModel.getTvShow().getValue().data;
        verify(dataRepository).getAllTvShows();
        assertNotNull(tvshowEntities);
        assertEquals(10, tvshowEntities.size());

        viewModel.getTvShow().observeForever(observer);
        verify(observer).onChanged(dummyTvShows);
    }
}
