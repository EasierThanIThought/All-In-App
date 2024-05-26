package com.example.allin.models;

public class Pet {
    private int id;
    private String imageData;
    private String name;
    private String description;
    private String fur;
    private String breed;
    private int age;

    public Pet() {}

    public Pet(int id, String  imageData, String name, String description, String fur, String breed, int age) {
        this.id = id;
        this.imageData = imageData;
        this.name = name;
        this.description = description;
        this.fur = fur;
        this.breed = breed;
        this.age = age;
    }

    public Pet(String  imageData, String name, String description, String fur, String breed, int age) {
        this.imageData = imageData;
        this.name = name;
        this.description = description;
        this.fur = fur;
        this.breed = breed;
        this.age = age;
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

    public String getFur() {
        return fur;
    }

    public void setFur(String fur) {
        this.fur = fur;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
