package com.pocket.monsters.presenter.implementations;

import com.pocket.monsters.model.BigAnswer;
import com.pocket.monsters.presenter.interfaces.LoadFromServerInteractor;
import com.pocket.monsters.presenter.interfaces.LoadProcessListener;
import com.pocket.monsters.presenter.interfaces.communications.PokeServer;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by david on 4/03/16.
 */
public class LoadFromServerInteractorImpl implements LoadFromServerInteractor {
    Subscription subscription;
    LoadProcessListener listener;

    @Override
    public void loadData(int offset, final LoadProcessListener listener) {
        this.listener = listener;
        subscription = PokeServer
                .getInstance()
                .getInteractor()
                .GetPokemons(20, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Action1<BigAnswer>() {
                    @Override
                    public void call(BigAnswer answer) {
                        listener.OnDataLoaded(answer.pokemons);
                    }
                })
                .onErrorReturn(new Func1<Throwable, BigAnswer>() {
                    @Override
                    public BigAnswer call(Throwable throwable) {
                        listener.OnError(throwable);
                        return new BigAnswer();
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
