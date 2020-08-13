package ru.geekbrains.activitystate;

import android.os.Parcel;
import android.os.Parcelable;

public class Counters implements Parcelable {
    private int counter1;
    private int counter2;
    private int counter3;
    private int counter4;

    public Counters(){
        counter1 = 0;
        counter2 = 0;
        counter3 = 0;
        counter4 = 0;
    }

    protected Counters(Parcel in) {
        counter1 = in.readInt();
        counter2 = in.readInt();
        counter3 = in.readInt();
        counter4 = in.readInt();
    }

    public static final Creator<Counters> CREATOR = new Creator<Counters>() {
        @Override
        public Counters createFromParcel(Parcel in) {
            return new Counters(in);
        }

        @Override
        public Counters[] newArray(int size) {
            return new Counters[size];
        }
    };

    public int getCounter1() {
        return counter1;
    }

    public int getCounter2() {
        return counter2;
    }

    public int getCounter3() {
        return counter3;
    }

    public int getCounter4() {
        return counter4;
    }

    public void incrementCounter1(){
        counter1++;
    }

    public void incrementCounter2(){
        counter2++;
    }

    public void incrementCounter3(){
        counter3++;
    }

    public void incrementCounter4(){
        counter4++;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(counter1);
        dest.writeInt(counter2);
        dest.writeInt(counter3);
        dest.writeInt(counter4);
    }
}
