package ua.nure.ipz.zoo.repository.jpa;

import ua.nure.ipz.zoo.entity.log.provision.ProvisionLog;
import ua.nure.ipz.zoo.repository.ProvisionLogRepository;

import javax.persistence.EntityManager;

public class DefaultProvisionLogRepository extends BasicRepository<ProvisionLog> implements ProvisionLogRepository {
    public DefaultProvisionLogRepository(EntityManager entityManager) {
        super(entityManager, ProvisionLog.class);
    }
}
