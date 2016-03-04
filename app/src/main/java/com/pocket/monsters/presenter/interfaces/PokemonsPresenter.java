package com.pocket.monsters.presenter.interfaces;

import android.view.View;

/**
 * Created by david on 4/03/16.
 */
public interface PokemonsPresenter {

    void loadItems(int offset);

    void viewClicked(View view);
}
