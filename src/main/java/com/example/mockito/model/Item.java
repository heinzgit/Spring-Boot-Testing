package com.example.mockito.model;

public class Item {


    private int id;
    private String name;
    private int price;
    private int quality;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public Item(int id, String name, int price, int quality) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quality = quality;
    }
}
