package player;

import java.util.*;

import items.*;
import locations.Location;


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
	void getItem(List<Item> items);
	
	/**
	 * @return Player location.
	 */
	Location getLocation();
	
	/**
	 * Teleport the player to a new location
	 * @param newLocation
	 */
	void setLocation(Location newLocation);
}

