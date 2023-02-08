public abstract class Product{
	protected double cost; 
	protected String name; 

	public Product(String name, double cost)
	{
		this.name = name;
		if(cost < 0)
			throw new RuntimeException(); 
		this.cost = cost; 
	}

	public abstract double price();
	

	@Override
	public String toString()
	{
		int spaces = 30 - name.length(); 
		//return String.format("%s($%.2f)%s$  %.2f\n", name, cost, " ", price()); 
		StringBuilder sb = new StringBuilder(); 
		sb.append(name); 
		sb.append(String.format("($%.2f)",cost)); 
		for(int i = 0; i < spaces; i++)
		{
			sb.append(" "); 
		}
		sb.append(String.format("$  %.2f", price())); 
		return sb.toString(); 
	}
}