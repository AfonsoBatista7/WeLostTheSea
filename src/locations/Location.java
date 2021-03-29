package locations;

import java.util.*;

import entity.Entity;
import gameSystem.Actions;
import locations.exceptions.*;
import objects.*;

/**
 * @author Afonso Batista
 *
 */
public interface Location {

	/**
	 * @return Location name.
	 */
	String getLocationName();
	
	/**
	 * @return Location's big description.
	 */
	String getBigDescription();
	
	/**
	 * @return Location's small description.
	 */
	String getSmallDescription();
	
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
	 * An entity gets an <item> from a location.
	 * @param item - item an entity want to pick up.
	 */
	Item getItem(String item) throws NotAnItemException, ObjectNotInLocationException;
	
	/**
	 * An entity drops an <item> at a location.
	 * @param item - item an entity want to drop at a location.
	 */
	void dropItem(Item item);
	
	/**
	 * @return List all the items on this location.
	 */
	Iterator<LinkedList<Item>> allItems();
	
	/**
	 * @return List all the objects on this location.
	 */
	Iterator<NonItem> allObjects();
	
	/**
	 * @param itemType - Item type.
	 * @return List all items of that type on this location.
	 */
	Iterator<Item> allItemsByType(String itemType);
	
	int itemQuant(String itemType);
	
	Iterator<String> allItemTypes();
	
	boolean itemNotInLocation(String item);
	
	NonItem getObject(String object);
	
	void actionObject(NonItem object,Actions action ,Entity user);
	
	Entity getEntity(String name);
	
	Iterator<Entity> allEntities();
}
