package ua.nure.ipz.zoo.util;

import java.util.UUID;

public abstract class Entity {

    private final UUID domainId = UUID.randomUUID();

    public UUID getDomainId() {
        return this.domainId;
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) {
            return false;
        }
        Entity otherDomainEntity = (Entity) o;
        return domainId.equals(otherDomainEntity.getDomainId());
    }

    @Override
    public int hashCode() {
        return domainId.hashCode();
    }
}
