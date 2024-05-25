package com.example.allin.models;


public class Plant {
    private int id;
    private String photoUri;
    private String name;
    private String description;
    private String temperature;
    private int light;
    private int water;
    private int difficulty;

    public Plant() {}

    public Plant(String PhotoUri, String name, String description, String temperature, int light, int water, int difficulty) {
        this.photoUri = PhotoUri;
        this.name = name;
        this.description = description;
        this.temperature = temperature;
        this.light = light;
        this.water = water;
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoUri() {
        return photoUri;
    }

    public void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getLight() {
        return light;
    }

    public void setLight(int light) {
        this.light = light;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}