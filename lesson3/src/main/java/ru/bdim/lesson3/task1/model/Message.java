package ru.bdim.lesson3.task1.model;

import java.util.Locale;

public class Message {

    private String title;
    private String body;
    private int number;

    public Message(int number, String title, String body){
        this.title = title;
        this.body = body;
        this.number = number;
    }
    @Override
    public String toString(){
        return String.format(Locale.ROOT,"сообщение №%d: %s: %s", number, title, body);
    }
}