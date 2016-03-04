package com.pocket.monsters.presenter.interfaces;

/**
 * Created by david on 4/03/16.
 */
public interface LoadFromServerInteractor {
    void loadData(int offset, LoadProcessListener listener);

    void releaseSubscription();
}
