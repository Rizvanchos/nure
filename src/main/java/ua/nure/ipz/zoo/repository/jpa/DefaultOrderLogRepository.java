package ua.nure.ipz.zoo.repository.jpa;

import ua.nure.ipz.zoo.entity.log.order.OrderLog;
import ua.nure.ipz.zoo.repository.OrderLogRepository;

import javax.persistence.EntityManager;

public class DefaultOrderLogRepository extends BasicRepository<OrderLog> implements OrderLogRepository {
    public DefaultOrderLogRepository(EntityManager entityManager) {
        super(entityManager, OrderLog.class);
    }
}
