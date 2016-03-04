package com.pocket.monsters.view.features.listThemAll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.pocket.monsters.R;
import com.pocket.monsters.model.Pokemon;
import com.pocket.monsters.presenter.adapters.PokemonsListAdapter;
import com.pocket.monsters.presenter.implementations.PokemonsPresenterImpl;
import com.pocket.monsters.presenter.interfaces.PokemonsView;

import java.util.ArrayList;

public class Pokemons extends AppCompatActivity implements PokemonsView {

    RecyclerView rvPokemons;
    ProgressBar pbLoading;
    PokemonsPresenterImpl pokemonsPresenter;
    PokemonsListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemons);
        rvPokemons = (RecyclerView) findViewById(R.id.rvPokemons);
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
    public void showMessage(View view) {
        Toast.makeText(this, R.string.excuse, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setItems(ArrayList<Pokemon> items) {
        pbLoading.setVisibility(View.GONE);
        rvPokemons.setVisibility(View.VISIBLE);
        if (adapter == null) {
            adapter = new PokemonsListAdapter(items, pokemonsPresenter);
            rvPokemons.setAdapter(adapter);
        }
        else {
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
