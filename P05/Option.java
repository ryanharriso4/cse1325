public class Option{
	protected String name; 
	protected long cost;

	public Option(String name, long cost)
	{
		this.name = name; 
		if(cost < 0)
		{
			throw new IllegalArgumentException("The component " + name " has an invalid cost\n"); 
		}
		this.cost = cost; 
	}

	public long cost()
	{

	}

	public boolean equals(Object o)
	{
		if(o == this) return true; 
		if(!(o instanceof Option)) return false;
		Option c = (Option)o; 
		return (name.equals(c.name)) && (cost.equals(c.cost));
	}

	@Override
	public String toString()
	{
		return String.format("%s($%.2f)", name, ((double)cost/100)); 
	}
} 
