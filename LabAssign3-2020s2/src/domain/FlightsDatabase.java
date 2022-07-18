package domain;

import java.util.*;

/**
 * This class represents a database of all the Flights that have been entered into the system.
 * @author Shane Moore
 */
public class FlightsDatabase {
	private HashMap<String,Flight> allFlights;
	
	public FlightsDatabase()
	{
		allFlights = new HashMap<String,Flight>();
	}
	
	/**
	 * Adds a Flight to the database, using the flight's unique flight-code as the key.
	 * If there is already a flight with the same flight-code in the database, it fails (returning false).
	 * @param flightToAdd An instantiated Flight object which is the flight to be added to this FlightsDatabase.
	 * @return true if successfully added the flight to the database, false if something went wrong such as trying to add a flight a second time.
	 */
	public boolean addFlight(Flight flightToAdd)
	{
		String flightCode = "";
		
		if (flightToAdd != null)
			flightCode = flightToAdd.getFlightCode().toUpperCase();
	
		if (flightCode.length() > 0 && allFlights.get(flightCode) == null)	// No flight has the flight code of the one trying to be added.
		{
			allFlights.put(flightCode,flightToAdd);		// Stores the flight, using its flight code to do so.
			return true;
		}
		return false;		// Something was not acceptable, otherwise we would have already returned true.
	}
	
	/**
	 * Retrieves a Flight from the database, by looking for it using the unique flight-code of the Flight.
	 * @param flightCode  The flight-code of the desired Flight.
	 * @return
	 */
	public Flight getFlight(String flightCode)
	{
		if (flightCode != null) {
			return allFlights.get(flightCode.toUpperCase());
		}
		else 
			return null;
	}
	
	/** Tells whether or not the given flight-code is currently used by any Flight in the database.
	 * @param flightCode  The flight-code of the desired Flight to check for.
	 * @return true if the flight exists in the database, otherwise false is returned.
	 */
	public boolean flightIsInDatabase(String flightCode)
	{
		if (flightCode != null && (allFlights.get(flightCode.toUpperCase())!= null))
			return true;
		else 
			return false;
	}
}
