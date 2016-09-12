package ua.nure.ipz.zoo.entity;

import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Animal extends DomainEntity {

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "aviary_id")
    private Aviary aviary;
    private String name;
    private String type;

    public Animal() {
    }

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Aviary getAviary() {
        return aviary;
    }

    public void setAviary(Aviary aviary) {
        this.aviary = aviary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s\nName = %s\nType = %s", super.toString(), name, type);
    }
}
