package ru.bdim.libraries.lesson2.task2;

import android.util.Log;

import static ru.bdim.libraries.lesson2.task2.Const.TAG;

public class Bob implements Observer{
    private String name;

    public Bob(int i){
        this.name = "Bob" + i;
    }

    @Override
    public void update() {
        Log.d(TAG, String.format("%s получил спам, поток - %s", name, Thread.currentThread().getName()));
    }
}
