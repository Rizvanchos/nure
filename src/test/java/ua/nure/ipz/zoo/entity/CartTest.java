package ua.nure.ipz.zoo.entity;

import org.junit.Before;
import org.junit.Test;
import ua.nure.ipz.zoo.entity.enums.TicketType;
import ua.nure.ipz.zoo.entity.user.Cart;
import ua.nure.ipz.zoo.entity.ticket.Ticket;

import static org.junit.Assert.assertEquals;

public class CartTest {

    private Cart cart = new Cart();

    @Before
    public void setUp() {
        cart.clear();
    }

    @Test
    public void totalPrice() {
        cart.getOrderedTickets().put(new Ticket(TicketType.CHILD), 2);
        cart.getOrderedTickets().put(new Ticket(TicketType.STANDARD), 1);

        assertEquals(50, cart.totalPrice(), 2);
    }

}