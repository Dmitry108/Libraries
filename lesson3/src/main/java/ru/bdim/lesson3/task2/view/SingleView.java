package ru.bdim.lesson3.task2.view;

import moxy.MvpView;
import moxy.viewstate.strategy.SingleStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface SingleView extends MvpView {

    @StateStrategyType(value = SingleStateStrategy.class)
    void loadPicture(String str);
}
