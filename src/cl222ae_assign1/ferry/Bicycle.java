package cl222ae_assign1.ferry;

/**Bicycle.java
 * @author Christoffer Lundström
 * @date: 23 Jan 2019
 */
public class Bicycle extends Vehicle {
	
	private final int MAX_PASSENGERS = 1;
	private final int PASSENGER_PRICE = 0;
	private final int VEHICLE_PRICE = 40;
	private final int OCCUPIED_SPACE = 1; //(0.2f*5);
	

	/**@param amountOfPassengers Amount of passengers can only be one.*/
	public Bicycle() {
		super.occupiedSpace = OCCUPIED_SPACE;
		super.pricePerVehicle = VEHICLE_PRICE;
		super.passengerPrice = PASSENGER_PRICE;
		super.maxPassengers = MAX_PASSENGERS;
		
		validatePassengers(1);
		super.populateVehicle(1);
	}
	
	@Override
	public String toString() {
		return "Bicycle, ticket-id: " + ticketId;
	}
}
