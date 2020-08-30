package gameSystem;

import java.util.*;

import Actor.*;
import gameSystem.exceptions.*;
import player.exceptions.*;
import locations.*;
import locations.exceptions.*;
import objects.*;

public interface GameSystem {
	
	/**
	 * Start the Time Played timer.
	 */
	void startTimer();
	
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
	void getItem(String item) throws ItemNotInLocationException, NotAnItemException, BagFullException, StakedItemException;
	
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
	
	Iterator<LinkedList<Item>> allLocationItems() throws NoObjectsException;
	
	Iterator<NonItem> allLocationObjects()  throws NoObjectsException;
	
	Iterator<String> splitItems(String items);
	
	int getLocationItemQuant(String itemType);
	
	Iterator<String> allLocationItemTypes();
	
	void setLocation(Actor acter, Location newLocation);
	
	void movePlayer(Directions dir);
	
	void moveTo(Actor acter, Directions dir);
	
	void descriptionMode();
	
	boolean isInDescriptionMode();
	
}

