public class TaxFree{
	public TaxFree(String name, double cost)
	{
		super(name, cost); 
	}

	@Override
	public double price()
	{
		return cost; 
	}
}