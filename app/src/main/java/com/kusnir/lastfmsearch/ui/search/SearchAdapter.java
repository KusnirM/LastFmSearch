package com.kusnir.lastfmsearch.ui.search;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kusnir.lastfmsearch.R;
import com.kusnir.lastfmsearch.models.artist_models.Artist;
import com.kusnir.lastfmsearch.util.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapterViewHolder> {

    private OnItemSelectedListener listener;
    List<Artist> artistList = new ArrayList<>();

    public SearchAdapter(OnItemSelectedListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public SearchAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapterViewHolder holder, int position) {
        Artist artist = getItem(position);
        holder.bind(artist, listener);
    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }


    public void setItems(List<Artist> newArtists) {
        artistList.clear();
        artistList.addAll(newArtists);
        notifyDataSetChanged();
    }


    public Artist getItem(int pos) {
        return artistList.get(pos);
    }

}
