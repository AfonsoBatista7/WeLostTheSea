package player;

import java.util.*;

import locations.Location;
import objects.*;
import player.exceptions.*;


public interface Player {
	/**
	 * @return Player name.
	 */
	String getName();
	
	/**
	 * @return List all bag items.
	 */
	Iterator<ArrayList<Item>> listBag();
	
	/**
	 * Gets items.
	 * @param items - list of items the player picked. 
	 */
	void getItem(List<Item> items) throws BagFullException, StakedItemException;
	
	/**
	 * @return Player location.
	 */
	Location getLocation();
	
	/**
	 * Teleport the player to a new location
	 * @param newLocation
	 */
	void setLocation(Location newLocation);
	
	/**
	 * @param item - item.
	 * @return The total quantity of an item. 
	 */
	int getQuantity(String item) throws ItemNotInBagException;
}

