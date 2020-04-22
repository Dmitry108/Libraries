package ru.bdim.lesson3.task1.model;

import android.util.Log;

import java.security.SecureRandom;
import java.util.Locale;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class Model {

private Observable<Message> observable;

    public Model(){
        observable = Observable.create((ObservableOnSubscribe<Message>) emitter -> {
                SecureRandom rn = new SecureRandom();
                for (int i = 0; i < 10; i++){
                    try {
                        Thread.sleep(5000);
                        int t = rn.nextInt(10) + 5;
                        Message msg = new Message(i, "Погода", String.format(Locale.ROOT, "температура +%d C, поток - %s", t, Thread.currentThread().getName()));
                        emitter.onNext(msg);
                    } catch (InterruptedException e){
                        Log.d(Const.TAG, e.toString());
                    }
                }
                emitter.onComplete();
        }).subscribeOn(Schedulers.io())
                .publish()
                .refCount();
    }

    public Observable<Message> getData(){
        return observable;
    }
}
