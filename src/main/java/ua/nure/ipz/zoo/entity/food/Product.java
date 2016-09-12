package ua.nure.ipz.zoo.entity.food;

import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product extends DomainEntity {

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ration_id")
    private Ration ration;

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

    public Ration getRation() {
        return ration;
    }

    public void setRation(Ration ration) {
        this.ration = ration;
    }

    @Override
    public String toString() {
        return String.format("%s\nName = %s\nPrice = %s", super.toString(), name, price);
    }
}
