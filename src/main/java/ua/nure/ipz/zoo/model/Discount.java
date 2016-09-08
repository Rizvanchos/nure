package ua.nure.ipz.zoo.model;

import ua.nure.ipz.zoo.model.enums.TicketType;

public class Discount {

    private TicketType type;
    private int barrier;
    private float coefficient;

    public Discount() {
        this.type = TicketType.STANDARD;
        this.barrier = 10;
        this.coefficient = 0.7f;
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

    public float getDiscountedPrice(Cart cart) {
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

    @Override
    public String toString() {
        return String.format("TicketType = %s\nBarrier = %s\nCoefficient = %s", getType(), getBarrier(),
                getCoefficient());
    }
}
