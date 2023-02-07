public class taxed{
	private static double tax = 0.0; 
	public Taxed(String name, double cost)
	{
		super(name, cost); 
	}

	public static double setTaxRate(double salesTax)
	{
		tax = salesTax; 
	}

	@Override
	public double price()
	{
		return cost * (1+tax); 
	}
}