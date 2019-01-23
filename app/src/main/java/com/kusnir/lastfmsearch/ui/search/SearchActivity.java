package com.kusnir.lastfmsearch.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;

import com.kusnir.lastfmsearch.LastFmSearchApp;
import com.kusnir.lastfmsearch.R;
import com.kusnir.lastfmsearch.models.artist_models.Artist;
import com.kusnir.lastfmsearch.models.artist_models.ArtistResults;
import com.kusnir.lastfmsearch.models.artist_models.Image;
import com.kusnir.lastfmsearch.ui.artist_detail.ArtistDetailActivity;
import com.kusnir.lastfmsearch.ui.base.BaseActivity;
import com.kusnir.lastfmsearch.util.Constants;
import com.kusnir.lastfmsearch.util.OnItemSelectedListener;
import com.kusnir.lastfmsearch.util.RxSearchObservable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class SearchActivity extends BaseActivity<SearchViewModel, SearchComponent> implements OnItemSelectedListener {

    private CompositeDisposable disposable = new CompositeDisposable();
    private SearchAdapter adapter;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.search_recycler_view)
    RecyclerView recyclerView;

    @Override
    protected SearchComponent createComponent() {
        return DaggerSearchComponent.builder()
                .applicationComponent(((LastFmSearchApp) getApplication()).getApplicationComponent())
                .build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        component.inject(this);

        initViews();
    }

    private void initViews() {

        // setup toolbar
        setSupportActionBar(toolbar);

        // setup recyclerview
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        adapter = new SearchAdapter(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        disposable.add(RxSearchObservable.fromView(searchView)

                .debounce(Constants.SEARCH_DEBOUNCE_TIME, TimeUnit.SECONDS)
                .filter(text -> !text.isEmpty())
                .distinctUntilChanged()
                .flatMap(keyword -> viewModel.searchKeyword(keyword))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError));
    }

    private void onSuccess(ArtistResults results) {
        adapter.setItems(results.getResults().getArtistmatches().getArtist());
    }
    private void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override public void onArtistSelected(Artist artist) {
        Intent intent = new Intent(this, ArtistDetailActivity.class);
        intent.putExtra(ArtistDetailActivity.ARTIST_NAME, artist.getName());
        intent.putExtra(ArtistDetailActivity.ARTIST_URL, artist.getUrl());
        intent.putExtra(ArtistDetailActivity.ARTIST_LISTENERS, artist.getListeners());

        List<Image> artistImageList = artist.getImage();
        Image artistImage = artistImageList.get(artistImageList.size() - 1);
        intent.putExtra(ArtistDetailActivity.ARTIST_IMAGE_URL, artistImage != null ? artistImage.getText() : "");
        startActivity(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }

}