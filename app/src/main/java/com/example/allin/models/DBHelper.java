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
        db.execSQL("CREATE TABLE pets (id INTEGER PRIMARY KEY, imageData TEXT, name TEXT UNIQUE, description TEXT, fur TEXT, breed TEXT, age INTEGER)");
        db.execSQL("CREATE TABLE main_pictures (id INTEGER PRIMARY KEY, imageData TEXT, name TEXT, year INTEGER)");
        db.execSQL("CREATE TABLE decorations (id INTEGER PRIMARY KEY, imageData TEXT, name TEXT UNIQUE, material TEXT, description TEXT, price INTEGER, videoData TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS plants");
        db.execSQL("DROP TABLE IF EXISTS pets");
        db.execSQL("DROP TABLE IF EXISTS main_pictures");
        db.execSQL("DROP TABLE IF EXISTS decorations");
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

    public void insertPet(Pet pet) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("imageData", pet.getImageData());
        values.put("name", pet.getName());
        values.put("description", pet.getDescription());
        values.put("fur", pet.getFur());
        values.put("breed", pet.getBreed());
        values.put("age", pet.getAge());
        db.insert("pets", null, values);
        db.close();
    }

    public List<Pet> getAllPets() {
        List<Pet> petList = new ArrayList<>();
        String selectQuery = "SELECT * FROM pets";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Pet pet = new Pet();
                pet.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));

                pet.setImageData(cursor.getString(cursor.getColumnIndexOrThrow("imageData")));

                pet.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
                pet.setDescription(cursor.getString(cursor.getColumnIndexOrThrow("description")));
                pet.setFur(cursor.getString(cursor.getColumnIndexOrThrow("fur")));
                pet.setBreed(cursor.getString(cursor.getColumnIndexOrThrow("breed")));
                pet.setAge(cursor.getInt(cursor.getColumnIndexOrThrow("age")));
                petList.add(pet);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return petList;
    }

    public void insertMainPictures(MainPicture picture) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("imageData", picture.getImageData());
        values.put("name", picture.getName());
        values.put("year", picture.getYear());
        db.insert("main_pictures", null, values);
        db.close();
    }

    public List<MainPicture> getAllPictures() {
        List<MainPicture> pictureList = new ArrayList<>();
        String selectQuery = "SELECT * FROM main_pictures";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                MainPicture picture = new MainPicture();
                picture.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                picture.setImageData(cursor.getString(cursor.getColumnIndexOrThrow("imageData")));
                picture.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
                picture.setYear(cursor.getInt(cursor.getColumnIndexOrThrow("year")));
                pictureList.add(picture);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return pictureList;
    }

    public void insertDecoration(Decoration decoration) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("imageData", decoration.getImageData());
        values.put("name", decoration.getName());
        values.put("material", decoration.getMaterial());
        values.put("description", decoration.getDescription());
        values.put("price", decoration.getPrice());
        values.put("videoData", decoration.getVideoData());

        db.insert("decorations", null, values);
        db.close();
    }

    public List<Decoration> getAllDecorations() {
        List<Decoration> decorationList = new ArrayList<>();
        String selectQuery = "SELECT * FROM decorations";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Decoration decoration = new Decoration();
                decoration.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                decoration.setImageData(cursor.getString(cursor.getColumnIndexOrThrow("imageData")));
                decoration.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
                decoration.setMaterial(cursor.getString(cursor.getColumnIndexOrThrow("material")));
                decoration.setDescription(cursor.getString(cursor.getColumnIndexOrThrow("description")));
                decoration.setPrice(cursor.getInt(cursor.getColumnIndexOrThrow("price")));
                decoration.setVideoData(cursor.getString(cursor.getColumnIndexOrThrow("videoData")));
                decorationList.add(decoration);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return decorationList;
    }
}
