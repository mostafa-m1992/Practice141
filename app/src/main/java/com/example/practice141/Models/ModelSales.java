package com.example.practice141.Models;

public class ModelSales {

    int id;
    int image;
    String title;
    String visit;
    int price;

    public ModelSales(int id, int image, String title, String visit, int price) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.visit = visit;
        this.price = price;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVisit() {
        return visit;
    }

    public void setVisit(String visit) {
        this.visit = visit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
