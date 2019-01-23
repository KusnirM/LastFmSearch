package com.kusnir.lastfmsearch.ui.artist_detail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.kusnir.lastfmsearch.LastFmSearchApp;
import com.kusnir.lastfmsearch.R;
import com.kusnir.lastfmsearch.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtistDetailActivity extends BaseActivity<ArtistDetailViewModel, ArtistDetailComponent> {

    public static final String ARTIST_NAME = "ARTIST_NAME";
    public static final String ARTIST_URL = "ARTIST_URL";
    public static final String ARTIST_LISTENERS = "ARTIST_LISTENERS";
    public static final String ARTIST_IMAGE_URL = "ARTITS_IMAGE_URL";

    @BindView(R.id.artist_imageview)
    ImageView artistImageView;
    @BindView(R.id.artist_name)
    TextView artistNameTextview;
    @BindView(R.id.artist_listeners)
    TextView artistListenersTextview;
    @BindView(R.id.artist_url)
    TextView artistUrlTextview;

    @Override
    protected ArtistDetailComponent createComponent() {
        return DaggerArtistDetailComponent.builder()
                .applicationComponent(((LastFmSearchApp) getApplication()).getApplicationComponent())
                .build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_detail);
        ButterKnife.bind(this);
        component.inject(this);

        Bundle bundle = getIntent().getExtras();
        initView(bundle);
    }

    private void initView(Bundle bundle) {

        String artistName = bundle.getString(ARTIST_NAME);
        String artistListeners = bundle.getString(ARTIST_LISTENERS);
        String artistUrl = bundle.getString(ARTIST_URL);
        String artistImageUrl = bundle.getString(ARTIST_IMAGE_URL);

        setTitle(artistName);
        artistNameTextview.setText(artistName);
        artistUrlTextview.setText(artistUrl);
        artistListenersTextview.setText(artistListeners);

        viewModel.loadImage(artistImageView, artistImageUrl);

    }

}