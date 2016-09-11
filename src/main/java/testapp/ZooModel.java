package testapp;

import ua.nure.ipz.zoo.entity.user.Account;
import ua.nure.ipz.zoo.entity.Animal;
import ua.nure.ipz.zoo.entity.Aviary;
import ua.nure.ipz.zoo.entity.user.Cart;
import ua.nure.ipz.zoo.entity.user.CartEntry;
import ua.nure.ipz.zoo.entity.order.Order;
import ua.nure.ipz.zoo.entity.Product;
import ua.nure.ipz.zoo.entity.Provision;
import ua.nure.ipz.zoo.entity.Ration;
import ua.nure.ipz.zoo.entity.Schedule;
import ua.nure.ipz.zoo.entity.ticket.Ticket;
import ua.nure.ipz.zoo.entity.log.order.OrderLog;
import ua.nure.ipz.zoo.entity.log.provision.ProvisionLog;

import java.util.ArrayList;
import java.util.List;

public class ZooModel {

    private List<Animal> animals = new ArrayList<>();
    private List<Aviary> aviaries = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private List<Cart> carts = new ArrayList<>();
    private List<CartEntry> cartEntries = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<Ration> rations = new ArrayList<>();
    private List<Provision> provisions = new ArrayList<>();
    private List<Schedule> schedules = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();
    private List<OrderLog> orderLogs = new ArrayList<>();
    private List<ProvisionLog> provisionLogs = new ArrayList<>();

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Aviary> getAviaries() {
        return aviaries;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public List<CartEntry> getCartEntries() {
        return cartEntries;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Ration> getRations() {
        return rations;
    }

    public List<Provision> getProvisions() {
        return provisions;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public List<OrderLog> getOrderLogs() {
        return orderLogs;
    }

    public List<ProvisionLog> getProvisionLogs() {
        return provisionLogs;
    }
}
