package store;


import java.util.ArrayList; 

public class Computer{
	private String name; 
	private String model;
	private ArrayList <Option> options = new ArrayList<>(); 

	public Computer(String name, String model)
	{
		this.name = name; 
		this.model = model; 
	}

	public void addOption(Option option)
	{
		options.add(option); 
	}

	public long cost()
	{
		long sum = 0; 
		for(Option o: options)
			sum += o.cost(); 
		return sum;

	}
	@Override
	public boolean equals(Object o)
	{
		if(o == this) return true; 
		if(!(o instanceof Computer)) return false; 
		Computer c = (Computer)o; 
		return toString().equals(c.toString()); 
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder(); 
		sb.append(name + " (" + model + ")\n  ");
		for(Option o: options)
			sb.append(o.toString() + "\n  "); 
		return sb.toString(); 
	}
}