package com.example.submission3.ui.favmovie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.example.submission3.data.source.DataRepository;
import com.example.submission3.data.source.local.entity.MovieEntity;

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
public class FavMovieViewModelTest {

    private FavMovieViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private DataRepository dataRepository;

    @Mock
    private Observer<PagedList<MovieEntity>> observer;

    @Mock
    private PagedList<MovieEntity> pagedList;

    @Before
    public void setUp() {
        viewModel = new FavMovieViewModel(dataRepository);
    }

    @Test
    public void getFavMovies() {
        PagedList<MovieEntity> dummyMovies = pagedList;
        when(dummyMovies.size()).thenReturn(10);
        MutableLiveData<PagedList<MovieEntity>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(dataRepository.getFavoritedMovies()).thenReturn(movies);
        List<MovieEntity> movieEntities = viewModel.getFavoritedMovies().getValue();
        verify(dataRepository).getFavoritedMovies();
        assertNotNull(movieEntities);
        assertEquals(10, movieEntities.size());

        viewModel.getFavoritedMovies().observeForever(observer);
        verify(observer).onChanged(dummyMovies);
    }
}
