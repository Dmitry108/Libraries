package ru.bdim.lesson6_di.task3;

import android.util.Log;

import javax.inject.Inject;

import ru.bdim.lesson6_di.task3.dagger.App;

public class White {
    private static final String TAG = "Dagger...White";

    @Inject
    Green green;

    public White(){
        App.getAppComponent().inject(this);
        Log.d(TAG, String.format("%s, %s", green.show(), green));
    }
}
