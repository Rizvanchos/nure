package ua.nure.ipz.zoo.model;

import ua.nure.ipz.zoo.util.Entity;

import java.util.HashSet;
import java.util.Set;

public class Aviary extends Entity {

    private Set<Animal> animals = new HashSet<>();
    private float temperature;
    private float wet;
    private boolean contactFlag;

    public Aviary(float temperature, float wet) {
        this.temperature = temperature;
        this.wet = wet;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getWet() {
        return wet;
    }

    public boolean isContact() {
        return contactFlag;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setWet(float wet) {
        this.wet = wet;
    }

    public void setContact(boolean contactFlag) {
        this.contactFlag = contactFlag;
    }

    public boolean addAnimal(Animal a) {
        return animals.add(a);
    }

    public boolean removeAnimal(Animal a) {
        return animals.remove(a);
    }

    public boolean contains(Animal a) {
        return animals.contains(a);
    }

    public boolean isEmpty() {
        return animals.size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ID = " + getDomainId() + "\nTemperature = " + getTemperature() + "\nWet = "
                + getWet() + "\nContact = " + isContact() + "\n\nAnimals:\n");
        animals.forEach(a -> sb.append("\n" + a + "\n"));
        return sb.toString();
    }

}
