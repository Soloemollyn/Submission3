package com.example.submission3.utils;

import android.content.Context;

import com.example.submission3.data.source.remote.response.MovieResponse;
import com.example.submission3.data.source.remote.response.TvShowResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    private final Context context;

    public JsonHelper(Context context) {
        this.context = context;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private String parsingFileToString(String filename) {
        try {
            InputStream is = context.getAssets().open(filename);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new String(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<MovieResponse> loadMovie() {
        ArrayList<MovieResponse> list = new ArrayList<>();
        try {
            String json = parsingFileToString("MovieResponses.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("movie");
                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject movie = listArray.getJSONObject(i);

                    String id = movie.getString("id");
                    String title = movie.getString("title");
                    String genre = movie.getString("genre");
                    String duration = movie.getString("duration");
                    String description = movie.getString("description");
                    String date = movie.getString("date");
                    String year = movie.getString("year");
                    String poster = movie.getString("poster");

                    MovieResponse movieResponse = new MovieResponse(id, title, genre, duration, description, date, year, poster);
                    list.add(movieResponse);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public MovieResponse loadSelectedMovie(String movieId) {
        MovieResponse movieResponse = null;
        try {
            String json = parsingFileToString("MovieResponses.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("movie");
                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject movie = listArray.getJSONObject(i);

                    if (movie.getString("id").equals(movieId)) {
                        String id = movie.getString("id");
                        String title = movie.getString("title");
                        String genre = movie.getString("genre");
                        String duration = movie.getString("duration");
                        String description = movie.getString("description");
                        String date = movie.getString("date");
                        String year = movie.getString("year");
                        String poster = movie.getString("poster");

                        movieResponse = new MovieResponse(id, title, genre, duration, description, date, year, poster);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movieResponse;
    }

    public List<TvShowResponse> loadTvShow() {
        ArrayList<TvShowResponse> list = new ArrayList<>();
        try {
            String json = parsingFileToString("TvShowResponses.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("tvshow");
                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject tvShow = listArray.getJSONObject(i);

                    String id = tvShow.getString("id");
                    String title = tvShow.getString("title");
                    String genre = tvShow.getString("genre");
                    String duration = tvShow.getString("duration");
                    String description = tvShow.getString("description");
                    String date = tvShow.getString("date");
                    String year = tvShow.getString("year");
                    String poster = tvShow.getString("poster");

                    TvShowResponse tvShowResponse = new TvShowResponse(id, title, genre, duration, description, date, year, poster);
                    list.add(tvShowResponse);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }



    public TvShowResponse loadSelectedTvShow(String tvShowId) {
        TvShowResponse tvShowResponse = null;
        try {
            String json = parsingFileToString("TvShowResponses.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("tvshow");
                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject tvShow = listArray.getJSONObject(i);

                    if (tvShow.getString("id").equals(tvShowId)) {
                        String id = tvShow.getString("id");
                        String title = tvShow.getString("title");
                        String genre = tvShow.getString("genre");
                        String duration = tvShow.getString("duration");
                        String description = tvShow.getString("description");
                        String date = tvShow.getString("date");
                        String year = tvShow.getString("year");
                        String poster = tvShow.getString("poster");

                        tvShowResponse = new TvShowResponse(id, title, genre, duration, description, date, year, poster);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tvShowResponse;
    }
}
