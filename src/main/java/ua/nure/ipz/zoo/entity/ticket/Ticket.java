package ua.nure.ipz.zoo.entity.ticket;

import ua.nure.ipz.zoo.entity.enums.TicketType;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
public class Ticket extends DomainEntity {
    @Enumerated
    private TicketType type;

    public Ticket() {
    }

    public Ticket(TicketType type) {
        this.type = type;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public float getPrice() {
        return type.getPrice();
    }

    @Override
    public String toString() {
        return String.format("%s\nTicketType = %s\n", super.toString(), getType());
    }
}
