package ru.bdim.lesson3.task2.model;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class Model {

    public Single<String> getData(){
        return Single.create((SingleOnSubscribe<String>) emitter -> {
            emitter.onSuccess("Загружена картинка");
        }).subscribeOn(Schedulers.io());
    }
}
