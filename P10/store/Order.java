package store;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class Order {
	private static long nextOrderNumber = 1;
	private long orderNumber;
	private Customer customer;
	private ArrayList<Computer> computers = new ArrayList<>();

	public Order(Customer customer) {
		this.customer = customer;
		orderNumber = nextOrderNumber;
		nextOrderNumber++;
	}

	public Order(BufferedReader br) throws IOException {
		nextOrderNumber = Long.parseLong(br.readLine());
		orderNumber = Long.parseLong(br.readLine());
		customer = new Customer(br);
		int upperBound = Integer.parseInt(br.readLine());
		for (int i = 0; i < upperBound; i++) {
			computers.add(new Computer(br));
		}

	}

	public void addComputer(Computer computer) {
		computers.add(computer);
	}

	public void save(BufferedWriter bw) throws IOException {
		bw.write("" + nextOrderNumber + '\n');
		bw.write("" + orderNumber + '\n');
		customer.save(bw);
		bw.write("" + computers.size() + '\n');
		for (Computer computer : computers)
			computer.save(bw);
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