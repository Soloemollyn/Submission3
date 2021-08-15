package com.example.submission3.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShowResponse implements Parcelable {

    private final String tvShowId;
    private final String title;
    private final String genre;
    private final String duration;
    private final String description;
    private final String date;
    private final String year;
    private final String poster;

    public TvShowResponse(String tvShowId, String title, String genre, String duration, String description, String date, String year, String poster) {
        this.tvShowId = tvShowId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.description = description;
        this.date = date;
        this.year = year;
        this.poster = poster;
    }

    protected TvShowResponse(Parcel in) {
        tvShowId = in.readString();
        title = in.readString();
        genre = in.readString();
        duration = in.readString();
        description = in.readString();
        date = in.readString();
        year = in.readString();
        poster = in.readString();
    }

    public static final Creator<TvShowResponse> CREATOR = new Creator<TvShowResponse>() {
        @Override
        public TvShowResponse createFromParcel(Parcel in) {
            return new TvShowResponse(in);
        }

        @Override
        public TvShowResponse[] newArray(int size) {
            return new TvShowResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(tvShowId);
        parcel.writeString(title);
        parcel.writeString(genre);
        parcel.writeString(duration);
        parcel.writeString(description);
        parcel.writeString(date);
        parcel.writeString(year);
        parcel.writeString(poster);
    }

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
}
