package com.pocket.monsters.view.holders;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.pocket.monsters.R;
import com.pocket.monsters.model.Pokemon;
import com.pocket.monsters.presenter.interfaces.PokemonsPresenter;

/**
 * Created by david on 4/03/16.
 */
public class PokemonListItem extends CardView {
    private TextView tvName;
    private PokemonsPresenter listener;

    public PokemonListItem(Context context) {
        super(context);
    }

    public PokemonListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PokemonListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tvName = (TextView) findViewById(R.id.tvPokemonName);
    }

   public void setPokemon(Pokemon pokemon) {
        tvName.setText(pokemon.name);
    }

    public void setClickListeners(PokemonsPresenter listener) {
        this.listener = listener;
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                PokemonListItem.this.listener.viewClicked(v);
            }
        });
    }
}
