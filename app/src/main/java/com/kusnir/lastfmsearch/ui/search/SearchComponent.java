package com.kusnir.lastfmsearch.ui.search;


import com.kusnir.lastfmsearch.injection.component.ApplicationComponent;
import com.kusnir.lastfmsearch.injection.scope.ActivityScope;
import com.kusnir.lastfmsearch.ui.base.BaseComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class)
interface SearchComponent extends BaseComponent<SearchViewModel> {
    void inject(SearchActivity searchActivity);

}
