package com.example.submission3.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.submission3.data.source.local.LocalDataSource;
import com.example.submission3.data.source.local.entity.MovieEntity;
import com.example.submission3.data.source.local.entity.TvShowEntity;
import com.example.submission3.data.source.remote.ApiResponse;
import com.example.submission3.data.source.remote.RemoteDataSource;
import com.example.submission3.data.source.remote.response.MovieResponse;
import com.example.submission3.data.source.remote.response.TvShowResponse;
import com.example.submission3.utils.AppExecutors;
import com.example.submission3.vo.Resource;

import java.util.ArrayList;
import java.util.List;

public class DataRepository implements DataSource {
    private volatile static DataRepository INSTANCE = null;

    private final RemoteDataSource remoteDataSource;
    private final LocalDataSource localDataSource;
    private final AppExecutors appExecutors;

    private DataRepository(@NonNull RemoteDataSource remoteDataSource, @NonNull LocalDataSource localDataSource, AppExecutors appExecutors) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.appExecutors = appExecutors;
    }

    public static DataRepository getInstance(RemoteDataSource remoteData, LocalDataSource localDataSource, AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (DataRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DataRepository(remoteData, localDataSource, appExecutors);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<Resource<PagedList<MovieEntity>>> getAllMovies() {
        return new NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {

            @Override
            protected LiveData<PagedList<MovieEntity>> loadFromDB() {
                PagedList.Config config = new PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(4)
                        .setPageSize(4)
                        .build();
                return new LivePagedListBuilder<>(localDataSource.getAllMovies(), config).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<MovieEntity> data) {
                return (data==null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return remoteDataSource.getAllMovies();
            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {
                ArrayList<MovieEntity> movieList = new ArrayList<>();
                for (MovieResponse response : data) {
                    MovieEntity movie = new MovieEntity(response.getMovieId(),
                            response.getTitle(),
                            response.getGenre(),
                            response.getDuration(),
                            response.getDescription(),
                            response.getDate(),
                            response.getYear(),
                            response.getPoster(),
                            false);
                    movieList.add(movie);
                }
                localDataSource.insertMovies(movieList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<PagedList<MovieEntity>> getFavoritedMovies() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build();
        return new LivePagedListBuilder<>(localDataSource.getFavoritedMovies(), config).build();
    }

    @Override
    public LiveData<PagedList<TvShowEntity>> getFavoritedTvShows() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build();
        return new LivePagedListBuilder<>(localDataSource.getFavoritedTvShows(), config).build();
    }

    @Override
    public LiveData<Resource<MovieEntity>> getDetailMovie(String movieId) {
        return new NetworkBoundResource<MovieEntity, MovieResponse>(appExecutors) {

            @Override
            protected LiveData<MovieEntity> loadFromDB() {
                return localDataSource.getSelectedMovie(movieId);
            }

            @Override
            protected Boolean shouldFetch(MovieEntity data) {
                return (data == null);
            }

            @Override
            protected LiveData<ApiResponse<MovieResponse>> createCall() {
                return remoteDataSource.getSelectedMovie(movieId);
            }

            @Override
            protected void saveCallResult(MovieResponse data) {

            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<PagedList<TvShowEntity>>> getAllTvShows() {
        return new NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResponse>>(appExecutors) {

            @Override
            protected LiveData<PagedList<TvShowEntity>> loadFromDB() {
                PagedList.Config config = new PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(4)
                        .setPageSize(4)
                        .build();
                return new LivePagedListBuilder<>(localDataSource.getAllTvShows(), config).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<TvShowEntity> data) {
                return (data==null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<TvShowResponse>>> createCall() {
                return remoteDataSource.getAllTvShows();
            }

            @Override
            protected void saveCallResult(List<TvShowResponse> data) {
                ArrayList<TvShowEntity> tvShowList = new ArrayList<>();
                for (TvShowResponse response : data) {
                    TvShowEntity tvShow = new TvShowEntity(response.getTvShowId(),
                            response.getTitle(),
                            response.getGenre(),
                            response.getDuration(),
                            response.getDescription(),
                            response.getDate(),
                            response.getYear(),
                            response.getPoster(),
                            false);
                    tvShowList.add(tvShow);
                }
                localDataSource.insertTvShows(tvShowList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<TvShowEntity>> getDetailTvShow(final String tvShowId) {
        return new NetworkBoundResource<TvShowEntity, TvShowResponse>(appExecutors){

            @Override
            protected LiveData<TvShowEntity> loadFromDB() {
                return localDataSource.getSelectedTvShow(tvShowId);
            }

            @Override
            protected Boolean shouldFetch(TvShowEntity data) {
                return (data == null);
            }

            @Override
            protected LiveData<ApiResponse<TvShowResponse>> createCall() {
                return remoteDataSource.getSelectedTvShow(tvShowId);
            }

            @Override
            protected void saveCallResult(TvShowResponse data) {

            }
        }.asLiveData();
    }

    @Override
    public void setMovieFavorited(MovieEntity movie, boolean state) {
        appExecutors.diskIO().execute(() -> localDataSource.setMovieFavorite(movie, state));
    }

    @Override
    public void setTvShowFavorited(TvShowEntity tvShow, boolean state) {
        appExecutors.diskIO().execute(() -> localDataSource.setTvShowFavorite(tvShow, state));
    }
}