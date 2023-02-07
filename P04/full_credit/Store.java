public class Store{

	private static ArrayList <Product> products = new ArrayList<>(); 
	private static ArrayList <Product> shoppingCart = new ArraysList<>(); 
	public static void main(String [] args)
	{
		products.add(Taxed("Poptarts",4.68)); 
		products.add(Taxed("Ice Cream", 9.00));
		products.add(Taxfree("Milk", 3.59)); 
		products.add(Taxfree("Bread", 3.79)); 
		products.add(Taxfree("Eggs", 8.79)); 
	}
}