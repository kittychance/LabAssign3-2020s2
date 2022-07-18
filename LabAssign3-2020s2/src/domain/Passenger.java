package domain;

/**
 * Represents a passenger on a flight
 * @author Shane Moore
 */
public class Passenger {
	private String name;
	private String nationality;
	private String dietaryNeeds;
	private boolean hasYoungChild;
	
	public Passenger(String name, String nationality)
	{
		this.name = name;
		this.nationality=nationality;
	}
	
	/**
	 * Allows changing the status of whether this passenger has a young child/baby with them. 
	 * @param hasYoungChild Should be true if they do have a young child, otherwise false.
	 */
	public void setHasYoungChild(boolean hasYoungChild)
	{
		this.hasYoungChild = hasYoungChild;
	}
	
	public String getHasYoungChildtoString()  //add a method to get child result a string
	{
		if(getHasYoungChild())
			return "Yes";
		else
			return "No";
	}
	
	public boolean getHasYoungChild()
	{
		return hasYoungChild;
	}
	
	public void setDietaryNeeds(String needs)
	{
		this.dietaryNeeds = needs;
	}
	
	/**
	 * Obtain a string describing the dietary needs of the passenger (if any)
	 * @return the dietary needs of the passenger
	 */
	public String getDietaryNeeds()
	{
		if (dietaryNeeds == null)
			return "";		// Empty string if there is no actual string.

		// Otherwise, return whatever was set...
		return dietaryNeeds;
	}
	
	/**
	 * Obtain a String providing the passenger's name
	 * @return The passenger's name
	 */
	public String getName()
	{
		return name;
	}

	public String getNationality()
	{
		return nationality;
	}
	
	public String toString()
	{
		return name;
	}
}
