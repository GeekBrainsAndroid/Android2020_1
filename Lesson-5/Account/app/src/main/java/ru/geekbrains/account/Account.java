package ru.geekbrains.account;

import android.os.Parcel;
import android.os.Parcelable;

public class Account implements Parcelable {
    private String name;
    private String surName;
    private int age;
    private String email;

    public Account(){
    }

    public Account(String name, String surname, int age, String email){
        setName(name);
        setSurName(surname);
        setAge(age);
        setEmail(email);
    }

    protected Account(Parcel in) {
        name = in.readString();
        surName = in.readString();
        age = in.readInt();
        email = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surName);
        dest.writeInt(age);
        dest.writeString(email);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
