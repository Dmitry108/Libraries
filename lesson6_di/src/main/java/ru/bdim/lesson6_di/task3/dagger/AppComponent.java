package ru.bdim.lesson6_di.task3.dagger;

import javax.inject.Singleton;

import dagger.Component;
import ru.bdim.lesson6_di.task3.Red;
import ru.bdim.lesson6_di.task3.White;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(Red red);
    void inject(White white);
}
