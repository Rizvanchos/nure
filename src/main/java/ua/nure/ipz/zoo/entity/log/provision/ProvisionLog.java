package ua.nure.ipz.zoo.entity.log.provision;

import ua.nure.ipz.zoo.entity.Provision;
import ua.nure.ipz.zoo.entity.log.Log;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ProvisionLog extends DomainEntity implements Log<Provision> {
}
