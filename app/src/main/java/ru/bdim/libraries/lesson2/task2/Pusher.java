package ru.bdim.libraries.lesson2.task2;

public interface Pusher {
    void subscribe(Observer o);
    void unsubscribe(int index);
    void notifyObserves();
}
