package cl222ae_assign1.ferry;

import java.util.Iterator;

/**FerryMain.java
 * @author Christoffer Lundström
 * @date: 23 Jan 2019
 */
public class FerryMain {

	public static void main(String[] args) {
		
		Ship ship = new Ship();
		
		ship.embark(new Car(4));
		ship.embark(new Lorry(2));
		ship.embark(new Bicycle());
		ship.embark(new Bicycle());
		ship.embark(new Passenger());
		
		System.out.println("Vehicles embarked: ");
		Iterator<Vehicle> it = ship.iterator();
		while(it.hasNext()) {
			System.out.println("\t" + it.next().toString());
		}
		System.out.println();
		System.out.println(ship.toString());
		System.out.println("\nDisembarking..\n");
		ship.disembark();
		System.out.println();
		System.out.println(ship.toString());
		System.out.println();
		System.out.println("Embarking..\n");
		
		for(int i = 0; i < 5; i ++) {
			ship.embark(new Car(4));
			ship.embark(new Bus(20));
			ship.embark(new Bicycle());
			ship.embark(new Passenger());
			ship.embark(new Passenger());
			ship.embark(new Passenger());
		}
		
		ship.embark(new Car(4));
		System.out.println(ship.toString());
		
	}
	
	
	
}
