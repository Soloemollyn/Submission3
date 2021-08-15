package com.example.submission3.ui.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.example.submission3.data.source.DataRepository;
import com.example.submission3.data.source.local.entity.MovieEntity;
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
public class MovieViewModelTest {
    private MovieViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private DataRepository dataRepository;

    @Mock
    private Observer<Resource<PagedList<MovieEntity>>> observer;

    @Mock
    private PagedList<MovieEntity> pagedList;

    @Before
    public void setUp() {
        viewModel = new MovieViewModel(dataRepository);
    }

    @Test
    public void getMovies() {
        Resource<PagedList<MovieEntity>> dummyMovies = Resource.success(pagedList);
        when(dummyMovies.data.size()).thenReturn(10);
        MutableLiveData<Resource<PagedList<MovieEntity>>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(dataRepository.getAllMovies()).thenReturn(movies);
        List<MovieEntity> movieEntities = viewModel.getMovies().getValue().data;
        verify(dataRepository).getAllMovies();
        assertNotNull(movieEntities);
        assertEquals(10, movieEntities.size());

        viewModel.getMovies().observeForever(observer);
        verify(observer).onChanged(dummyMovies);
    }
}
