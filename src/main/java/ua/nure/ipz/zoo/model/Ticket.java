package ua.nure.ipz.zoo.model;

import ua.nure.ipz.zoo.model.enums.TicketType;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket extends DomainEntity {

    private TicketType type;

    public Ticket() {
    }

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
