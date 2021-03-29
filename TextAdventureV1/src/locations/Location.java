package locations;

import items.Item;

public interface Location {
	
	int getCounter();
	String getLocationName();
	boolean hasObjectInLocation(String itemName);
	Item getItem(String itemName);
	int getQuantity(String itemName);
	void removeItem(String itemName, int quantity);
	void addItem(Item item, String itemName, int quantity);
	void turnOnOff(String object);
	
}
