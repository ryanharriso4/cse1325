package store;
import java.io.BufferedWriter; 
import java.io.FileWriter;
import java.io.IOException; 
import java.io.BufferedReader;



public class Option{
	protected String name; 
	protected long cost;

	public Option(String name, long cost)
	{
		this.name = name; 
		if(cost < 0)
		{
			throw new IllegalArgumentException("The component " + name + " has an invalid cost\n"); 
		}
		this.cost = cost; 
	}

	public Option(BufferedReader br) throws IOException
	{
		name = br.readLine(); 
		cost = Long.parseLong(br.readLine()); 
	}

	public long cost()
	{
		return cost; 
	}

	public void save(BufferedWriter bw) throws IOException
	{
		bw.write(name + '\n');
		bw.write("" + cost + '\n');
	}

	@Override
	public boolean equals(Object o)
	{
		if(o == this) return true; 
		if(!(o instanceof Option)) return false;
		Option c = (Option)o; 
		return (name.equals(c.name)) && (cost == c.cost);
	}

	@Override
	public String toString()
	{
		return String.format("%s($%.2f)", name, ((double)cost/100)); 
	}
} 
