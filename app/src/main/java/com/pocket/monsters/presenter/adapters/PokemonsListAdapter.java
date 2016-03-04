package com.pocket.monsters.presenter.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pocket.monsters.R;
import com.pocket.monsters.model.Pokemon;
import com.pocket.monsters.presenter.interfaces.PokemonsPresenter;
import com.pocket.monsters.view.holders.GenericHolder;
import com.pocket.monsters.view.holders.PokemonListItem;

import java.util.ArrayList;

/**
 * Created by david on 4/03/16.
 */
public class PokemonsListAdapter extends RecyclerView.Adapter<GenericHolder> {

    private final PokemonsPresenter listener;
    private final ArrayList<Pokemon> items;

    public PokemonsListAdapter(ArrayList<Pokemon> items, PokemonsPresenter listener){
        this.items = items;
        this.listener = listener;
    }
    @Override
    public GenericHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PokemonListItem holder = (PokemonListItem) LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_list_item, parent, false);
        holder.setClickListeners(listener);
        return new GenericHolder(holder);
    }

    @Override
    public void onBindViewHolder(GenericHolder holder, int position) {
        ((PokemonListItem)holder.itemView).setPokemon(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void appendNewPokemons(ArrayList<Pokemon> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }
}
