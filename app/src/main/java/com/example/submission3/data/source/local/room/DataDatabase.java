package com.example.submission3.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.submission3.data.source.local.entity.MovieEntity;
import com.example.submission3.data.source.local.entity.TvShowEntity;

@Database(entities = {MovieEntity.class, TvShowEntity.class},
        version = 1,
        exportSchema = false)
public abstract class DataDatabase extends RoomDatabase {
    public abstract DataDao dataDao();

    public static volatile DataDatabase INSTANCE;

    public static DataDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (DataDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DataDatabase.class, "Data.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
