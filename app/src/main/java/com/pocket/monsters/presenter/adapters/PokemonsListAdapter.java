package com.pocket.monsters.presenter.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;
import com.pocket.monsters.R;
import com.pocket.monsters.model.Pokemon;
import com.pocket.monsters.presenter.interfaces.PokemonListListener;
import com.pocket.monsters.presenter.interfaces.PokemonsPresenter;
import com.pocket.monsters.view.holders.GenericHolder;
import com.pocket.monsters.view.holders.PokemonListItem;

import java.util.ArrayList;

/**
 * Created by david on 4/03/16.
 */
public class PokemonsListAdapter extends UltimateViewAdapter<GenericHolder> implements PokemonListListener {

    private final PokemonsPresenter listener;
    private final ArrayList<Pokemon> items;

    public PokemonsListAdapter(ArrayList<Pokemon> items, PokemonsPresenter listener){
        this.items = items;
        this.listener = listener;
    }

    @Override
    public GenericHolder getViewHolder(View view) {
        return new GenericHolder(view);
    }

    @Override
    public GenericHolder onCreateViewHolder(ViewGroup parent) {
        PokemonListItem holder = (PokemonListItem) LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_list_item, parent, false);
        GenericHolder viewHolder = new GenericHolder(holder);
        viewHolder.setListListener(this);
        return viewHolder;
    }


    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getAdapterItemCount() {
        return items.size();
    }

    @Override
    public long generateHeaderId(int position) {
        return 0;
    }

    public void appendNewPokemons(ArrayList<Pokemon> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(GenericHolder holder, int position) {
        ((PokemonListItem)holder.itemView).setPokemon(items.get(position));
    }

    @Override
    public void itemClicked(int position) {
        listener.pokemonClicked(items.get(position));
    }
}
