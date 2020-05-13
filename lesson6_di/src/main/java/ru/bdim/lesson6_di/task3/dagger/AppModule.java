package ru.bdim.lesson6_di.task3.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.bdim.lesson6_di.task3.Green;

@Module
public class AppModule {

    @Singleton
    @Provides
    public Green provideGreen(){
        return new Green();
    }
}