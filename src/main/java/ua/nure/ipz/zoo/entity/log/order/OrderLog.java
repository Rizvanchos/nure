package ua.nure.ipz.zoo.entity.log.order;

import ua.nure.ipz.zoo.entity.order.Order;
import ua.nure.ipz.zoo.entity.log.Log;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class OrderLog extends DomainEntity implements Log<Order> {
}
