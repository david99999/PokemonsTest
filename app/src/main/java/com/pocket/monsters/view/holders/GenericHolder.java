package com.pocket.monsters.view.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pocket.monsters.presenter.interfaces.PokemonListListener;

/**
 * Created by david on 4/03/16.
 */
public class GenericHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public void setListListener(PokemonListListener listListener) {
        this.listListener = listListener;
    }

    PokemonListListener listListener;

    public GenericHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (listListener != null) {
            listListener.itemClicked(getAdapterPosition());
        }
    }
}
