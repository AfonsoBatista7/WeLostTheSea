package player;

import java.util.*;

import locations.Location;
import locations.exceptions.NotAnItemException;
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
	void getItem(Iterator<Item> items) throws BagFullException, StakedItemException;
	
	Iterator<Item> dropItem(Iterator<String> items) throws ItemNotInBagException;
	
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

