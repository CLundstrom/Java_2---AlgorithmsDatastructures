package cl222ae_assign1.ferry;

/**Bus.java
 * @author Christoffer Lundström
 * @date: 23 Jan 2019
 */
public class Bus extends Vehicle{

	private final int MAX_PASSENGERS = 20;
	private final int PASSENGER_PRICE = 15;
	private final int VEHICLE_PRICE = 200;
	private final int OCCUPIED_SPACE = 20;
	

	/**@param amountOfPassengers Amount of passengers in the Bus.*/
	public Bus(int amountOfPassengers) {
		super.occupiedSpace = OCCUPIED_SPACE;
		super.pricePerVehicle = VEHICLE_PRICE;
		super.passengerPrice = PASSENGER_PRICE;
		super.maxPassengers = MAX_PASSENGERS;
		
		super.validatePassengers(amountOfPassengers);
		super.populateVehicle(amountOfPassengers);
	}
	
	
	@Override
	public String toString() {
		return "Bus, ticket-id: " + ticketId;
	}
}