package ua.nure.ipz.zoo.repository.jpa;

import ua.nure.ipz.zoo.entity.order.Order;
import ua.nure.ipz.zoo.repository.OrderRepository;

import javax.persistence.EntityManager;

public class DefaultOrderRepository extends BasicRepository<Order> implements OrderRepository {
    public DefaultOrderRepository(EntityManager entityManager) {
        super(entityManager, Order.class);
    }
}
