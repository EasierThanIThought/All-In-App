package com.example.allin.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "allIn_db";
    private static final int DATABASE_VERSION = 2;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE plants (id INTEGER PRIMARY KEY, imageData TEXT, name TEXT UNIQUE, description TEXT, temperature TEXT, light INTEGER, water INTEGER, difficulty INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS plants");
        onCreate(db);
    }

    public void insertPlant(Plant plant) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("imageData", plant.getImageData());
        values.put("name", plant.getName());
        values.put("description", plant.getDescription());
        values.put("temperature", plant.getTemperature());
        values.put("light", plant.getLight());
        values.put("water", plant.getWater());
        values.put("difficulty", plant.getDifficulty());
        db.insert("plants", null, values);
        db.close();
    }

    public List<Plant> getAllPlants() {
        List<Plant> plantList = new ArrayList<>();
        String selectQuery = "SELECT * FROM plants";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Plant plant = new Plant();
                plant.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));

                plant.setImageData(cursor.getString(cursor.getColumnIndexOrThrow("imageData")));
                //  plant.setImageData(cursor.getBlob(cursor.getColumnIndex("imageData")));

                plant.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
                plant.setDescription(cursor.getString(cursor.getColumnIndexOrThrow("description")));
                plant.setTemperature(cursor.getString(cursor.getColumnIndexOrThrow("temperature")));
                plant.setLight(cursor.getInt(cursor.getColumnIndexOrThrow("light")));
                plant.setWater(cursor.getInt(cursor.getColumnIndexOrThrow("water")));
                plant.setDifficulty(cursor.getInt(cursor.getColumnIndexOrThrow("difficulty")));
                plantList.add(plant);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return plantList;
    }
}
