package domain;

/**
 * A class to represent details of a particular flight. Each flight is between two places, the origin, and the destination.
 * Each flight has a unique flight-code, such as QF368, or CX982 (these examples being a Qantas flight and a Cathy Pacific flight).
 * @author Shane Moore
 */
public class Flight {
	private String origin;
	private String destination;
	private String flightCode;
	
	private Passenger[] seats;
	private int totalBooked = 0;

	/**
	 * Creates a new Flight between two places, with a specific flight-code and number of passengers.
	 * @param origin		Where the flight will depart from
	 * @param destination	Where the flight will travel to (arrive at)
	 * @param flightCode	The code, such as QF534, uniquely identifying the flight in the system
	 * @param numPassengers How many passengers are allowed on the flight.
	 */
	public Flight(String origin, String destination, String flightCode,int numPassengers)
	{
		this.origin = origin;
		this.destination = destination;
		this.flightCode = flightCode;
		seats = new Passenger[numPassengers];
	}
	
	/**
	 * Tells where the flight begins from.
	 * @return The origin place for the flight.
	 */
	public String getOrigin()
	{
		return origin;
	}
	
	/**
	 * Tells where the flight will end.
	 * @return The destination place for the flight.
	 */
	public String getDestination()
	{
		return destination;
	}
	
	/**
	 * Reports the flight's unique flight code.
	 * @return The flight code of this flight.
	 */
	public String getFlightCode()
	{
		return flightCode;
	}
	
	/**
	 * Reports how many seats the flight has in total.
	 * @return The number of seats on the flight.
	 */
	public int getTotalSeats()
	{
		return seats.length;
	}

	/**
	 * Assigns a Passenger to a particular seat of the flight.
	 * @param seatNumber  this specifies which seat number they will sit in.
	 * @param person  This should be a Passenger representing the person who is being added to the flight
	 * @return  True if the input parameters are acceptable and used to assign the given passenger to a seat; false if the seat is already occupied.
	 */
	public boolean setPassengerForSeat(int seatNumber, Passenger person)
	{
		if (seats[seatNumber] == null)
		{
			seats[seatNumber] = person;
			if (person != null) totalBooked++;
			else totalBooked--;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Retrieve the Passenger assigned to a particular seat of the flight, or null if seat is unoccupied. 
	 * @param seatNumber
	 * @return
	 */
	public Passenger getPassengerForSeat(int seatNumber)
	{
		return seats[seatNumber];
	}

	/**
	 * Reports how many of the seats are currently booked on the flight.
	 * @return How many seats are occupied by bookings.
	 */
	public int getTotalBooked()
	{
		return totalBooked;
	}
	
	public String toString()
	{
		return "Flight " + flightCode + " from " + origin + " to " + destination;
	}
	
	

	
}
