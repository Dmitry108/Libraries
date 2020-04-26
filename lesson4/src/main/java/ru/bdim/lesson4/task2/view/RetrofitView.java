package ru.bdim.lesson4.task2.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface RetrofitView extends MvpView {
    @StateStrategyType(value = AddToEndSingleStrategy.class)
    void setPhoto(String url);
}
