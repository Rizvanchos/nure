package ua.nure.ipz.zoo.model;

import ua.nure.ipz.zoo.model.enums.TicketType;
import ua.nure.ipz.zoo.util.Entity;

public class Ticket extends Entity {

    private TicketType type;

    public Ticket(TicketType type) {
        this.type = type;
    }

    public TicketType getType() {
        return type;
    }

    public float getPrice() {
        return type.getPrice();
    }

    @Override
    public String toString() {
        return String.format("TicketType = %s\n", getType());
    }
}
