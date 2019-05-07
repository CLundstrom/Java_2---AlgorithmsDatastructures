package cl222ae_assign1.ferry;

/**Lorry.java
 * @author Christoffer Lundström
 * @date: 23 Jan 2019
 */
public class Lorry extends Vehicle{
	
	private final int MAX_PASSENGERS = 2;
	private final int PASSENGER_PRICE = 20;
	private final int VEHICLE_PRICE = 300;
	private final int OCCUPIED_SPACE = 40;
	

	/**@param amountOfPassengers Amount of passengers in the Lorry.*/
	public Lorry(int amountOfPassengers) {
		super.occupiedSpace = OCCUPIED_SPACE;
		super.pricePerVehicle = VEHICLE_PRICE;
		super.passengerPrice = PASSENGER_PRICE;
		super.maxPassengers = MAX_PASSENGERS;
		
		super.validatePassengers(amountOfPassengers);
		super.populateVehicle(amountOfPassengers);
	}
	
	@Override
	public String toString() {
		return "Lorry, ticket-id: " + ticketId;
	}
}