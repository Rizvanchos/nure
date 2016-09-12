package ua.nure.ipz.zoo.entity;

import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Aviary extends DomainEntity {

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "aviary")
    private List<Animal> animals = new ArrayList<>();
    private boolean contactFlag;
    private float temperature;
    private float wet;

    public Aviary() {
    }

    public Aviary(float temperature, float wet) {
        this.temperature = temperature;
        this.wet = wet;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public boolean isContact() {
        return contactFlag;
    }

    public void setContact(boolean contactFlag) {
        this.contactFlag = contactFlag;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getWet() {
        return wet;
    }

    public void setWet(float wet) {
        this.wet = wet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString() + "\nTemperature = " + temperature + "\nWet = "
                + wet + "\nContact = " + contactFlag + "\n\nAnimals:\n");
        animals.forEach(a -> sb.append("\n" + a + "\n"));
        return sb.toString();
    }
}
