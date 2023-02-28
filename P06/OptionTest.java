public class OptionTest
{
	public static void main(String [] args)
	{
		Option p1 = new Option("CPU", 1575); 
		Option p2 = new Option("CPU", 1675); 
		System.out.println(p1); 
		System.out.println(p1.equals(p2)); 

	}
}