package ru.bdim.lesson5room.applicatoin;

import android.app.Application;

import androidx.room.Room;

import ru.bdim.lesson5room.module.PersonDatabase;

public class RoomApp extends Application {

    private static PersonDatabase personDb;

    @Override
    public void onCreate() {
        super.onCreate();
        personDb = Room.databaseBuilder(getApplicationContext(), PersonDatabase.class, "persons")
                .build();
    }

    public static PersonDatabase getPersonDatabase(){
        return personDb;
    }

    @Override
    public void onTerminate() {
        personDb.close();
        super.onTerminate();
    }
}
