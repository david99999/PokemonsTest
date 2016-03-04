package com.pocket.monsters.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by david on 4/03/16.
 */
public class Pokemon implements Serializable {
    @SerializedName("attack")
    public int attack;

    @SerializedName("catch_rate")
    public int catch_rate;

    @SerializedName("created")
    public String created;

    @SerializedName("defense")
    public int defense;

    @SerializedName("egg_cycles")
    public int egg_cycles;


    @SerializedName("ev_yield")
    public String ev_yield;


    @SerializedName("exp")
    public int exp;

    @SerializedName("growth_rate")
    public String growth_rate;

    @SerializedName("happiness")
    public int happiness;

    @SerializedName("height")
    public String height;

    @SerializedName("hp")
    public int hp;

    @SerializedName("male_female_ratio")
    public String male_female_ratio;

    @SerializedName("modified")
    public String modified;


    @SerializedName("name")
    public String name;

    @SerializedName("national_id")
    public int national_id;

    @SerializedName("pkdx_id")
    public int pkdx_id;

    @SerializedName("resource_uri")
    public String resource_uri;

    @SerializedName("sp_atk")
    public int sp_atk;

    @SerializedName("sp_def")
    public int sp_def;

    @SerializedName("species")
    public String species;

    @SerializedName("speed")
    public int speed;

    @SerializedName("sprites")
    public ArrayList<Sprite> sprites;

    @SerializedName("total")
    public int total;

    @SerializedName("weight")
    public String weight;

    public class Sprite {
        @SerializedName("name")
        public String name;

        @SerializedName("resource_uri")
        public String resource_uri;
    }
}
