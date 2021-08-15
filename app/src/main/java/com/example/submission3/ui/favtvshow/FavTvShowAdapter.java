package com.example.submission3.ui.favtvshow;

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
import com.example.submission3.data.source.local.entity.TvShowEntity;
import com.example.submission3.databinding.ItemTvShowBinding;
import com.example.submission3.ui.detail.favtvshow.DetailFavTvShowActivity;
import com.example.submission3.ui.detail.tvshow.DetailTvShowActivity;

public class FavTvShowAdapter extends PagedListAdapter<TvShowEntity, FavTvShowAdapter.FavTvShowViewHolder> {

    FavTvShowAdapter() {
        super(DIFF_CALLBACK);
    }

    public TvShowEntity getSwipedData(int position) {
        return getItem(position);
    }

    private static final DiffUtil.ItemCallback<TvShowEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TvShowEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull TvShowEntity oldItem, @NonNull TvShowEntity newItem) {
                    return oldItem.getTvShowId().equals(newItem.getTvShowId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull TvShowEntity oldItem, @NonNull TvShowEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @NonNull
    @Override
    public FavTvShowAdapter.FavTvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTvShowBinding binding = ItemTvShowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FavTvShowAdapter.FavTvShowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavTvShowAdapter.FavTvShowViewHolder holder, int position) {
        TvShowEntity tvshow = getItem(position);
        holder.bind(tvshow);
    }

    static class FavTvShowViewHolder extends RecyclerView.ViewHolder {

        private final ItemTvShowBinding binding;

        FavTvShowViewHolder(ItemTvShowBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        void bind(TvShowEntity tvShow) {
            binding.tvItemTitle.setText(tvShow.getTitle());
            binding.tvItemReleaseDateText.setText(tvShow.getDate());
            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(itemView.getContext(), DetailFavTvShowActivity.class);
                intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, tvShow.getTvShowId());
                itemView.getContext().startActivity(intent);
            });
            Glide.with(itemView.getContext())
                    .load(tvShow.getPoster())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(binding.imgItemPoster);
        }
    }
}
