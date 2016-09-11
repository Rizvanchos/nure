package ua.nure.ipz.zoo.entity;

import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.ElementCollection;
import java.util.HashSet;
import java.util.Set;

//@Entity
public class Aviary extends DomainEntity {

    @ElementCollection
    private Set<Animal> animals = new HashSet<>();
    private boolean contactFlag;
    private float temperature;
    private float wet;

    public Aviary() {
    }

    public Aviary(float temperature, float wet) {
        this.temperature = temperature;
        this.wet = wet;
    }

    public boolean isContact() {
        return contactFlag;
    }

    public void setContact(boolean contactFlag) {
        this.contactFlag = contactFlag;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
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
        StringBuilder sb = new StringBuilder("ID = " + getDomainId() + "\nTemperature = " + getTemperature() + "\nWet = "
                + getWet() + "\nContact = " + isContact() + "\n\nAnimals:\n");
        animals.forEach(a -> sb.append("\n" + a + "\n"));
        return sb.toString();
    }
}
