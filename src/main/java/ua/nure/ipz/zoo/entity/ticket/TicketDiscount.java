package ua.nure.ipz.zoo.entity.ticket;

import ua.nure.ipz.zoo.entity.enums.TicketType;
import ua.nure.ipz.zoo.entity.user.Cart;

import javax.persistence.Embeddable;

@Embeddable
public class TicketDiscount extends Discount {

    private TicketType type;
    private int barrier;
    private float coefficient;

    public TicketDiscount() {
        this.type = TicketType.STANDARD;
        this.barrier = 10;
        this.coefficient = 0.7f;
    }

    public TicketDiscount(TicketType type, int barrier, float coefficient) {
        this.type = type;
        this.barrier = barrier;
        this.coefficient = coefficient;
    }

    public float discountPrice(Cart cart) {
        int amount = cart.getOrderedTickets().entrySet()
                .stream()
                .filter(e -> e.getKey().getType() == type)
                .mapToInt(e -> e.getValue())
                .sum();
        float discounted = cart.totalPrice();
        if (amount >= barrier) {
            discounted = discounted * coefficient;
        }
        return discounted;
    }

    public TicketType getType() {
        return type;
    }

    public int getBarrier() {
        return barrier;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public void setBarrier(int barrier) {
        this.barrier = barrier;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return String.format("TicketType = %s\nBarrier = %s\nCoefficient = %s", type, barrier, coefficient);
    }
}
