public abstract class Product{
	protected double cost; 
	protected String name; 

	public Product(String name, double cost)
	{
		this.name = name;
		if(cost < 0)
			throw new RunTimeException(); 
		this.cost = cost; 
	}

	public abstract double price()
	{

	}

	@Override
	public String toString()
	{
		return String.format("%s($%.2f)\t\t\t\t$  %.2f\n", name, cost, price()); 
	}
}