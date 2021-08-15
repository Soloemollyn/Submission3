package com.example.submission3.data.source.remote;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.submission3.data.source.remote.response.MovieResponse;
import com.example.submission3.data.source.remote.response.TvShowResponse;
import com.example.submission3.utils.EspressoIdlingResource;
import com.example.submission3.utils.JsonHelper;

import java.util.List;

public class RemoteDataSource {
    private static RemoteDataSource INSTANCE;
    private final JsonHelper jsonHelper;
    private final Handler handler = new Handler();
    private final long SERVICE_LATENCY_IN_MILIS = 1000;

    private RemoteDataSource(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteDataSource getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(helper);
        }
        return INSTANCE;
    }

    public LiveData<ApiResponse<List<MovieResponse>>> getAllMovies() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<MovieResponse>>> movieResponses = new MutableLiveData<>();
        handler.postDelayed(() -> {
            movieResponses.setValue(ApiResponse.success(jsonHelper.loadMovie()));
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILIS);
        return movieResponses;
    }

    public LiveData<ApiResponse<MovieResponse>> getSelectedMovie(String movieId) {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<MovieResponse>> movieResponse = new MutableLiveData<>();
        handler.postDelayed(() -> {
            movieResponse.setValue(ApiResponse.success(jsonHelper.loadSelectedMovie(movieId)));
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILIS);
        return movieResponse;
    }

    public LiveData<ApiResponse<TvShowResponse>> getSelectedTvShow(String tvShowId) {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<TvShowResponse>> tvShowResponse = new MutableLiveData<>();
        handler.postDelayed(() -> {
            tvShowResponse.setValue(ApiResponse.success(jsonHelper.loadSelectedTvShow(tvShowId)));
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILIS);
        return tvShowResponse;
    }

    public interface LoadMovieCallback {
        void onAllMoviesReceived(List<MovieResponse> movieResponses);
    }

    public LiveData<ApiResponse<List<TvShowResponse>>> getAllTvShows() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<TvShowResponse>>> tvShowResponses = new MutableLiveData<>();
        handler.postDelayed(() -> {
            tvShowResponses.setValue(ApiResponse.success(jsonHelper.loadTvShow()));
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILIS);
        return tvShowResponses;
    }

    public interface LoadTvShowCallback {
        void onAllTvShowsReceived(List<TvShowResponse> tvShowResponses);
    }
}
