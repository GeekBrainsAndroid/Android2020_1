package ru.geekbrains.cityheraldry;

import android.os.Parcel;
import android.os.Parcelable;

public class City implements Parcelable {
    private int imageIndex;
    private String cityName;

    public City(int imageIndex, String cityName){
        this.imageIndex = imageIndex;
        this.cityName = cityName;
    }

    protected City(Parcel in) {
        imageIndex = in.readInt();
        cityName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getImageIndex());
        dest.writeString(getCityName());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public int getImageIndex() {
        return imageIndex;
    }

    public String getCityName() {
        return cityName;
    }
}
