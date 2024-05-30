package com.example.allin.models;

import java.util.List;

public class Workshop {
    private int id;
    private String imageData;
    private String name;
    private String materials;
    private String description;
    private int time;
    private int price;
    private String videoData;

    public Workshop() {}

    public Workshop(int id, String imageData, String name, String materials, String description, int time, int price, String videoData) {
        this.id = id;
        this.imageData = imageData;
        this.name = name;
        this.materials = materials;
        this.description = description;
        this.time = time;
        this.price = price;
        this.videoData = videoData;
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

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getVideoData() {
        return videoData;
    }

    public void setVideoData(String videoData) {
        this.videoData = videoData;
    }
}
