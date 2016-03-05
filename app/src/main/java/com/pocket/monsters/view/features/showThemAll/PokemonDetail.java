package com.pocket.monsters.view.features.showThemAll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.pocket.monsters.R;
import com.pocket.monsters.model.Pokemon;
import com.pocket.monsters.model.Sprite;
import com.pocket.monsters.presenter.implementations.PokemonDetailPresentetImpl;
import com.pocket.monsters.presenter.interfaces.PokemonDetailView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import static com.pocket.monsters.presenter.utils.Constants.SERVER;

public class PokemonDetail extends AppCompatActivity implements PokemonDetailView {

    PokemonDetailPresentetImpl pokemonsPresenter;

    ImageView ivPic;
    TextView tvName, tvId, tvMFRatio;
    Pokemon pokemon;
    ProgressBar pbLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);
        pokemon = (Pokemon) getIntent().getExtras().get("Selected");
        pokemonsPresenter = new PokemonDetailPresentetImpl(this);
        pokemonsPresenter.loadSPrite(pokemon.sprites.get(0).resource_uri);
        ivPic = (ImageView) findViewById(R.id.ivPokemonPic);
        tvId = (TextView) findViewById(R.id.tvPokemonNationalId);
        tvName = (TextView) findViewById(R.id.tvPokemonDetailName);
        tvMFRatio = (TextView) findViewById(R.id.tvPokemonMFRatio);
        pbLoading = (ProgressBar) findViewById(R.id.pbLoadingPic);
        setInfo();
    }

    private void setInfo() {
        setTitle(pokemon.name + getString(R.string.pokemon_details_append));
        tvId.setText(String.format(getString(R.string.national_index_id), String.valueOf(pokemon.national_id)));
        tvName.setText(String.format(getString(R.string.pokemon_name), pokemon.name));
        tvMFRatio.setText(String.format(getString(R.string.male_ratio), pokemon.male_female_ratio));
    }

    @Override
    public void showLoading() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbLoading.setVisibility(View.GONE);
        ivPic.setVisibility(View.VISIBLE);
    }

    @Override
    public void setSprite(Sprite answer) {
        Picasso.with(this)
                .load(SERVER + answer.image)
                .into(ivPic, new Callback() {
                    @Override
                    public void onSuccess() {
                        hideLoading();
                    }

                    @Override
                    public void onError() {

                    }
                });
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
