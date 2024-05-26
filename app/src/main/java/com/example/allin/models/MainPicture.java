package com.example.allin.models;

public class MainPicture {
    private int id;
    private String imageData;
    private String name;
    private int year;

    public MainPicture() { }

    public MainPicture(int id, String imageData, String name, int year) {
        this.id = id;
        this.imageData = imageData;
        this.name = name;
        this.year = year;
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

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
