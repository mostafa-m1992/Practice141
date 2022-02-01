package com.example.practice141.Models;

public class ModelCategory {

    int id;
    int image;
    String titleCategory;

    public ModelCategory(int id, int image, String titleCategory) {
        this.id = id;
        this.image = image;
        this.titleCategory = titleCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitleCategory() {
        return titleCategory;
    }

    public void setTitleCategory(String titleCategory) {
        this.titleCategory = titleCategory;
    }
}
