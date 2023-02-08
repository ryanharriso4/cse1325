import java.util.Scanner; 
import java.util.ArrayList; 

public class Store{

	private static ArrayList <Product> products = new ArrayList<>(); 
	private static ArrayList <Product> shoppingCart = new ArrayList<>(); 
	public static void main(String [] args)
	{
		Taxed.setTaxRate(0.0725); 
		products.add(new Taxed("Poptarts",4.68)); 
		products.add(new Taxed("Ice Cream", 9.00));
		products.add(new Taxed("Hershey's Choclate Bar", 2.49)); 
		products.add(new Taxfree("Milk", 3.59)); 
		products.add(new Taxfree("Bread", 3.79)); 
		products.add(new Taxfree("Eggs", 8.79)); 


		int itemNumber = 0; 
		double basketSum = 0; 
		Scanner in = new Scanner(System.in); 
		try
		{
			while(itemNumber >= 0)
			{
				System.out.println("\n\n========================");
				System.out.println("  Welcome to the Store "); 
				System.out.println("========================\n\n");

				for(int i = 0; i < products.size(); i++)
				{
					System.out.println(i + ") " + products.get(i)); 
				}

				System.out.println("\n\n-------------");
				System.out.println("Current Order"); 
				System.out.println("-------------\n\n");

				for(int i = 0; i < shoppingCart.size(); i++) 
				{
					basketSum += shoppingCart.get(i).price(); 
					System.out.print(shoppingCart.get(i)); 
				}
				if(shoppingCart.size() == 0)
					System.out.println("You have nothing in your shopping cart"); 
				

				System.out.printf("Total price: $%.2f\n\n", basketSum); 
				System.out.print("Which item do you want to buy?"); 

				itemNumber = in.nextInt(); 
				if(itemNumber >= 0)
				{
					shoppingCart.add(products.get(itemNumber)); 
				}
				basketSum = 0; 
			}
		}catch(Exception e){ 
			System.err.println("There was an error: " + e); 
		}

	}
}