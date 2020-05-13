package ru.bdim.lesson6_di.task2;

import android.util.Log;

public class White {
    private static final String TAG = "Di...White";

    public White(Green green){
        Log.d(TAG, String.format("%s, %s", green.show(), green));
    }
}
