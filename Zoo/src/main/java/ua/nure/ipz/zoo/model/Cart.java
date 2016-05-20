package ua.nure.ipz.zoo.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart {

	private Map<Ticket, Integer> orderedTickets = new HashMap<>();

	public Map<Ticket, Integer> getOrderedTickets() {
		return orderedTickets;
	}

	public int ticketsCount() {
		return orderedTickets.values().stream().map(i -> i.intValue()).reduce(0, Integer::sum);
	}

	public boolean add(Ticket ticket, int amount) {
		if (ticket == null) {
			throw new IllegalArgumentException("ticket");
		}
		return null != orderedTickets.put(ticket, amount);
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		orderedTickets.entrySet().forEach(e -> sb.append("Ticket = " + e.getKey() + "amount: " + e.getValue() + "\n"));
		return sb.toString();
	}

}
