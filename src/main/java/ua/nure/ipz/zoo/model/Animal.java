package ua.nure.ipz.zoo.model;

import ua.nure.ipz.zoo.util.DomainEntity;

public class Animal extends DomainEntity {

    private String name;
    private String type;

    public Animal() {
    }

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("ID = %s\nName = %s\nType = %s", getDomainId(), getName(), getType());
    }

}
