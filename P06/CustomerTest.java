public class CustomerTest{
	public static void main(String [] args)
	{
		try
		{
			Customer c1 = new Customer("Ryan Harris", "ryanthomasharris@gmail.com"); 
			System.out.println(c1); 
			Customer c2 = new Customer("Ryan Harris", "ryanthomasharris@gmail.com"); 
			System.out.println(c1.equals(c2)); 
		}
		catch(IllegalArgumentException e)
		{
			System.err.println(e); 
		}
		
	}
}