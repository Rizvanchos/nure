package ua.nure.ipz.zoo.model;

import ua.nure.ipz.zoo.util.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Keeps rations and generates product list to buy.
 */

public class Provision extends Entity {

    private List<Ration> provisionList = new ArrayList<>();
    private Documentation logger = new Documentation();

    public void setDocumentation(Documentation logger) {
        this.logger = logger;
    }

    public boolean add(Ration ration) {
        Objects.requireNonNull(ration, "Ration can't be null!");
        return provisionList.add(ration);
    }

    public String productsToBuy() {
        StringBuilder sb = new StringBuilder();
        provisionList.forEach(r -> sb.append(r + "\n"));
        logger.logProvision(this);
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        provisionList.forEach(r -> sb.append(r + "\n"));
        return sb.toString();
    }

}
