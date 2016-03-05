package com.pocket.monsters.view.features.listThemAll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.pocket.monsters.R;
import com.pocket.monsters.model.Pokemon;
import com.pocket.monsters.presenter.adapters.PokemonsListAdapter;
import com.pocket.monsters.presenter.implementations.PokemonsPresenterImpl;
import com.pocket.monsters.presenter.interfaces.PokemonsView;
import com.pocket.monsters.view.features.showThemAll.PokemonDetail;

import java.util.ArrayList;

public class Pokemons extends AppCompatActivity implements PokemonsView {

    UltimateRecyclerView rvPokemons;
    ProgressBar pbLoading;
    PokemonsPresenterImpl pokemonsPresenter;
    PokemonsListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemons);
        rvPokemons = (UltimateRecyclerView) findViewById(R.id.rvPokemons);
        rvPokemons.setLayoutManager(new LinearLayoutManager(this));
        rvPokemons.setOnLoadMoreListener(new UltimateRecyclerView.OnLoadMoreListener() {
            @Override
            public void loadMore(int itemsCount, int maxLastVisiblePosition) {
                if (pokemonsPresenter != null && adapter != null && rvPokemons.isLoadMoreEnabled())
                    pokemonsPresenter.loadItems(adapter.getItemCount());
            }
        });
        pbLoading = (ProgressBar) findViewById(R.id.pbLoadingPokemons);
        pokemonsPresenter = new PokemonsPresenterImpl(this);
        pokemonsPresenter.loadItems(0);

    }

    @Override
    public void showLoading() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void pokemonClicked(Pokemon item) {
        Bundle data = new Bundle();
        data.putSerializable("Selected", item);
        Intent intentShowDetail = new Intent(this, PokemonDetail.class);
        intentShowDetail.putExtras(data);
        startActivity(intentShowDetail);
    }


    @Override
    public void setItems(ArrayList<Pokemon> items) {
        pbLoading.setVisibility(View.GONE);
        rvPokemons.setVisibility(View.VISIBLE);
        if (items.size() == 0) {
            rvPokemons.disableLoadmore();
            return;
        }
        if (adapter == null) {
            adapter = new PokemonsListAdapter(items, pokemonsPresenter);
            rvPokemons.enableLoadmore();
            adapter.setCustomLoadMoreView(LayoutInflater.from(this)
                    .inflate(R.layout.loading_more, null));
            rvPokemons.setAdapter(adapter);
        } else {
            adapter.appendNewPokemons(items);
        }
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pokemonsPresenter.OnDestroy();
    }
}
