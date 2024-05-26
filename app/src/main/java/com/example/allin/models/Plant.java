package com.example.allin.models;

public class Plant {
    private int id;
    private String imageData;
    private String name;
    private String description;
    private String temperature;
    private int light;
    private int water;
    private int difficulty;

    public Plant() {}

    public Plant(int id, String  imageData, String name, String description, String temperature, int light, int water, int difficulty) {
        this.id = id;
        this.imageData = imageData;
        this.name = name;
        this.description = description;
        this.temperature = temperature;
        this.light = light;
        this.water = water;
        this.difficulty = difficulty;
    }

    public Plant(String  imageData, String name, String description, String temperature, int light, int water, int difficulty) {
        this.imageData = imageData;
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

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String  imageData) {
        this.imageData = imageData;
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