package ru.bdim.lesson6_di.task3;

import android.util.Log;

import javax.inject.Inject;

import ru.bdim.lesson6_di.task3.dagger.App;

public class Red {
    private static final String TAG = "Dagger...Red";

    @Inject
    Green green;

    public Red(){
        App.getAppComponent().inject(this);
        Log.d(TAG, String.format("%s, %s", green.show(), green));
    }

}
