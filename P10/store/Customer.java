package store;
import java.io.BufferedWriter; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;


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

	public Customer(BufferedReader br) throws IOException
	{
		email = br.readLine();  
		name = br.readLine();
	}

	public void save(BufferedWriter bw)throws IOException
	{
		bw.write(name + '\n');
		bw.write(email + '\n'); 
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