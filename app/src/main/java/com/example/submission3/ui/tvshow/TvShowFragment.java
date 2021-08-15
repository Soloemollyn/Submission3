package com.example.submission3.ui.tvshow;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.submission3.databinding.FragmentTvShowBinding;
import com.example.submission3.viewmodel.ViewModelFactory;

public class TvShowFragment extends Fragment {

    private FragmentTvShowBinding fragmentTvShowBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(inflater, container, false);
        return fragmentTvShowBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            TvShowViewModel viewModel = new ViewModelProvider(this, factory).get(TvShowViewModel.class);

            TvShowAdapter tvShowAdapter = new TvShowAdapter();

            viewModel.getTvShow().observe(getViewLifecycleOwner(), tvShows -> {
                if (tvShows != null) {
                    switch (tvShows.status) {
                        case LOADING:
                            fragmentTvShowBinding.progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            fragmentTvShowBinding.progressBar.setVisibility(View.GONE);
                            tvShowAdapter.submitList(tvShows.data);
                            break;
                        case ERROR:
                            fragmentTvShowBinding.progressBar.setVisibility(View.GONE);
                            Toast.makeText(getContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });

            fragmentTvShowBinding.rvTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentTvShowBinding.rvTvShow.setHasFixedSize(true);
            fragmentTvShowBinding.rvTvShow.setAdapter(tvShowAdapter);
        }
    }
}