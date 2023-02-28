public class ComputerTest{
	public static void main(String [] args)
	{
		Computer c1 = new Computer("BobBob", "XYZA"); 
		c1.addOption(new Option("CPU", 175)); 
		c1.addOption(new Option("GPU", 185));

		Computer c2 = new Computer("BobBob", "XYZA"); 
		c2.addOption(new Option("CPU", 175)); 
		c2.addOption(new Option("GPU", 196));  


		System.out.println(c1); 
		System.out.println("\n\n" + c1.cost()); 
		System.out.println("\n\n" + c1.equals(c2)); 
	}
}