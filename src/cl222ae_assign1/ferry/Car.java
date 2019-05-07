package cl222ae_assign1.ferry;

/**Car.java
 * @author Christoffer Lundström
 * @date: 23 Jan 2019
 */
public class Car extends Vehicle{
	
	private final int MAX_PASSENGERS = 4;
	private final int PASSENGER_PRICE = 20;
	private final int VEHICLE_PRICE = 100;
	private final int OCCUPIED_SPACE = 5;
	

	/**@param amountOfPassengers Amount of passengers in the car.*/
	public Car(int amountOfPassengers) {
		super.occupiedSpace = OCCUPIED_SPACE;
		super.pricePerVehicle = VEHICLE_PRICE;
		super.passengerPrice = PASSENGER_PRICE;
		super.maxPassengers = MAX_PASSENGERS;
		
		super.validatePassengers(amountOfPassengers);
		super.populateVehicle(amountOfPassengers);
	}
	
	
	@Override
	public String toString() {
		return "Car, ticket-id: " + ticketId;
	}
}
