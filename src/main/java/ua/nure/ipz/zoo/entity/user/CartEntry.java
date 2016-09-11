package ua.nure.ipz.zoo.entity.user;

import ua.nure.ipz.zoo.entity.ticket.Ticket;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CartEntry extends DomainEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToOne
    private Ticket ticket;
    private int quantity;

    public CartEntry() {
    }

    public CartEntry(Ticket ticket, int quantity) {
        this.ticket = ticket;
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("Ticket = %s\nQuantity = ", ticket, quantity);
    }
}
