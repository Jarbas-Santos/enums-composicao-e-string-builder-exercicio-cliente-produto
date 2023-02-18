package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private Date moment = new Date();
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<OrderItem>();
	
	private static SimpleDateFormat sdf0 = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Order() {
	}

	public Order(OrderStatus status, Client client) {
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	/* public void setItems(List<OrderItem> items) {
		this.items = items;
	} */
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		Double total = 0.0;
		for (OrderItem o : items) {
			total += o.getQuantity() * o.getPrice();
		}
		return total;
	}	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:" + "\n");
		sb.append("Order moment: " + sdf1.format(moment) + "\n");
		sb.append("Order status: " + status.toString() + "\n");
		sb.append("Client: " + client.getName() + " (" + sdf0.format(client.getBirthDate()) + ") - " + client.getEmail() + "\n");
		sb.append("Order items:\n");
		for (OrderItem oi : items) {
			sb.append(oi);
		}
		sb.append(String.format("Total price: $%.2f", total()));
		return sb.toString();		
	}
}
