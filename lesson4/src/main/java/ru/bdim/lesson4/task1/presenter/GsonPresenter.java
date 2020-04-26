package ru.bdim.lesson4.task1.presenter;

import android.util.Log;

import com.google.gson.Gson;

import java.lang.reflect.Field;

import java.util.Locale;

import ru.bdim.lesson4.task1.model.Model;
import ru.bdim.lesson4.task1.model.Peroid;

public class GsonPresenter {

    private Model model;
    private static final String TAG = "...";

    public GsonPresenter(){
        model = new Model();
    }

    public void getAndParseJson() {
        Gson gson = new Gson();
        Peroid peroid = gson.fromJson(model.getJson(), Peroid.class);
        Field[] fields = peroid.getClass().getDeclaredFields();
        for (Field field: fields){
            try {
                field.setAccessible(true);
                Log.d(TAG, String.format(Locale.ROOT,
                        "%s - %s", field.getName(),
                        String.valueOf(field.get(peroid))));
            } catch (IllegalAccessException e) {
                Log.d(TAG, e.toString());
            }
        }
    }
}