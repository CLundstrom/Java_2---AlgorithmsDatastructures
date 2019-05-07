package cl222ae_assign1.ferry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**Ship.java
 * @author Christoffer Lundström
 * @date: 23 Jan 2019
 *
 * Space is redefined as SQM and is a multiplier of 5 to the Original limit of each vehicle.
 * Doesn't make any sense to use Car as a unit of measurement.
 * 
 * 	Car: 1*5 = 5sqm
 * 	Bike: 0.2f*5 = 1sqm
 * 	Lorry: 8*5 = 40sqm
 * 	Bus: 4*5 = 20sqm
 * 
 * 	Limit: 40*5 = 200sqm
 * */
public class Ship implements Ferry{
	
	private final int PASSENGER_LIMIT = 200;
	private final int CAR_LIMIT = 200; //40*5
	private int ticketNumber = 0;
	
	private List<Passenger> passengerManifest;
	private List<Vehicle> vehicleManifest;
	private int funds = 0;
	private int occupiedSpace = 0;
	
	
	public Ship() {
		passengerManifest = new ArrayList<Passenger>();
		vehicleManifest = new ArrayList<Vehicle>();
	}

	@Override
	public int countPassengers() {
		
		return passengerManifest.size();
	}

	@Override
	public int countVehicleSpace() {
		
		return (CAR_LIMIT - occupiedSpace);
	}

	@Override
	public int countMoney() {
		return funds;
	}

	@Override
	public Iterator<Vehicle> iterator() {
		Iterator<Vehicle> it = new Iterator<Vehicle>() {
			
			int index = 0;

            @Override
            public Vehicle next() {
                return vehicleManifest.get(index++);
            }
			
            @Override
            public boolean hasNext() {
            	
            	return (index < vehicleManifest.size() && vehicleManifest.get(index) != null);
            }
		};
		
		return it;
	}

	
	/**
	 * Handles the embarking of all vehicles including it's passengers.
	 * 
	 * @param v Vehicle to embark.*/
	@Override
	public void embark(Vehicle v) {
		
		if (!hasSpaceFor(v)) {
			System.err.println("Not enough room for more vehicles.");
		}
		
		else if (v.embarked == true) {
			System.err.println("Vehicle already embarked.");
		}
		
		else {
			//Embark and pay for vehicle.
			v.ticketId = ticketNumber + 1;
			ticketNumber++;
			v.embarked = true;
			vehicleManifest.add(v);
			funds += v.pricePerVehicle;
			
			for(Passenger p: v.passengers) {
				//Embark and pay for each passenger
				embark(p);
			}
			occupiedSpace += v.occupiedSpace;
		}
	}

	
	/**
	 * Handles the embarking of separate passengers.
	 * 
	 * @param p Passenger to embark.*/
	@Override
	public void embark(Passenger p) {
		
		if(!hasRoomFor(p)) {
			System.err.println("Not enough room for passenger.");
		}
		
		else if(p.isEmbarked() == true) {
			System.err.println("Passenger already embarked.");
		}
		else {
			funds += p.getPassengerPrice();
			passengerManifest.add(p);
			p.setEmbarked(true);
		}
	}

	@Override
	public void disembark() {
		//Disembarking all passengers and vehicles.
		for(Passenger p : passengerManifest) {
			p.setEmbarked(false);
		}
		for(Vehicle v : vehicleManifest) {
			v.embarked = false;
		}
		
		// Resetting defaults.
		passengerManifest = new ArrayList<Passenger>();
		vehicleManifest = new ArrayList<Vehicle>();
		occupiedSpace = 0;
	}

	@Override
	public boolean hasSpaceFor(Vehicle v) {
		if(this.occupiedSpace + v.occupiedSpace <= CAR_LIMIT) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hasRoomFor(Passenger p) {
		if(countPassengers() < PASSENGER_LIMIT) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		int cars = 0;
		int lorries = 0;
		int buses = 0;
		int bikes = 0;
		
		for(Vehicle v: vehicleManifest) {
			if(v instanceof Car) {
				cars++;
			}
			else if (v instanceof Lorry) {
				lorries++;
			}
			else if (v instanceof Bus) {
				buses++;
			}
			else if (v instanceof Bicycle) {
				bikes++;
			}
			
			else {
				// Should never happen because any object in the list is of type Vehicle.
				throw new IllegalArgumentException("Illegal object in Vehicle manifest.");
			}
			
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Current funds: " + countMoney() + "\n");
		sb.append("Passenger manifest: " + passengerManifest.size() + " souls onboard.\n");
		sb.append("Vehicles onboard: ");
		sb.append("Cars: " + cars + ", ");
		sb.append("Buses: " + buses + ", ");
		sb.append("Lorries: " + lorries + ", ");
		sb.append("Bikes: " + bikes);
		sb.append("\n---------------");
		sb.append("\nAvailable space (sqm): " + countVehicleSpace() + "\tPassengers: " + (PASSENGER_LIMIT-passengerManifest.size()+ 
				"\n\tCars: " + (CAR_LIMIT - occupiedSpace)/5) +
				"\n\tLorries: " + (CAR_LIMIT - occupiedSpace)/40 +
				"\n\tBuses: " + (CAR_LIMIT - occupiedSpace)/20 +
				"\n\tBikes: " + (CAR_LIMIT - occupiedSpace));
		
		return sb.toString();
	}
	
}
