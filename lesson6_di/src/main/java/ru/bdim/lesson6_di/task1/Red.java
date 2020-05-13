package ru.bdim.lesson6_di.task1;

import android.util.Log;

public class Red {
    private static final String TAG = "...Red";

    public Red(){
        Green green = new Green();
        Log.d(TAG, String.format("%s, %s", green.show(), green));
    }
}
