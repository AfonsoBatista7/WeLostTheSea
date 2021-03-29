package gameSystem;

import locations.*;

public class LocationCollection {
	
	private Location[] locations = {new BedRoom(), new NoWhere(), new SpreechForest(), new SpreechVillage(), new SpreechLandscape(), new FrostyHills(), new FrostyMountain()};
	private int locationCounter;

	public LocationCollection() {
		locationCounter=7;
	}
	
	public boolean hasObjectInLocation(String object, String locationName) {	
		return getLocation(locationName).hasObjectInLocation(object);
	}
	
	public Location getLocation(String locationName) {
		return locations[findLocation(locationName)];
	}
	
	private int findLocation(String locationName) {
		int i = 0;
		while (i < locationCounter) {
			if(locations[i].getLocationName().equalsIgnoreCase(locationName)) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public void turnOnOff(String object, String locationName) {
		getLocation(locationName).turnOnOff(object);
	}
	
	public String getComputer(String locationName) {
		String onOff;
		 if( ((BedRoom) getLocation(locationName)).getComputer())
		 	onOff = "On";
		 else
			onOff = "Off";
		 return onOff;
	}
	
	public int getQuantity(String itemName, String locationName) {
		return getLocation(locationName).getQuantity(itemName);
	}

}
