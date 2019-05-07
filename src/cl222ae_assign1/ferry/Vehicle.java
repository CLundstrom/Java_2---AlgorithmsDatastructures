package cl222ae_assign1.ferry;

import java.util.ArrayList;
import java.util.List;

/**Vehicle.java
 * @author Christoffer Lundström
 * @date: 23 Jan 2019
 */
public abstract class Vehicle {
	protected float occupiedSpace;
	protected int pricePerVehicle;
	protected int passengerPrice;
	protected int amountOfPassengers;
	protected int maxPassengers;
	protected int ticketId;
	protected boolean embarked = false; //Default 
	
	protected List<Passenger> passengers = new ArrayList<Passenger>();
	
	
	protected void populateVehicle(int pass) {
		
		for(int i=0; i < pass; i++ ) {
			passengers.add(new Passenger(passengerPrice));
		}
	}
	
	/**Makes sure passengers are within limits of the vehicle.*/
	protected void validatePassengers(int passengers) {
		if(passengers < 0 || passengers > maxPassengers) throw new IllegalArgumentException("Passengers must be between 0 and " + maxPassengers );
		
	}
}
