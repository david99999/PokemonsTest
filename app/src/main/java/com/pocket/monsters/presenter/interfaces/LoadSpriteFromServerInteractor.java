package com.pocket.monsters.presenter.interfaces;

/**
 * Created by david on 5/03/16.
 */
public interface LoadSpriteFromServerInteractor {

    void loadData(String url, LoadProcessListener listener);

    void releaseSubscription();
}
