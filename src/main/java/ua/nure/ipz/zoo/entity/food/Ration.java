package ua.nure.ipz.zoo.entity.food;

import ua.nure.ipz.zoo.entity.Animal;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ration extends DomainEntity {

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "ration")
    private List<RationEntry> rationEntries = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "provision_id")
    private Provision provision;

    @OneToOne
    private Animal animal;

    public Ration() {
    }

    public Ration(Animal animal) {
        this.animal = animal;
    }

    public List<RationEntry> getRationEntries() {
        return rationEntries;
    }

    public void setRationEntries(List<RationEntry> rationEntries) {
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
        StringBuilder sb = new StringBuilder(animal + "\n");
        rationEntries.forEach(rationEntry -> sb.append("Product = " + rationEntry.getProduct() + ", amount: " + rationEntry.getAmount() + "\n"));
        return sb.toString();
    }

    public Provision getProvision() {
        return provision;
    }

    public void setProvision(Provision provision) {
        this.provision = provision;
    }
}
