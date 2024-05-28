package com.example.allin.models;

public class Decoration {
    private int id;
    private String imageData;
    private String name;
    private String material;
    private String description;
    private int price;
    private String videoData;

    public Decoration() {}

    public Decoration(int id, String  imageData, String name,String material, String description, int price, String videoData) {
        this.id = id;
        this.imageData = imageData;
        this.name = name;
        this.material = material;
        this.description = description;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
