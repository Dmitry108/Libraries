package ru.bdim.lesson5room.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;
import ru.bdim.lesson5room.module.Person;

public interface RoomView extends MvpView {
    @StateStrategyType(value = AddToEndSingleStrategy.class)
    void showMessage(String message);

    @StateStrategyType(value = AddToEndSingleStrategy.class)
    void showPerson(Person person);
}