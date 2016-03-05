package com.pocket.monsters.presenter.interfaces;

import com.pocket.monsters.model.Pokemon;

import java.util.ArrayList;

/**
 * Created by david on 4/03/16.
 */
public interface PokemonsView {

    void showLoading();

    void hideLoading();

    void pokemonClicked(Pokemon item);

    void setItems(ArrayList<Pokemon> items);

    void showError(String message);

}
