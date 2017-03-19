package com.devgmail.mitroshin.totutu.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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

//Предоставляет методы для создания БД и дальнейшей работы с ней

public class DatabaseHelper extends SQLiteOpenHelper {

    // Путь к базе данных на устройстве, куда будет скопирована база из assets
    private static  String DB_PATH = "/data/data/com.devgmail.mitroshin.totutu/databases/";

    // название бд
    private static final String DB_NAME = "TuTuDB";

    // версия базы данных
    private static final int SCHEMA = 1;

    // название таблицы в бд
    public static final String CITIES_TABLE = "cities";
    public static final String STATIONS_TABLE = "stations";

    // Поля таблицы Cities
    public static final String CITY_CITY_ID = "_id";
    public static final String CITY_TITLE = "cityTitle";
    public static final String COUNTRY_TITLE = "countryTitle";
    public static final String CITY_LONGITUDE = "cityLongitude";
    public static final String CITY_LATITUDE = "cityLatitude";
    public static final String DISTRICT_TITLE = "districtTitle";
    public static final String REGION_TITLE = "regionTitle";
    public static final String CITY_DIRECTION = "direction";

    // Поля таблицы Stations
    public static final String STATION_ID = "_id";
    public static final String STATION_TITLE = "stationTitle";
    public static final String STATION_CITY_ID = "cityId";
    public static final String STATION_LONGITUDE = "stationLongitude";
    public static final String STATION_LATITUDE = "stationLatitude";
    public static final String STATION_DIRECTION = "stationDirection";

    public SQLiteDatabase database;
    private Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA);
        this.myContext = context;
    }

    // Отрабатывает если база отсутствует или ее версия выше текущей.
    // В качестве параметра получает бызу данных приложения.
    // Экземпляр SQLiteDatabase используется для выполнения запросов.
    @Override
    public void onCreate(SQLiteDatabase db) { }

    // Отрабатывает, после изменения данных в БД или ее структуры.
    // В данном случае удаляется предыдущая версия базы и создается новая.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) { }

    // Создание новой БД на основе локальной.
    public void createDB() {
        InputStream myInput = null;
        OutputStream myOutput = null;

        try {
            File file = new File(DB_PATH + DB_NAME);
            // Если БД уже существует, то не нужно ее снова создавать
            if (!file.exists()) {
                this.getReadableDatabase();

                // Получаем локальную БД как поток
                myInput = myContext.getAssets().open(DB_NAME);

                // Путь к новой БД
                String outFileName = DB_PATH + DB_NAME;

                // Открыть пустую БД
                myOutput = new FileOutputStream(outFileName);

                // Копирование данных побайтого
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }

                myOutput.flush();
                myOutput.close();
                myInput.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Открыть базу только для чтения.
    public void open() throws SQLiteException {
        String path = DB_PATH + DB_NAME;
        database = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
    }

    // Закрыть базу, если она существует.
    @Override
    public synchronized void close() {
        if (database != null) {
            database.close();
        }
        super.close();
    }
}
