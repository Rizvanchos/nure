package ua.nure.ipz.zoo.model;

import ua.nure.ipz.zoo.util.Entity;

public class Product extends Entity {

    private String name;
    private float price;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ID = %s\nName = %s\nPrice = %s", getDomainId(), getName(), getPrice());
    }
}
