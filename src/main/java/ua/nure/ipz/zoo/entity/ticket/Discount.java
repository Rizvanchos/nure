package ua.nure.ipz.zoo.entity.ticket;

import ua.nure.ipz.zoo.entity.user.Cart;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Embeddable
public abstract class Discount {
    public abstract float discountPrice(Cart cart);
}
