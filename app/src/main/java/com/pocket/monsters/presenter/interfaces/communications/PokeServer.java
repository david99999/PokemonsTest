package com.pocket.monsters.presenter.interfaces.communications;

import android.content.Context;

import com.pocket.monsters.BuildConfig;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.pocket.monsters.presenter.utils.Constants.SERVER;


/**
 * Created by david on 4/03/16.
 */
public class PokeServer {

    private volatile static PokeServer instance;
    private PokeServerMethods interactor;

    public PokeServerMethods getInteractor(){
        return interactor;
    }

    protected PokeServer() {
    }

    public static PokeServer getInstance() {
        if (instance == null) {
            synchronized (PokeServer.class) {
                if (instance == null) {
                    instance = new PokeServer();
                }
            }
        }
        return instance;
    }


    public void Init(Context context) {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        builder.cache(new Cache(context.getCacheDir(), 10 * 1024 * 1024));
        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(SERVER)
                .client(builder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        interactor = restAdapter.create(PokeServerMethods.class);
    }

}
