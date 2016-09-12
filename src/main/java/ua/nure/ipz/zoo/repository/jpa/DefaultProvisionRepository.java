package ua.nure.ipz.zoo.repository.jpa;

import ua.nure.ipz.zoo.entity.food.Provision;
import ua.nure.ipz.zoo.repository.ProvisionRepository;

import javax.persistence.EntityManager;

public class DefaultProvisionRepository extends BasicRepository<Provision> implements ProvisionRepository {
    public DefaultProvisionRepository(EntityManager entityManager) {
        super(entityManager, Provision.class);
    }
}
