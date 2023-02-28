public class Customer{
	private String name; 
	private String email; 

	public Customer(String name, String email)
	{
		this.name = name; 
		if(!(email.contains("@")) || !(email.contains(".")) || (email.lastIndexOf(".") < email.indexOf("@")))
		{
			throw new IllegalArgumentException("The email for user " +  name  +  " is invalid.\n"); 
		}
		this.email = email; 
	}

	@Override
	public boolean equals(Object o)
	{
		if(o == this) return true; 
		if(!(o instanceof Customer)) return false;
		Customer c = (Customer)o; 
		return (name.equals(c.name)) && (email.equals(c.email)); 
	}


	@Override
	public String toString()
	{
		return name + " (" + email + ")"; 
	}
}