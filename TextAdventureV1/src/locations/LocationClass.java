package locations;

import items.Item;

public class LocationClass implements Location {
	
	private Item[] items;
	private String locationName;
	private int counter;
			
	public LocationClass(String locationName, Item[] items) {
		this.items = items;
		this.locationName = locationName;
		counter = items.length-1;
	}
	
	public int getCounter() {
		return counter;
	}
	
	public String getLocationName() {
		return locationName;
	}
	
	public boolean hasObjectInLocation(String itemName) {
		return findItem(itemName) != -1;
	}
	
	private int findItem(String itemName) {
		int i = 0;
		while (i < getCounter()) {
			if(items[i].getItemName().equalsIgnoreCase(itemName)) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	private void resise() {
		Item[] item = new Item[items.length+5];
		
		for(int i=0; i < getCounter(); i++) {
			item[i] = items[i];
		}
		
		items = item;
	}
	
	public Item getItem(String itemName) {
		return items[findItem(itemName)];
	}
	
	public int getQuantity(String itemName) {
		return getItem(itemName).getQuantity();
	}
	
	public void removeItem(String itemName, int quantity) {
		
		if(getQuantity(itemName) > quantity) {
			getItem(itemName).decQuantity(quantity);
		} else {
			for(int i = findItem(itemName); i<getCounter(); i++) {
				items[i] = items[i+1];
			}
			counter--;
		}
	}

	 public void addItem(Item item, String itemName, int quantity) {
			
		if(hasObjectInLocation(itemName)) {
			getItem(itemName).incQuantity(quantity);
		} else {
			if(counter==items.length)
				resise();
			items[counter++] = item;
		}
	}
	
	public void turnOnOff(String object) {
		if(object.equalsIgnoreCase("computer"))
			BedRoom.turnOnOff();
	}
	 
}
