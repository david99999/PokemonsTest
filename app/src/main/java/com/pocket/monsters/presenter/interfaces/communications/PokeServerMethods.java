package com.pocket.monsters.presenter.interfaces.communications;

import com.pocket.monsters.model.BigAnswer;
import com.pocket.monsters.model.Sprite;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

import static com.pocket.monsters.presenter.utils.Constants.POKEMON_LIST;

/**
 * Created by david on 4/03/16.
 */
public interface PokeServerMethods {

    @GET(POKEMON_LIST)
    Observable<BigAnswer> GetPokemons(@Query("limit") Integer limit, @Query("offset") Integer offset);

    @GET()
    Observable<Sprite> GetPokemonSprite(@Url String route);
}
