package ru.bdim.libraries.lesson2.task2;

import java.util.ArrayList;
import java.util.List;

public class Spam implements Pusher {
    private List<Observer> list;

    public Spam(){
        list = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer o) {
        list.add(o);
    }
    @Override
    public void unsubscribe(int index) {
        if (index < list.size() && index >=0)
        list.remove(index);
    }
    @Override
    public void notifyObserves() {
        for (Observer o: list){
            o.update();
        }
    }

    public int getCount(){
        return list.size();
    }
}
