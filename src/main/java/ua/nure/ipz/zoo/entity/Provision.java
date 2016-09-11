package ua.nure.ipz.zoo.entity;

import ua.nure.ipz.zoo.entity.log.provision.ProvisionLog;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Provision extends DomainEntity {

    @ElementCollection
    private List<Ration> provisions = new ArrayList<>();
    private ProvisionLog logger;

    public Provision() {
    }

    public String productsToBuy() {
        StringBuilder sb = new StringBuilder();
        provisions.forEach(r -> sb.append(r + "\n"));
        logger.log(this);
        return sb.toString();
    }

    public List<Ration> getProvisions() {
        return provisions;
    }

    public void setProvisions(List<Ration> provisions) {
        this.provisions = provisions;
    }

    public ProvisionLog getLogger() {
        return logger;
    }

    public void setLogger(ProvisionLog logger) {
        this.logger = logger;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        provisions.forEach(r -> sb.append(r + "\n"));
        return sb.toString();
    }
}
