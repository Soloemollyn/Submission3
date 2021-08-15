package com.example.submission3.ui.favorite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.submission3.databinding.ActivityFavoriteBinding;

public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityFavoriteBinding activityFavoriteBinding = ActivityFavoriteBinding.inflate(getLayoutInflater());
        setContentView(activityFavoriteBinding.getRoot());

        FavSectionPagerAdapter favSectionPagerAdapter = new FavSectionPagerAdapter(this, getSupportFragmentManager());

        activityFavoriteBinding.viewPager.setAdapter(favSectionPagerAdapter);
        activityFavoriteBinding.tabs.setupWithViewPager(activityFavoriteBinding.viewPager);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }
    }
}