public class MyPets{
	public static void main(String [] args)
	{ 

		Pet capybara = new  Pet("Coconut", 2.2, Type.Raccoon);
		Pet tanuki = new Pet("Chopper", 5.4, Type.Tanuki); 
		Pet raccoon = new Pet("Rocket", 2, Type.Raccoon); 
		Pet bear = new Pet("Baloo", 17.8, Type.Bear);  

		Pet [] pets = {capybara, tanuki, raccoon, bear};
		for(Pet pet: pets)
		{
			System.out.println(pet); 
		} 
	}
}