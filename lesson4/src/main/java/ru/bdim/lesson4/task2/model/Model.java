package ru.bdim.lesson4.task2.model;

import android.widget.HorizontalScrollView;

import com.squareup.picasso.Picasso;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model {

    private ApiHub api;
    private static final String BASE_URL = "https://api.github.com/";
    private String name;


    public Model(){
        name = "JakeWharton";
        api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiHub.class);
    }

    public Single<HubRequest> getAvatarUrl() {
        return api.getHub(name).subscribeOn(Schedulers.io());
    }
}
