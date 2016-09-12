package ua.nure.ipz.zoo.entity.ticket;

import ua.nure.ipz.zoo.entity.order.Order;
import ua.nure.ipz.zoo.entity.user.Account;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TicketSaller extends Account {

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "account")
    private List<Order> orders = new ArrayList<>();

    public TicketSaller() {
    }

    public TicketSaller(String name, String email, String password) {
        super(name, email, password);
    }

    public void sendMailTickets(Order order) {
        order.process();
        order.finish();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString() + "Orders:\n");
        orders.forEach(o -> sb.append(o + "\n"));
        return sb.toString();
    }
}
