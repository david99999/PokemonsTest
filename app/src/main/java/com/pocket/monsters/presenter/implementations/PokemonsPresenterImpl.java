package com.pocket.monsters.presenter.implementations;

import com.pocket.monsters.model.Pokemon;
import com.pocket.monsters.presenter.interfaces.LoadProcessListener;
import com.pocket.monsters.presenter.interfaces.PokemonsPresenter;
import com.pocket.monsters.presenter.interfaces.PokemonsView;

import java.util.ArrayList;

/**
 * Created by david on 4/03/16.
 */
public class PokemonsPresenterImpl implements PokemonsPresenter, LoadProcessListener {

    private final PokemonsView view;
    LoadFromServerInteractorImpl interactor;

    public PokemonsPresenterImpl(PokemonsView view) {
        this.view = view;
        interactor = new LoadFromServerInteractorImpl();
    }

    @Override
    public void loadItems(int offset) {
        view.showLoading();
        interactor.loadData(offset, this);
    }

    @Override
    public void pokemonClicked(Pokemon pokemon) {
        view.pokemonClicked(pokemon);
    }


    @Override
    public void OnDataLoaded(Object data) {
        view.hideLoading();
        view.setItems((ArrayList<Pokemon>) data);
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
}
