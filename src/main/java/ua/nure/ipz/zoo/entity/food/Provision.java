package ua.nure.ipz.zoo.entity.food;

import ua.nure.ipz.zoo.entity.log.provision.ProvisionLog;
import ua.nure.ipz.zoo.entity.log.provision.ProvisionLogger;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Provision extends DomainEntity {

    @ElementCollection
    private List<Ration> rations = new ArrayList<>();

    @OneToOne(cascade = CascadeType.PERSIST, targetEntity = ProvisionLogger.class)
    private ProvisionLog logger;

    public Provision() {
    }

    public String productsToBuy() {
        StringBuilder sb = new StringBuilder();
        rations.forEach(r -> sb.append(r + "\n"));
        logger.log(this);
        return sb.toString();
    }

    public List<Ration> getRations() {
        return rations;
    }

    public void setRations(List<Ration> rations) {
        this.rations = rations;
    }

    public ProvisionLog getLogger() {
        return logger;
    }

    public void setLogger(ProvisionLog logger) {
        this.logger = logger;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString() + "\n");
        rations.forEach(r -> sb.append(r + "\n"));
        return sb.toString();
    }
}
