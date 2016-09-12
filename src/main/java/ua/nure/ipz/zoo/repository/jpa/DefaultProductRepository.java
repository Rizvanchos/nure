package ua.nure.ipz.zoo.repository.jpa;

import ua.nure.ipz.zoo.entity.food.Product;
import ua.nure.ipz.zoo.repository.ProductRepository;

import javax.persistence.EntityManager;

public class DefaultProductRepository extends BasicRepository<Product> implements ProductRepository {
    public DefaultProductRepository(EntityManager entityManager) {
        super(entityManager, Product.class);
    }
}
