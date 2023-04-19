package store;

import java.util.HashSet;
import java.util.TreeSet;

public class Store {
    public Store(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    // ///////////////////////////////////////////////////////////
    // Customers

    public void add(Customer customer) {
        if (!customers.contains(customer))
            customers.add(customer);
    }

    public Object[] customers() {
        return this.customers.toArray();
    }

    // ///////////////////////////////////////////////////////////
    // Options

    public void add(Option option) {
        if (!options.contains(option))
            options.add(option);
    }

    public Object[] options() {
        return this.options.toArray();
    }

    // ///////////////////////////////////////////////////////////
    // Computers

    public void add(Computer computer) {
        if (!computers.contains(computer))
            computers.add(computer);
    }

    public Object[] computers() {
        return this.computers.toArray();
    }

    // ///////////////////////////////////////////////////////////
    // Orders

    public void add(Order order) {
        if (!orders.contains(order))
            orders.add(order);
    }

    public Object[] orders() {
        return this.orders.toArray();
    }

    // ///////////////////////////////////////////////////////////
    // Fields

    private String name;
    private TreeSet<Customer> customers = new TreeSet<>();
    private HashSet<Option> options = new HashSet<>();
    private HashSet<Computer> computers = new HashSet<>();
    private HashSet<Order> orders = new HashSet<>();
}
