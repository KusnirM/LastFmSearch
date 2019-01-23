package com.kusnir.lastfmsearch.ui.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;

import android.os.Bundle;
import android.widget.SearchView;

import com.kusnir.lastfmsearch.LastFmSearchApp;
import com.kusnir.lastfmsearch.R;
import com.kusnir.lastfmsearch.models.artist_models.Artist;
import com.kusnir.lastfmsearch.ui.base.BaseActivity;
import com.kusnir.lastfmsearch.util.OnItemSelectedListener;

import javax.inject.Inject;

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

    }

    @Override public void onArtistSelected(Artist artist) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}
