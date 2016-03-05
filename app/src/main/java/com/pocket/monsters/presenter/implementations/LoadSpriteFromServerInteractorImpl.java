package com.pocket.monsters.presenter.implementations;

import com.pocket.monsters.model.Sprite;
import com.pocket.monsters.presenter.interfaces.LoadProcessListener;
import com.pocket.monsters.presenter.interfaces.LoadSpriteFromServerInteractor;
import com.pocket.monsters.presenter.interfaces.communications.PokeServer;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by david on 5/03/16.
 */
public class LoadSpriteFromServerInteractorImpl implements LoadSpriteFromServerInteractor {
    Subscription subscription;
    LoadProcessListener listener;

    @Override
    public void loadData(String url, LoadProcessListener listener) {
        this.listener = listener;
        subscription = PokeServer
                .getInstance()
                .getInteractor()
                .GetPokemonSprite(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Action1<Sprite>() {
                    @Override
                    public void call(Sprite answer) {
                        if (LoadSpriteFromServerInteractorImpl.this.listener != null)
                            LoadSpriteFromServerInteractorImpl.this.listener.OnDataLoaded(answer);
                    }
                })
                .onErrorReturn(new Func1<Throwable, Sprite>() {
                    @Override
                    public Sprite call(Throwable throwable) {
                        if (LoadSpriteFromServerInteractorImpl.this.listener != null)
                            LoadSpriteFromServerInteractorImpl.this.listener.OnError(throwable);
                        return new Sprite();
                    }
                })
                .subscribe();
    }

    @Override
    public void releaseSubscription() {
        if (subscription != null && subscription.isUnsubscribed())
            subscription.unsubscribe();
    }
}
