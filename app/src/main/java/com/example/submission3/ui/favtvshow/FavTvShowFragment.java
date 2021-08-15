package com.example.submission3.ui.favtvshow;

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
import com.example.submission3.data.source.local.entity.TvShowEntity;
import com.example.submission3.databinding.FragmentFavTvShowBinding;
import com.example.submission3.viewmodel.ViewModelFactory;
import com.google.android.material.snackbar.Snackbar;

public class FavTvShowFragment extends Fragment {

    private FragmentFavTvShowBinding fragmentFavTvShowBinding;
    FavTvShowViewModel viewModel;
    FavTvShowAdapter tvShowAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentFavTvShowBinding = FragmentFavTvShowBinding.inflate(inflater, container, false);
        return fragmentFavTvShowBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        itemTouchHelper.attachToRecyclerView(fragmentFavTvShowBinding.rvFavTvShow);

        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            viewModel = new ViewModelProvider(this, factory).get(FavTvShowViewModel.class);

            tvShowAdapter = new FavTvShowAdapter();

            fragmentFavTvShowBinding.progressBar.setVisibility(View.VISIBLE);
            viewModel.getFavoritedTvShows().observe(getViewLifecycleOwner(), tvShows -> {
                fragmentFavTvShowBinding.progressBar.setVisibility(View.GONE);
                tvShowAdapter.submitList(tvShows);
                tvShowAdapter.notifyDataSetChanged();
            });

            fragmentFavTvShowBinding.rvFavTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentFavTvShowBinding.rvFavTvShow.setHasFixedSize(true);
            fragmentFavTvShowBinding.rvFavTvShow.setAdapter(tvShowAdapter);
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
                TvShowEntity tvShowEntity = tvShowAdapter.getSwipedData(swipedPosition);
                viewModel.setFavorite(tvShowEntity);
                Snackbar snackbar = Snackbar.make(getView(), R.string.message_undo, Snackbar.LENGTH_LONG);
                snackbar.setAction(R.string.message_ok, v -> viewModel.setFavorite(tvShowEntity));
                snackbar.show();
            }
        }
    });
}