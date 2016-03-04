package com.pocket.monsters.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by david on 4/03/16.
 */
public class BigAnswer {
    @SerializedName("objects")
    public ArrayList<Pokemon> pokemons;
}
