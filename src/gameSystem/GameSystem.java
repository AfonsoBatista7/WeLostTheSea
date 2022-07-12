package gameSystem;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import entity.*;
import entity.exceptions.BagFullException;
import entity.exceptions.EmpetyBagException;
import entity.exceptions.ItemNotInBagException;
import entity.exceptions.StakedItemException;
import gameSystem.exceptions.*;
import locations.*;
import locations.exceptions.*;
import objects.*;

public interface GameSystem {
	
	void exit();
	
	/**
	 * Start the Time Played timer.
	 */
	void startTimer();
	
	void setPlayerLocation(int location);
	
	/**
	 * @return Time played.
	 */
	String timePlayed();
	
	/**
	 * Creates a player.
	 * @param name - Player Name.
	 * @throws TooLongNameException.
	 */
	void newPlayer(String name) throws TooLongNameException;
	
	/**
	 * @return Player name;
	 */
	String getPlayerName();
	
	/**
	 * @param item - item the player want to get.
	 */
	void getItem(String item) throws ObjectNotInLocationException, NotAnItemException, BagFullException, StakedItemException;
	
	/**
	 * @param item - ietm the player want to drop.
	 */
	void dropItem(String item) throws ItemNotInBagException;
	
	/**
	 * @return - The items on the player bag.
	 * @throws EmpetyBagException
	 */
	Iterator<ArrayList<Item>> listBag() throws EmpetyBagException;
	
	/**
	 * @return the Location Name.
	 */
	String getLocationName();
	
	/**
	 * @return the location description.
	 */
	String getLocationDescription();
	
	/**
	 * @param item - item.
	 * @return The total quantity of an item.
	 * @throws ItemNotInBagException
	 */
	int getQuantity(String item) throws ItemNotInBagException;
	
	/**
	 * @return all the items in location.
	 * @throws NoObjectsException
	 */
	Iterator<LinkedList<Item>> allLocationItems() throws NoObjectsException;
	
	/**
	 * @return all the objects in location.
	 * @throws NoObjectsException
	 */
	Iterator<NonItem> allLocationObjects()  throws NoObjectsException;
	
	/**
	 * @param items - all the items gathered on a String
	 * @return all the items splitted into individual item types.
	 */
	Iterator<String> splitItems(String items);
	
	/**
	 * @param itemType - The item type you want to search.
	 * @return the total quantity of the item in your location.
	 */
	int getLocationItemQuant(String itemType);
	
	/**
	 * @return all item types at your location.
	 */
	Iterator<String> allLocationItemTypes();
	
	/**
	 * Sets an entity to a new location.
	 * @param entity - entity you want to set location.
	 * @param newLocation - new location for the entity.
	 */
	void setLocation(Entity entity, Location newLocation);
	
	/**
	 * Moves the player to any of the four <Directions>. 
	 * @param dir - North, South, West or East.
	 */
	void movePlayer(Directions dir);
	
	/**
	 * Moves an <Entity> to any of the four <Directions>.
	 * @param entity - entity you want to move.
	 * @param dir - North, South, West or East.
	 */
	void moveTo(Entity entity, Directions dir);
	
	/**
	 * Turns your adventure to 'Description Mode' witch gives lower(if on) 
	 * or bigger(if off) descriptions of locations.
	 */
	void descriptionMode();
	
	/**
	 * @return true if the game is on Description mode and false if not.
	 */
	boolean isInDescriptionMode();
	
	/**
	 * @return the player money quantity at the time.
	 */
	double getPlayerBalance();
	
	/**
	 * @return the date that the player has started the game for the first time.
	 */
	String getStartDate();
	
	/**
	 * @return the total of special items gathered.
	 */
	int itemsGathered();
	
	/**
	 * The a action like sitting on a object.
	 * @param property - the action you want to do.
	 * @param object - The object you want to do the action against.
	 */
	void action(Propertys property, String object);
	
	double buy(String item, String seller, int quantity);
	
	double sell(String item, String buyer, int quantity);
	
	int getEntityQuantity(String entity, String item);
	 
	void startGame();
	 
	boolean hasStarted();
	
	ObjectOutputStream save() throws Exception;
	
	File[] getSaveFiles();
	
	ObjectInputStream load(File file) throws Exception;
	
	String getTxt();
	
	boolean isUsing(String object);
	
}

