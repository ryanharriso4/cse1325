public enum Type{Capybara(4), Tanuki(11), Raccoon(2.5), Bear(35);

	private double lifespan;

	private Type(double lifespan)
	{
		this.lifespan = lifespan; 
	}

	public double lifespan(){
		return lifespan; 
	}
}