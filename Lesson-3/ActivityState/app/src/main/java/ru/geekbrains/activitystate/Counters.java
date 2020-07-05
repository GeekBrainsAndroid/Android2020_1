package ru.geekbrains.activitystate;

public class Counters {
    private int counter1;
    private int counter2;

    public Counters(){
        counter1 = 0;
        counter2 = 0;
    }

    public int getCounter1() {
        return counter1;
    }

    public int getCounter2() {
        return counter2;
    }

    public void incrementCounter1(){
        counter1++;
    }

    public void incrementCounter2(){
        counter2++;
    }
}
