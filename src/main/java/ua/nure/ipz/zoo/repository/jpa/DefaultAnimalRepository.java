package ua.nure.ipz.zoo.repository.jpa;

import ua.nure.ipz.zoo.entity.Animal;
import ua.nure.ipz.zoo.repository.AnimalRepository;

import javax.persistence.EntityManager;

public class DefaultAnimalRepository extends BasicRepository<Animal> implements AnimalRepository {
    public DefaultAnimalRepository(EntityManager entityManager) {
        super(entityManager, Animal.class);
    }
}
