package ua.nure.ipz.zoo.entity.log.order;

import ua.nure.ipz.zoo.entity.log.Log;
import ua.nure.ipz.zoo.entity.order.Order;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class OrderLog extends DomainEntity implements Log<Order> {
}
