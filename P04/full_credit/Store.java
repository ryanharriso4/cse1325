import java.util.Scanner; 
import static Qlogger.Qlogger.log; 

public class Store{

	private static ArrayList <Product> products = new ArrayList<>(); 
	private static ArrayList <Product> shoppingCart = new ArraysList<>(); 
	public static void main(String [] args)
	{
		Taxed.setTaxRate(0.0725); 
		products.add(Taxed("Poptarts",4.68)); 
		products.add(Taxed("Ice Cream", 9.00));
		products.add(Taxed("Hershey's Choclate Bar", 2.49)); 
		products.add(Taxfree("Milk", 3.59)); 
		products.add(Taxfree("Bread", 3.79)); 
		products.add(Taxfree("Eggs", 8.79)); 


		int itemNumber = 0; 
		double basketSum = 0; 
		Scanner in = new Scanner(System.in); 
		try
		{
			while(itemNumber >= 0)
			{
				System.out.println("========================");
				System.out.println("  Welcome to the Store "); 
				System.out.println("========================");

				for(int i = 0; i < products.size(); i++)
				{
					System.out.println(i + ") " + products.get(i)); 
				}

				System.out.println("Current Order"); 
				System.out.println("-------------\n\n");

				for(int i = 0; i < shoppingCart.size(); i++) 
				{
					basketSum += shoppingCart.get(i).price(); 
					System.out.print(shoppingCart.get(i)); 
				}

				System.out.printf("Total price: $%.2f", basketSum); 
				System.out.println("Which item do you want to buy?"); 

				itemNumber = in.nextInt(); 
				if(itemNumber >= 0)
				{
					shoppingCart.add(producst.get(itemNumber)); 
				}
			}
		}catch(Exception e){
			Qlogger.Qlogger.enable(); 
			log("There was an error!"); 
			System.err.println(e); 
		}

	}
}