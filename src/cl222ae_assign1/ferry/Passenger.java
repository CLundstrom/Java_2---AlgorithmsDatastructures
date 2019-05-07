package cl222ae_assign1.ferry;

/**Passenger.java
 * @author Christoffer Lundström
 * @date: 23 Jan 2019
 */
public class Passenger {

	private int passengerPrice = 25; //Base price
	private boolean embarked = false;
	
	
	public Passenger(int price) {
		
		passengerPrice = price;
	}
	
	public Passenger() {
		
		passengerPrice = 25;
	}
	
	void setPassengerPrice(int price){
		passengerPrice = price;
	}
	
	
	public int getPassengerPrice() {
		
		return passengerPrice;
	}
	
	public void setEmbarked(boolean value) {
		
		embarked = value;
	}
	
	public boolean isEmbarked() {
		
		return embarked;
	}
}
