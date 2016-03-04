package com.pocket.monsters.presenter.interfaces;

/**
 * Created by david on 4/03/16.
 */
public interface LoadProcessListener {
    void OnDataLoaded(Object data);
    void OnError(Throwable exception);
    void OnDestroy();
}
