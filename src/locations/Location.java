package locations;

import java.util.*;
import items.*;

public interface Location {

	/**
	 * @return Location name.
	 */
	String getLocationName();
	
	/**
	 * @return Location description.
	 */
	String getDescription();
	
	/**
	 * @return The location number north of this location.
	 */
	int getNorthLocation();
	
	/**
	 * @return The location number south of this location.
	 */
	int getSouthLocation();
	
	/**
	 * @return The location number west of this location.
	 */
	int getWestLocation();
	
	/**
	 * @return The location number east of this location.
	 */
	int getEastLocation();
	
	/**
	 * @param items - items the player want to pick up.
	 */
	Iterator<Item> getItem(List<String> items);
	
	/**
	 * @return List all the items on this location.
	 */
	Iterator<String> listItemsInLocation();
}
