package com.pocket.monsters.presenter.interfaces;

import com.pocket.monsters.model.Pokemon;

/**
 * Created by david on 4/03/16.
 */
public interface PokemonsPresenter {

    void loadItems(int offset);

    void pokemonClicked(Pokemon pokemon);
}
