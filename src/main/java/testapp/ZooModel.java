package testapp;

import ua.nure.ipz.zoo.model.*;

import java.util.ArrayList;
import java.util.List;

public class ZooModel {

    private List<Animal> animals = new ArrayList<>();
    private List<Aviary> aviaries = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private List<Cart> carts = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<Ration> rations = new ArrayList<>();
    private List<Provision> provisions = new ArrayList<>();
    private List<Schedule> schedules = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();
    private List<Documentation> logs = new ArrayList<>();

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

    public List<Order> getOrders() {
        return orders;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Ration> getRatitons() {
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

    public List<Documentation> getDocumentations() {
        return logs;
    }

}
