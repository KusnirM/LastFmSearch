package com.kusnir.lastfmsearch.ui.artist_detail;



import com.kusnir.lastfmsearch.injection.component.ApplicationComponent;
import com.kusnir.lastfmsearch.injection.scope.ActivityScope;
import com.kusnir.lastfmsearch.ui.base.BaseComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class)
interface ArtistDetailComponent extends BaseComponent<ArtistDetailViewModel> {
    void inject(ArtistDetailActivity artistDetailActivity);
}
