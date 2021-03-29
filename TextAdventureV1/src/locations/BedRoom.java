package locations;

import items.*;

public class BedRoom extends LocationClass {

	private static Item[] items = {new ItemClass("Chair"), new ItemClass("Armchair"), new ItemClass("Computer"), new ItemClass("Bed") , new Book(10, "Book"), new ItemClass("Bottle",1)};
	
	private static boolean computer = false;
	
	public BedRoom() {
		super("BedRoom", items);
	}
	
	public boolean getComputer() {
		return computer;
}
 
	public static void turnOnOff() {
		computer = !computer;
	}
}
