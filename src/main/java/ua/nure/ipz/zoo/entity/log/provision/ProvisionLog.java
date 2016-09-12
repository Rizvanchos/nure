package ua.nure.ipz.zoo.entity.log.provision;

import ua.nure.ipz.zoo.entity.food.Provision;
import ua.nure.ipz.zoo.entity.log.Log;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProvisionLog extends DomainEntity implements Log<Provision> {
}
