package com.pocket.monsters.presenter.interfaces;

import com.pocket.monsters.model.Sprite;

/**
 * Created by david on 5/03/16.
 */
public interface PokemonDetailView {
    void showLoading();

    void hideLoading();

    void setSprite(Sprite answer);

    void showError(String message);
}
