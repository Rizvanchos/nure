package ua.nure.ipz.zoo.entity.user;

import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Cart extends DomainEntity {

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "cart")
    private List<CartEntry> cartEntries = new ArrayList<>();

    public Cart() {
    }

    public int ticketsCount() {
        return cartEntries.stream().mapToInt(cartEntry -> cartEntry.getQuantity()).sum();
    }

    public float totalPrice() {
        return cartEntries.stream().map(cartEntry -> cartEntry.getTicket().getPrice() * cartEntry.getQuantity()).reduce(0f, Float::sum);
    }

    public Cart checkout() {
        cartEntries = Collections.unmodifiableList(cartEntries);
        return this;
    }

    public void clear() {
        cartEntries = new ArrayList<>();
    }

    public List<CartEntry> getCartEntries() {
        return cartEntries;
    }

    public void setCartEntries(List<CartEntry> cartEntries) {
        this.cartEntries = cartEntries;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        cartEntries.forEach(cartEntry -> sb.append("Ticket = " + cartEntry.getTicket() + "amount: " + cartEntry.getQuantity() + "\n"));
        return sb.toString();
    }
}
