package ru.bdim.lesson6_di.task3.dagger;

import android.app.Application;

public class App extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = createAppComponent();
    }

    public static AppComponent createAppComponent(){
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule())
                .build();
    }
    public static AppComponent getAppComponent(){
        return appComponent;
    }
}