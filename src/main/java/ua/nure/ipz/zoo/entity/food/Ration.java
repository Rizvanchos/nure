package ua.nure.ipz.zoo.entity.food;

import ua.nure.ipz.zoo.entity.Animal;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Ration extends DomainEntity {

    @ElementCollection
    private Map<Product, Float> rationEntries = new HashMap<>();

    @OneToOne(cascade = CascadeType.PERSIST)
    private Animal animal;

    public Ration() {
    }

    public Ration(Animal animal) {
        this.animal = animal;
    }

    public Map<Product, Float> getRationEntries() {
        return rationEntries;
    }

    public void setRationEntries(Map<Product, Float> rationEntries) {
        this.rationEntries = rationEntries;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ID = " + getDomainId() + "\n" + animal + "\n");
        rationEntries.entrySet().forEach(e -> sb.append("Product = " + e.getKey() + ", amount: " + e.getValue() + "\n"));
        return sb.toString();
    }

}
