package com.pocket.monsters.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by david on 5/03/16.
 */
public class Sprite {
    @SerializedName("created")
    public String  created;

    @SerializedName("id")
    public int  id;

    @SerializedName("image")
    public String  image;

    @SerializedName("modified")
    public String  modified;

    @SerializedName("name")
    public String  name;

    @SerializedName("resource_uri")
    public String  resource_uri;

}
