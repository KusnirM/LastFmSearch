package com.kusnir.lastfmsearch.ui.search;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kusnir.lastfmsearch.R;
import com.kusnir.lastfmsearch.models.artist_models.Artist;
import com.kusnir.lastfmsearch.models.artist_models.Image;
import com.kusnir.lastfmsearch.util.OnItemSelectedListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchAdapterViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.artist_image)
    ImageView artistImageView;
    @BindView(R.id.artist_name)
    TextView artistNameTextview;
    Context context;

    public SearchAdapterViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        context = itemView.getContext();
    }

    public void bind(Artist artist, OnItemSelectedListener listener) {
        List<Image> imageList = artist.getImage();
        Image artistImage = imageList.get(imageList.size() - 1);

        // Set Artist Image
        setImage(artistImageView, artistImage.getText());

        // Set Artist Name
        artistNameTextview.setText(artist.getName());

        itemView.setOnClickListener(view -> {
               listener.onArtistSelected(artist);
        });
    }

    private void setImage(ImageView imageView, String imageUrl) {
        if (imageUrl != null && !imageUrl.isEmpty()) {
            Picasso.get()
                    .load(imageUrl)
                    .error(R.mipmap.ic_launcher_round)
                    .into(imageView);
        } else {
            Picasso.get().load(R.mipmap.ic_launcher_round).into(imageView);
        }
    }
}
