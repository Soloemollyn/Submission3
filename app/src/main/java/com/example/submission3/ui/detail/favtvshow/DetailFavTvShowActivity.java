package com.example.submission3.ui.detail.favtvshow;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.submission3.data.source.local.entity.TvShowEntity;
import com.example.submission3.databinding.ActivityDetailFavTvShowBinding;
import com.example.submission3.databinding.ContentDetailFavTvShowBinding;
import com.example.submission3.ui.detail.tvshow.DetailTvShowViewModel;
import com.example.submission3.viewmodel.ViewModelFactory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.submission3.R;

public class DetailFavTvShowActivity extends AppCompatActivity {

    public static final String EXTRA_TVSHOW = "extra_tvshow";
    private ContentDetailFavTvShowBinding contentDetailFavTvShowBinding;
    private ActivityDetailFavTvShowBinding activityDetailFavTvShowBinding;

    DetailTvShowViewModel viewModel;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityDetailFavTvShowBinding = ActivityDetailFavTvShowBinding.inflate(getLayoutInflater());
        contentDetailFavTvShowBinding = activityDetailFavTvShowBinding.detailFavTvShow;

        setContentView(activityDetailFavTvShowBinding.getRoot());

        setSupportActionBar(activityDetailFavTvShowBinding.toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        viewModel = new ViewModelProvider(this, factory).get(DetailTvShowViewModel.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String tvShowId = extras.getString(EXTRA_TVSHOW);
            if (tvShowId != null) {
                viewModel.setSelectedTvShow(tvShowId);
                viewModel.tvShow.observe(this, tvShowEntity -> {
                    if (tvShowEntity != null) {
                        switch (tvShowEntity.status) {
                            case LOADING:
                                activityDetailFavTvShowBinding.progressBar.setVisibility(View.VISIBLE);
                                break;
                            case SUCCESS:
                                if (tvShowEntity.data != null) {
                                    activityDetailFavTvShowBinding.progressBar.setVisibility(View.GONE);
                                    activityDetailFavTvShowBinding.content.setVisibility(View.VISIBLE);
                                    populateTvShow(tvShowEntity.data);
                                }
                                break;
                            case ERROR:
                                activityDetailFavTvShowBinding.progressBar.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
            }
        }
    }

    private void populateTvShow(TvShowEntity tvShow) {
        contentDetailFavTvShowBinding.title.setText(tvShow.getTitle().concat(" (").concat(tvShow.getYear()).concat(")"));
        contentDetailFavTvShowBinding.releaseDateText.setText(tvShow.getDate());
        contentDetailFavTvShowBinding.genreText.setText(tvShow.getGenre());
        contentDetailFavTvShowBinding.durationText.setText(tvShow.getDuration());
        contentDetailFavTvShowBinding.descText.setText(tvShow.getDescription());
        Glide.with(this)
                .load(tvShow.getPoster())
                .transform(new RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(contentDetailFavTvShowBinding.imagePoster);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        this.menu = menu;
        viewModel.tvShow.observe(this, tvShowEntity -> {
            if (tvShowEntity != null) {
                switch (tvShowEntity.status) {
                    case LOADING:
                        activityDetailFavTvShowBinding.progressBar.setVisibility(View.VISIBLE);
                        break;
                    case SUCCESS:
                        if (tvShowEntity.data != null) {
                            activityDetailFavTvShowBinding.progressBar.setVisibility(View.GONE);
                            boolean state = tvShowEntity.data.isFavorited();
                            setBookmarkState(state);
                        }
                        break;
                    case ERROR:
                        activityDetailFavTvShowBinding.progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_favorite) {
            viewModel.setFavorite();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        contentDetailFavTvShowBinding = null;
        activityDetailFavTvShowBinding = null;
    }

    private void setBookmarkState(boolean state) {
        if (menu == null) return;
        MenuItem menuItem = menu.findItem(R.id.action_favorite);
        if (state) {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorited_white));
        } else {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white));
        }
    }
}