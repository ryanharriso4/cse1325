package store;

import java.util.ArrayList;

public class Order {
	private static long nextOrderNumber = 0;
	private long orderNumber;
	private Customer customer;
	private ArrayList<Computer> computers;

	public Order(Customer customer) {
		computers = new <Computer>ArrayList();
		this.customer = customer;
		orderNumber = nextOrderNumber;
		nextOrderNumber++;
	}

	public void addComputer(Computer computer) {
		computers.add(computer);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Order))
			return false;
		Order c = (Order) o;
		if (!(customer.equals(c.customer)))
			return false;
		if (!(computers.equals(c.computers)))
			return false;
		return true;
	}

	public long cost() {
		long sum = 0;
		for (Computer c : computers) {
			sum += c.cost();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order " + orderNumber + " for " + customer.toString() + "\n\n");
		for (Computer c : computers) {
			sb.append(c.toString());
		}
		sb.append("\n The cost of the PC is: " + ((double) cost() / 100));
		return sb.toString();
	}
}