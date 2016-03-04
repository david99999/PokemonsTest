package com.pocket.monsters.presenter.utils;

/**
 * Created by david on 4/03/16.
 */
public final class Constants {
    public static final String API_VERSION = "v1";
    public static final String SERVER = "http://pokeapi.co";
    public static final String POKEMON_LIST = "/api/" + API_VERSION + "/pokemon";
    public static final String POKEMON_DETAIL = POKEMON_LIST + "/{pokeId}";
}
