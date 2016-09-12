package ua.nure.ipz.zoo.entity.ticket;

import ua.nure.ipz.zoo.entity.user.Cart;

public abstract class Discount {
    public abstract float discountPrice(Cart cart);
}
