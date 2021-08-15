package com.example.submission3.di;

import android.content.Context;

import com.example.submission3.data.source.DataRepository;
import com.example.submission3.data.source.local.LocalDataSource;
import com.example.submission3.data.source.local.room.DataDatabase;
import com.example.submission3.data.source.remote.RemoteDataSource;
import com.example.submission3.utils.AppExecutors;
import com.example.submission3.utils.JsonHelper;

public class Injection {
    public static DataRepository provideRepository(Context context) {
        DataDatabase dataDatabase = DataDatabase.getInstance(context);

        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(new JsonHelper(context));
        LocalDataSource localDataSource = LocalDataSource.getInstance(dataDatabase.dataDao());
        AppExecutors appExecutors = new AppExecutors();

        return DataRepository.getInstance(remoteDataSource, localDataSource, appExecutors);
    }
}
