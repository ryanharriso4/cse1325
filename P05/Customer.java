public class Customer{
	private String name; 
	private String email; 

	public Customer(String name, String email)
	{
		this.name = name; 
		if(!(email.contains("@")) && !(email.contains(".")) && (email.indexOf(".") < email.indexOf("@")))
		{
			throw new IllegalArgumentException("The email for user " + name " is invalid.\n"); 
		}
		this.email = email; 
	}


	@Override
	public String toString()
	{

	}
}