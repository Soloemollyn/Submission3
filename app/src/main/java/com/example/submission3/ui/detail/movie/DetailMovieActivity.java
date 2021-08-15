package com.example.submission3.ui.detail.movie;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.submission3.data.source.local.entity.MovieEntity;
import com.example.submission3.databinding.ActivityDetailMovieBinding;
import com.example.submission3.databinding.ContentDetailMovieBinding;
import com.example.submission3.viewmodel.ViewModelFactory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.submission3.R;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    private ContentDetailMovieBinding contentDetailMovieBinding;
    private ActivityDetailMovieBinding activityDetailMovieBinding;

    DetailMovieViewModel viewModel;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(getLayoutInflater());
        contentDetailMovieBinding = activityDetailMovieBinding.detailMovie;

        setContentView(activityDetailMovieBinding.getRoot());

        setSupportActionBar(activityDetailMovieBinding.toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        viewModel = new ViewModelProvider(this, factory).get(DetailMovieViewModel.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String movieId = extras.getString(EXTRA_MOVIE);
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId);
                viewModel.movie.observe(this, movieEntity -> {
                    if (movieEntity != null) {
                        switch (movieEntity.status) {
                            case LOADING:
                                activityDetailMovieBinding.progressBar.setVisibility(View.VISIBLE);
                                break;
                            case SUCCESS:
                                if (movieEntity.data != null) {
                                    activityDetailMovieBinding.progressBar.setVisibility(View.GONE);
                                    activityDetailMovieBinding.content.setVisibility(View.VISIBLE);
                                    populateMovie(movieEntity.data);
                                }
                                break;
                            case ERROR:
                                activityDetailMovieBinding.progressBar.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
            }
        }
    }

    private void populateMovie(MovieEntity movie) {
        contentDetailMovieBinding.title.setText(movie.getTitle().concat(" (").concat(movie.getYear()).concat(")"));
        contentDetailMovieBinding.releaseDateText.setText(movie.getDate());
        contentDetailMovieBinding.genreText.setText(movie.getGenre());
        contentDetailMovieBinding.durationText.setText(movie.getDuration());
        contentDetailMovieBinding.descText.setText(movie.getDescription());
        Glide.with(this)
                .load(movie.getPoster())
                .transform(new RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(contentDetailMovieBinding.imagePoster);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        this.menu = menu;
        viewModel.movie.observe(this, movieEntity -> {
            if (movieEntity != null) {
                switch (movieEntity.status) {
                    case LOADING:
                        activityDetailMovieBinding.progressBar.setVisibility(View.VISIBLE);
                        break;
                    case SUCCESS:
                        if (movieEntity.data != null) {
                            activityDetailMovieBinding.progressBar.setVisibility(View.GONE);
                            boolean state = movieEntity.data.isFavorited();
                            setFavoriteState(state);
                        }
                        break;
                    case ERROR:
                        activityDetailMovieBinding.progressBar.setVisibility(View.GONE);
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
        contentDetailMovieBinding = null;
        activityDetailMovieBinding = null;
    }

    private void setFavoriteState(boolean state) {
        if (menu == null) return;
        MenuItem menuItem = menu.findItem(R.id.action_favorite);
        if (state) {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorited_white));
        } else {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white));
        }
    }
}