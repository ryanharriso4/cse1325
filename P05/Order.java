import java.util.ArrayList; 

public class Order{
	private static long nextOrderNumber = 0; 
	private long orderNumber; 
	private Customer customer; 
	private ArrayList <Computer> computers = new ArrayList(); 

	public Order(Customer customer)
	{
		this.customer = customer; 
		orderNumber = nextOrderNumber; 
		nextOrderNumber++; 
	}

	public void addComputer(Computer computer)
	{
		computers.add(computer); 
	}

	@Override
	public boolean equals(Object o)
	{
		if(o == this) return true; 
		if(!(o instanceof Order)) return false;
		Order c = (Order)o; 
		if(!(customer.equals(c.customer))) return false; 
		if(!(computers.equals(c.computers))) return false; 
		return true; 
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder(); 
		sb.append("Order " + orderNumber + " for " + customer.toString() + "\n\n");
		for(Computer c : computers)
		{
			sb.append(c.toString()); 
		}
		return sb.toString(); 
	}
}