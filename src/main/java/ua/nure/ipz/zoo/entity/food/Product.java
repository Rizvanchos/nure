package ua.nure.ipz.zoo.entity.food;

import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.Entity;

@Entity
public class Product extends DomainEntity {

    private String name;
    private float price;

    public Product() {
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ID = %s\nName = %s\nPrice = %s", getDomainId(), name, price);
    }
}
