package com.example.submission3.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.submission3.data.source.DataRepository;
import com.example.submission3.data.source.local.entity.MovieEntity;
import com.example.submission3.ui.detail.movie.DetailMovieViewModel;
import com.example.submission3.utils.DataMovie;
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
public class DetailMovieViewModelTest {
    private DetailMovieViewModel viewModel;
    private final MovieEntity dummyMovie = DataMovie.generateDummyMovie().get(0);
    private final String movieId = dummyMovie.getMovieId();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private DataRepository dataRepository;

    @Mock
    private Observer<Resource<MovieEntity>> movieObserver;

    @Before
    public void setUp() {
        viewModel = new DetailMovieViewModel(dataRepository);
        viewModel.setSelectedMovie(movieId);
    }

    @Test
    public void getMovie() {
        Resource<MovieEntity> resDummyMovie = Resource.success(dummyMovie);
        MutableLiveData<Resource<MovieEntity>> movie = new MutableLiveData<>();
        movie.setValue(resDummyMovie);
        when(dataRepository.getDetailMovie(movieId)).thenReturn(movie);

        viewModel.movie.observeForever(movieObserver);
        verify(movieObserver).onChanged(resDummyMovie);
    }

    @Test
    public void setMovieFavorite() {
        Resource<MovieEntity> resDummyMovie = Resource.success(dummyMovie);
        MutableLiveData<Resource<MovieEntity>> movie = new MutableLiveData<>();
        movie.setValue(resDummyMovie);

        when(dataRepository.getDetailMovie(movieId)).thenReturn(movie);
        viewModel.setSelectedMovie(movieId);
        viewModel.movie.observeForever(movieObserver);

        boolean newState = !movie.getValue().data.isFavorited();
        doNothing().when(dataRepository).setMovieFavorited(movie.getValue().data, newState);

        viewModel.setFavorite();
        verify(dataRepository, times(1)).setMovieFavorited(movie.getValue().data, newState);
    }
}
