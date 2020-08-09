package locations;

import java.util.*;

import locations.exceptions.ItemNotInLocationException;
import locations.exceptions.NotAnItemException;
import objects.*;
import objects.Object;

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
	Iterator<Item> getItem(Iterator<String> items) throws NotAnItemException, ItemNotInLocationException;
	
	void dropItem(Iterator<Item> items);
	
	/**
	 * @return List all the items on this location.
	 */
	Iterator<String> allItems();
	
	/**
	 * @return List all the objects on this location.
	 */
	Iterator<NonItem> allObjects();
	
	/**
	 * @param itemType - Item type.
	 * @return List all items of that type on this location.
	 */
	Iterator<Item> allItemsByType(String itemType);
}
