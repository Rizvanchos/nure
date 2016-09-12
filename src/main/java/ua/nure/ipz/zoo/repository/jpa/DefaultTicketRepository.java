package ua.nure.ipz.zoo.repository.jpa;

import ua.nure.ipz.zoo.entity.ticket.Ticket;
import ua.nure.ipz.zoo.repository.TicketRepository;

import javax.persistence.EntityManager;

public class DefaultTicketRepository extends BasicRepository<Ticket> implements TicketRepository {
    public DefaultTicketRepository(EntityManager entityManager) {
        super(entityManager, Ticket.class);
    }
}
