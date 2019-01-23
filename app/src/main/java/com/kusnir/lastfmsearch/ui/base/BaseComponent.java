package com.kusnir.lastfmsearch.ui.base;

public interface BaseComponent<VM extends BaseViewModel> {
    VM viewModel();
}