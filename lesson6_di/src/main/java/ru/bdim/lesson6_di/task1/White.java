package ru.bdim.lesson6_di.task1;

import android.util.Log;

public class White {
    private static final String TAG = "...White";

    public White(){
        Green green = new Green();
        Log.d(TAG, String.format("%s, %s", green.show(), green));
    }
}