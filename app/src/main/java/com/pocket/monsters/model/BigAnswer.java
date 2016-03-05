package com.pocket.monsters.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by david on 4/03/16.
 */
public class BigAnswer implements Serializable{
    @SerializedName("objects")
    public ArrayList<Pokemon> pokemons;
}
