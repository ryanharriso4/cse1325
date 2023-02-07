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
		System.out.printf("%s($%.2f)$%.2f", name, cost, price()); 
	}
}