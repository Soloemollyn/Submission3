package com.example.submission3.ui.favmovie;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.submission3.R;
import com.example.submission3.data.source.local.entity.MovieEntity;
import com.example.submission3.databinding.FragmentFavMovieBinding;
import com.example.submission3.viewmodel.ViewModelFactory;
import com.google.android.material.snackbar.Snackbar;

public class FavMovieFragment extends Fragment {

    private FragmentFavMovieBinding fragmentFavMovieBinding;
    FavMovieViewModel viewModel;
    FavMovieAdapter favMovieAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentFavMovieBinding = FragmentFavMovieBinding.inflate(inflater, container, false);
        return fragmentFavMovieBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        itemTouchHelper.attachToRecyclerView(fragmentFavMovieBinding.rvFavMovie);

        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            viewModel = new ViewModelProvider(this, factory).get(FavMovieViewModel.class);

            favMovieAdapter = new FavMovieAdapter();

            fragmentFavMovieBinding.progressBar.setVisibility(View.VISIBLE);
            viewModel.getFavoritedMovies().observe(getViewLifecycleOwner(), movies -> {
                fragmentFavMovieBinding.progressBar.setVisibility(View.GONE);
                favMovieAdapter.submitList(movies);
                favMovieAdapter.notifyDataSetChanged();
            });

            fragmentFavMovieBinding.rvFavMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentFavMovieBinding.rvFavMovie.setHasFixedSize(true);
            fragmentFavMovieBinding.rvFavMovie.setAdapter(favMovieAdapter);
        }
    }

    private final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        }
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return true;
        }
        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            if (getView() != null) {
                int swipedPosition = viewHolder.getAdapterPosition();
                MovieEntity movieEntity = favMovieAdapter.getSwipedData(swipedPosition);
                viewModel.setFavorite(movieEntity);
                Snackbar snackbar = Snackbar.make(getView(), R.string.message_undo, Snackbar.LENGTH_LONG);
                snackbar.setAction(R.string.message_ok, v -> viewModel.setFavorite(movieEntity));
                snackbar.show();
            }
        }
    });
}