package ua.nure.ipz.zoo.model;

import ua.nure.ipz.zoo.util.DomainEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Ration extends DomainEntity {

    private Map<Product, Float> products = new HashMap<>();
    private Animal animal;

    public Ration() {
    }

    public Ration(Animal animal) {
        this.animal = animal;
    }

    public boolean addProduct(Product product, float amount) {
        Objects.requireNonNull(product, "Product can't be null!");
        return null == products.put(product, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(animal + "\n");
        products.entrySet().forEach(e -> sb.append("Product = " + e.getKey() + ", amount: " + e.getValue() + "\n"));
        return sb.toString();
    }
}
