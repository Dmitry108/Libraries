package ru.bdim.lesson4.task1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Peroid {
    @Expose
    @SerializedName("time_of_year")
    private String time_of_year;
    @Expose
    @SerializedName("year")
    private int year;

    public String getTimeOfYear() {
        return time_of_year;
    }

    public int getYear() {
        return year;
    }
}