public abstract class Product{
	protected double cost; 
	protected String name; 

	public Product(String name, double cost)
	{
		this.name = name; 
		this.cost = cost; 
	}

	public abstract double price()
	{

	}

	@Override
	public String toString()
	{

	}
}