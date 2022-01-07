package com.example.myapplication.OOP;

import android.text.format.Time;

import java.time.LocalDate;

public class Record {

    public User user;
    private int weight;
    private int length;
    private LocalDate date;
    private Time time;

    public Record(User user, int weight, int length, LocalDate date, Time time){
        this.user = user;
        this.setDate(date);
        this.setTime(time);
        this.setWeight(weight);
        this.setLength(length);

    }

    public Record(User user, int weight, int length, LocalDate date){
        this.user = user;
        this.setDate(date);
        this.setWeight(weight);
        this.setLength(length);

    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setLength(int length) {
        if(length>=this.user.getLength()){
            this.length = length;
        }
    }

    public int getLength() {
        return length;
    }
//compare date with today.,
    public void setDate(LocalDate date) {
        LocalDate today = LocalDate.now();
        if(date.isBefore(today) || date.isEqual(today)){
            this.date = date;
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

    //user status computing
    public String status(){
        return null;
    }

}
