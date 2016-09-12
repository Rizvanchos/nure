package ua.nure.ipz.zoo.entity.user;

import ua.nure.ipz.zoo.entity.ticket.Ticket;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Cart extends DomainEntity {

    @ElementCollection
    private Map<Ticket, Integer> orderedTickets = new HashMap<>();

    public int ticketsCount() {
        return orderedTickets.values().stream().mapToInt(i -> i.intValue()).sum();
    }

    public float totalPrice() {
        return orderedTickets.entrySet().stream().map(f -> f.getKey().getPrice() * f.getValue()).reduce(0f, Float::sum);
    }

    public Cart checkout() {
        orderedTickets = Collections.unmodifiableMap(orderedTickets);
        return this;
    }

    public void clear() {
        orderedTickets = new HashMap<>();
    }

    public Map<Ticket, Integer> getOrderedTickets() {
        return orderedTickets;
    }

    public void setOrderedTickets(Map<Ticket, Integer> orderedTickets) {
        this.orderedTickets = orderedTickets;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString() + "\n");
        orderedTickets.entrySet().forEach(e -> sb.append("Ticket = " + e.getKey() + "amount: " + e.getValue() + "\n"));
        return sb.toString();
    }
}
