package ua.nure.ipz.zoo.repository.jpa;

import ua.nure.ipz.zoo.entity.user.Cart;
import ua.nure.ipz.zoo.repository.CartRepository;

import javax.persistence.EntityManager;

public class DefaultCartRepository extends BasicRepository<Cart> implements CartRepository {
    public DefaultCartRepository(EntityManager entityManager) {
        super(entityManager, Cart.class);
    }
}
