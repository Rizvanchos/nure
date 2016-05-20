package testapp;

import java.util.ArrayList;
import java.util.List;

import ua.nure.ipz.zoo.model.Account;
import ua.nure.ipz.zoo.model.Animal;
import ua.nure.ipz.zoo.model.Aviary;
import ua.nure.ipz.zoo.model.Cart;
import ua.nure.ipz.zoo.model.Documentation;
import ua.nure.ipz.zoo.model.Order;
import ua.nure.ipz.zoo.model.Product;
import ua.nure.ipz.zoo.model.Provision;
import ua.nure.ipz.zoo.model.Ration;
import ua.nure.ipz.zoo.model.Schedule;
import ua.nure.ipz.zoo.model.Ticket;

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
