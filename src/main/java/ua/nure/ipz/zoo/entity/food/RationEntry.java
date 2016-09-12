package ua.nure.ipz.zoo.entity.food;

import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class RationEntry extends DomainEntity {

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ration_id")
    private Ration ration;

    @OneToOne
    private Product product;
    private float amount;

    public RationEntry() {
    }

    public RationEntry(Product product, float amount) {
        this.product = product;
        this.amount = amount;
    }

    public Ration getRation() {
        return ration;
    }

    public void setRation(Ration ration) {
        this.ration = ration;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%s\nProduct = %s\nWeight = ", super.toString() + "\n", product, amount);
    }
}
