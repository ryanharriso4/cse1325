public class OrderTest{
	public static void main(String [] args)
	{
		Order o = new Order(new Customer("Ryan Harris", "ryanthomasharris@gmail.com"));
		Order o2 = new Order(new Customer("Ryan Harris", "ryanthomasharris@gmail.com"));
		Computer c = new Computer("Big Chungus", "Rabbit"); 
		c.addOption(new Option("CPU", 1752)); 
		c.addOption(new Option("GPU", 191991)); 
		Computer c2 = new Computer("Big Chungus", "Rabbit"); 
		c2.addOption(new Option("CPU", 1752)); 
		c2.addOption(new Option("GPU", 191991));
		o.addComputer(c); 
		o2.addComputer(c2); 
		System.out.println(o); 
		System.out.println(o.equals(o2));   

	}
}