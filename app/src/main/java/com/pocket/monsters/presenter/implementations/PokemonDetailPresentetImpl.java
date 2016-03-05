package com.pocket.monsters.presenter.implementations;

import com.pocket.monsters.model.Sprite;
import com.pocket.monsters.presenter.interfaces.LoadProcessListener;
import com.pocket.monsters.presenter.interfaces.PokemonDetailPresenter;
import com.pocket.monsters.presenter.interfaces.PokemonDetailView;

/**
 * Created by david on 5/03/16.
 */
public class PokemonDetailPresentetImpl implements PokemonDetailPresenter, LoadProcessListener {

    private final PokemonDetailView view;
    LoadSpriteFromServerInteractorImpl interactor;

    public PokemonDetailPresentetImpl(PokemonDetailView view) {
        this.view = view;
        interactor = new LoadSpriteFromServerInteractorImpl();
    }


    @Override
    public void OnDataLoaded(Object data) {
        view.setSprite((Sprite) data);
    }

    @Override
    public void OnError(Throwable exception) {
        view.hideLoading();
        view.showError(exception.getMessage());
    }

    @Override
    public void OnDestroy() {
        interactor.releaseSubscription();
    }

    @Override
    public void loadSPrite(String url) {
        interactor.loadData(url, this);
    }
}
