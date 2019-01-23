package com.kusnir.lastfmsearch.ui.artist_detail;


import android.widget.ImageView;

import com.kusnir.lastfmsearch.R;
import com.kusnir.lastfmsearch.ui.base.BaseViewModel;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class ArtistDetailViewModel extends BaseViewModel {

    @Inject
    public ArtistDetailViewModel() {
    }

    public void loadImage(ImageView artistImageView, String artistImageUrl) {
        if (artistImageUrl != null && !artistImageUrl.isEmpty()) {
            Picasso.get()
                    .load(artistImageUrl)
                    .error(R.mipmap.ic_launcher_round)
                    .into(artistImageView);
        } else {
            Picasso.get().load(R.mipmap.ic_launcher_round).into(artistImageView);
        }
    }

}
