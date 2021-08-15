package com.example.submission3.ui.favmovie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.submission3.R;
import com.example.submission3.data.source.local.entity.MovieEntity;
import com.example.submission3.databinding.ItemMovieBinding;
import com.example.submission3.ui.detail.favmovie.DetailFavMovieActivity;
import com.example.submission3.ui.detail.movie.DetailMovieActivity;

public class FavMovieAdapter extends PagedListAdapter<MovieEntity, FavMovieAdapter.FavMovieViewHolder> {

    public FavMovieAdapter() {
        super(DIFF_CALLBACK);
    }

    public MovieEntity getSwipedData(int position) {
        return getItem(position);
    }

    private static final DiffUtil.ItemCallback<MovieEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MovieEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
                    return oldItem.getMovieId().equals(newItem.getMovieId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @NonNull
    @Override
    public FavMovieAdapter.FavMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieBinding binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FavMovieAdapter.FavMovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavMovieAdapter.FavMovieViewHolder holder, int position) {
        MovieEntity movie = getItem(position);
        holder.bind(movie);
    }

    static class FavMovieViewHolder extends RecyclerView.ViewHolder {

        private final ItemMovieBinding binding;

        FavMovieViewHolder(ItemMovieBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        void bind(MovieEntity movie) {
            binding.tvItemTitle.setText(movie.getTitle());
            binding.tvItemReleaseDateText.setText(movie.getDate());
            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(itemView.getContext(), DetailFavMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.getMovieId());
                itemView.getContext().startActivity(intent);
            });
            Glide.with(itemView.getContext())
                    .load(movie.getPoster())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(binding.imgItemPoster);
        }
    }
}
