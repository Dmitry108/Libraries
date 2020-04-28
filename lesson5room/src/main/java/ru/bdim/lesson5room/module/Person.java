package ru.bdim.lesson5room.module;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.List;
import java.util.Locale;

@Entity(tableName = "persons",
        indices = @Index(value = {"surname"}))
public class Person {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "surname")
    private String surname;

    @ColumnInfo(name = "age")
    private int age;


    public Person(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(List<String> list) {
        if (!list.get(0).equals("")) {
            this.id =  Integer.parseInt(list.get(0));
        }
        this.name = list.get(1);
        this.surname = list.get(2);
        this.age = Integer.parseInt(list.get(3));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return String.format(Locale.ROOT,
                "{\"id\":\"%s\"," +
                       "\"name\":\"%s\"," +
                       "\"surname\":\"%s\"," +
                       "\"age\":\"%s\"}", id, name, surname, age);
    }
}