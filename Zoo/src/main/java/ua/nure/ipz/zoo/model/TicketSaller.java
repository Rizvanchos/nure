package ua.nure.ipz.zoo.model;

import java.util.ArrayList;
import java.util.List;

public class TicketSaller extends Account {

	private List<Order> orders = new ArrayList<>();

	public TicketSaller(String name, String email, String password) {
		super(name, email, password);
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void addOrder(Order order) {
		if (order == null) {
			throw new IllegalStateException("order");
		}
		orders.add(order);
	}

	public void sendMailTickets(Order order) {
		startSendMail(order);
		finishSendMail(order);
	}

	private void startSendMail(Order order) {
		order.process();
	}

	private void finishSendMail(Order order) {
		order.finish();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString() + "Orders:\n");
		orders.forEach(o -> sb.append(o + "\n"));
		return sb.toString();
	}
}
