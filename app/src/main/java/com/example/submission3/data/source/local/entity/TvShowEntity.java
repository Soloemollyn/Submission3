package com.example.submission3.data.source.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tvshowentities")
public class TvShowEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    private final String tvShowId;

    @ColumnInfo(name = "title")
    private final String title;

    @ColumnInfo(name = "genre")
    private final String genre;

    @ColumnInfo(name = "duration")
    private final String duration;

    @ColumnInfo(name = "description")
    private final String description;

    @ColumnInfo(name = "date")
    private final String date;

    @ColumnInfo(name = "year")
    private final String year;

    @ColumnInfo(name = "poster")
    private final String poster;

    @ColumnInfo(name = "favorited")
    private boolean favorited;

    public TvShowEntity(@NonNull String tvShowId, String title, String genre, String duration,
                        String description, String date, String year, String poster, boolean favorited) {
        this.tvShowId = tvShowId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.description = description;
        this.date = date;
        this.year = year;
        this.poster = poster;
        this.favorited = favorited;
    }

    @NonNull
    public String getTvShowId() {
        return tvShowId;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getYear() {
        return year;
    }

    public String getPoster() {
        return poster;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }
}
