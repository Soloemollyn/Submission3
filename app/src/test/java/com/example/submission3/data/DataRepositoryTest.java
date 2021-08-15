package com.example.submission3.data;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import com.example.submission3.data.source.local.LocalDataSource;
import com.example.submission3.data.source.local.entity.MovieEntity;
import com.example.submission3.data.source.local.entity.TvShowEntity;
import com.example.submission3.data.source.remote.RemoteDataSource;
import com.example.submission3.data.source.remote.response.MovieResponse;
import com.example.submission3.data.source.remote.response.TvShowResponse;
import com.example.submission3.utils.AppExecutors;
import com.example.submission3.utils.DataMovie;
import com.example.submission3.utils.DataTvShow;
import com.example.submission3.utils.LiveDataTestUtil;
import com.example.submission3.utils.PagedListUtil;
import com.example.submission3.utils.TestExecutors;
import com.example.submission3.vo.Resource;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DataRepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private final RemoteDataSource remote = mock(RemoteDataSource.class);
    private final LocalDataSource local = mock(LocalDataSource.class);
    private final AppExecutors appExecutors = new AppExecutors(new TestExecutors(), new TestExecutors(), new TestExecutors());

    private final FakeDataRepository fakeDataRepository = new FakeDataRepository(remote, local, appExecutors);

    private final ArrayList<MovieResponse> movieResponses = DataMovie.generateRemoteDummyMovie();
    private final ArrayList<TvShowResponse> tvShowResponses = DataTvShow.generateRemoteDummyTvShow();

    @Test
    public void getAllMovies() {
        DataSource.Factory<Integer, MovieEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(local.getAllMovies()).thenReturn(dataSourceFactory);
        fakeDataRepository.getAllMovies();

        Resource<PagedList<MovieEntity>> movieEntities = Resource.success(PagedListUtil.mockPagedList(DataMovie.generateDummyMovie()));
        verify(local).getAllMovies();
        assertNotNull(movieEntities.data);
        assertEquals(movieResponses.size(), movieEntities.data.size());
    }

    @Test
    public void getDetailMovie() {
        MutableLiveData<MovieEntity> dummyMovie = new MutableLiveData<>();
        dummyMovie.setValue(DataMovie.generateDummyMovie().get(0));
        when(local.getSelectedMovie(DataMovie.generateDummyMovie().get(0).getMovieId())).thenReturn(dummyMovie);
        Resource<MovieEntity> movieEntity = LiveDataTestUtil.getValue(fakeDataRepository.getDetailMovie(DataMovie.generateDummyMovie().get(0).getMovieId()));
        verify(local).getSelectedMovie(DataMovie.generateDummyMovie().get(0).getMovieId());
        assertNotNull(movieEntity.data);
        assertEquals(dummyMovie.getValue().getTitle(), movieEntity.data.getTitle());
        assertEquals(dummyMovie.getValue().getYear(), movieEntity.data.getYear());
        assertEquals(dummyMovie.getValue().getDate(), movieEntity.data.getDate());
        assertEquals(dummyMovie.getValue().getDuration(), movieEntity.data.getDuration());
        assertEquals(dummyMovie.getValue().getGenre(), movieEntity.data.getGenre());
        assertEquals(dummyMovie.getValue().getDescription(), movieEntity.data.getDescription());
    }

    @Test
    public void getAllTvShows() {
        DataSource.Factory<Integer, TvShowEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(local.getAllTvShows()).thenReturn(dataSourceFactory);
        fakeDataRepository.getAllTvShows();

        Resource<PagedList<TvShowEntity>> tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataTvShow.generateDummyTvShow()));
        verify(local).getAllTvShows();
        assertNotNull(tvShowEntities);
        assertEquals(tvShowResponses.size(), tvShowEntities.data.size());
    }

    @Test
    public void getDetailTvShow() {
        MutableLiveData<TvShowEntity> dummyTvShow = new MutableLiveData<>();
        dummyTvShow.setValue(DataTvShow.generateDummyTvShow().get(0));
        when(local.getSelectedTvShow(DataTvShow.generateDummyTvShow().get(0).getTvShowId())).thenReturn(dummyTvShow);
        Resource<TvShowEntity> tvShowEntity = LiveDataTestUtil.getValue(fakeDataRepository.getDetailTvShow(DataTvShow.generateDummyTvShow().get(0).getTvShowId()));
        verify(local).getSelectedTvShow(DataTvShow.generateDummyTvShow().get(0).getTvShowId());
        assertNotNull(tvShowEntity.data);
        assertEquals(dummyTvShow.getValue().getTitle(), tvShowEntity.data.getTitle());
        assertEquals(dummyTvShow.getValue().getYear(), tvShowEntity.data.getYear());
        assertEquals(dummyTvShow.getValue().getDate(), tvShowEntity.data.getDate());
        assertEquals(dummyTvShow.getValue().getDuration(), tvShowEntity.data.getDuration());
        assertEquals(dummyTvShow.getValue().getGenre(), tvShowEntity.data.getGenre());
        assertEquals(dummyTvShow.getValue().getDescription(), tvShowEntity.data.getDescription());
    }

    @Test
    public void setMovieFavorite() {
        MovieEntity dummyMovie = DataMovie.generateDummyMovie().get(0);
        doNothing().when(local).setMovieFavorite(dummyMovie, true);
        fakeDataRepository.setMovieFavorited(dummyMovie, true);
        verify(local, times(1)).setMovieFavorite(dummyMovie, true);
    }

    @Test
    public void setTvShowFavorite() {
        TvShowEntity dummyTvShow = DataTvShow.generateDummyTvShow().get(0);
        doNothing().when(local).setTvShowFavorite(dummyTvShow, true);
        fakeDataRepository.setTvShowFavorited(dummyTvShow, true);
        verify(local, times(1)).setTvShowFavorite(dummyTvShow, true);
    }
}
