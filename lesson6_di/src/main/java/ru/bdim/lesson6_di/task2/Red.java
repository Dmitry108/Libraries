package ru.bdim.lesson6_di.task2;

import android.util.Log;

public class Red {
    private static final String TAG = "Di...Red";

    public Red(Green green){
        Log.d(TAG, String.format("%s, %s", green.show(), green));
    }
}
