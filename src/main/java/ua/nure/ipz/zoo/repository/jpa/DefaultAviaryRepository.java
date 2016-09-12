package ua.nure.ipz.zoo.repository.jpa;

import ua.nure.ipz.zoo.entity.Aviary;
import ua.nure.ipz.zoo.repository.AviaryRepository;

import javax.persistence.EntityManager;

public class DefaultAviaryRepository extends BasicRepository<Aviary> implements AviaryRepository {
    public DefaultAviaryRepository(EntityManager entityManager) {
        super(entityManager, Aviary.class);
    }
}
