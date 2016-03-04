package com.pocket.monsters.presenter.utils;

import android.app.Application;

import com.pocket.monsters.presenter.interfaces.communications.PokeServer;

/**
 * Created by david on 4/03/16.
 */
public class PokeApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PokeServer.getInstance().Init(this);
    }
}
