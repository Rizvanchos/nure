package ua.nure.ipz.zoo.repository.jpa;

import ua.nure.ipz.zoo.entity.food.Ration;
import ua.nure.ipz.zoo.repository.RationRepository;

import javax.persistence.EntityManager;

public class DefaultRationRepository extends BasicRepository<Ration> implements RationRepository {
    public DefaultRationRepository(EntityManager entityManager) {
        super(entityManager, Ration.class);
    }
}
