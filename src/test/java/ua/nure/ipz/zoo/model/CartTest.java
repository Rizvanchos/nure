package ua.nure.ipz.zoo.model;

import org.junit.Before;
import org.junit.Test;
import ua.nure.ipz.zoo.model.enums.TicketType;

import static org.junit.Assert.assertEquals;

public class CartTest {

    private Cart cart = new Cart();

    @Before
    public void setUp() {
        cart.clear();
    }

    @Test
    public void totalPrice() {
        cart.add(new Ticket(TicketType.CHILD), 2);
        cart.add(new Ticket(TicketType.STANDARD), 1);

        assertEquals(50, cart.totalPrice(), 2);
    }

}