package com.devgmail.mitroshin.totutu.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.devgmail.mitroshin.totutu.util.DatabaseHelper;

/**
 Copyright 2017 Mitroshin Dmitry (mitroshin.develop@gmail.com)

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

// Класс модели, описывающий объекты типа Станция

// Для того чтобы класс модели можно было передавать как дополнение,
// он должен реализовать интерфейс Parcelable и иметь специальные методы
public class Station extends City implements Parcelable {

    private String mStation;
    private Long mId;
    private Double mLongitude;
    private Double mLatitude;

//    Обычный конструктор
    public Station(Cursor stationCursor, Cursor cityCursor) {
        super(cityCursor);

        DatabaseHelper mDatabaseHelper = null;

        this.mStation = stationCursor.getString(stationCursor.
                getColumnIndexOrThrow(mDatabaseHelper.STATION_TITLE));
        this.mId = stationCursor.getLong(stationCursor.
                getColumnIndexOrThrow(mDatabaseHelper.STATION_ID));
        this.mLongitude = stationCursor.getDouble(stationCursor.
                getColumnIndexOrThrow(mDatabaseHelper.STATION_LONGITUDE));
        this.mLatitude = stationCursor.getDouble(stationCursor.
                getColumnIndexOrThrow(mDatabaseHelper.STATION_LATITUDE));

    }

//    Упаковка объекта моели в Parcel
    @Override
    public void writeToParcel (Parcel parcel, int flags) {

        super.writeToParcel(parcel, flags);

        parcel.writeString(mStation);
        parcel.writeLong(mId);
        parcel.writeDouble(mLongitude);
        parcel.writeDouble(mLatitude);
    }

    //    Конструктор, считывающий данные объекта из Parcel
    private Station(Parcel parcel) {
        super(parcel);

        mStation = parcel.readString();
        mId = parcel.readLong();
        mLongitude = parcel.readDouble();
        mLatitude = parcel.readDouble();

    }

    public String getStation() {
        return mStation;
    }

    public Long getStationId() {
        return mId;
    }

    public Double getStationLongitude() {
        return mLongitude;
    }

    public Double getStationLatitude() {
        return mLatitude;
    }

    // Для отладки
    @Override
    public String toString() {

        String strStations = " *** STATION *** \n" +
                "\nStation = " + mStation +
                "\nStation ID = " + mId +
                "\nLongitude = " + mLongitude +
                "\nLatitude = " + mLatitude + "\n";

        String strCity = super.toString();
        String strDivide = "\n-----------------------------------------------------------------\n";
        String strResult = strDivide + strCity + "\n" + strStations + strDivide;
        return strResult;
    }

//    Реализация методов интерфейса
    public static final Creator<Station> CREATOR = new Creator<Station>() {
        @Override
        public Station createFromParcel(Parcel in) {
            return new Station(in);
        }

        @Override
        public Station[] newArray(int size) {
            return new Station[size];
        }
    };
}
