package ua.nure.ipz.zoo.util;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
public abstract class DomainEntity implements Serializable {
    @Id
    @GeneratedValue
    private long databaseId;

    @Type(type = "uuid-binary")
    @Column(length = 32, unique = true, nullable = false)
    private UUID domainId = UUID.randomUUID();

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) {
            return false;
        }
        DomainEntity otherDomainEntity = (DomainEntity) o;
        return domainId.equals(otherDomainEntity.getDomainId());
    }

    @Override
    public int hashCode() {
        return domainId.hashCode();
    }

    public UUID getDomainId() {
        return domainId;
    }

    public long getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(long databaseId) {
        this.databaseId = databaseId;
    }
}
