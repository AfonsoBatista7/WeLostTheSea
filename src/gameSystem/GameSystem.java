package gameSystem;

import java.util.*;

import gameSystem.exceptions.*;
import player.exceptions.*;
import locations.exceptions.*;
import objects.*;
import objects.Object;

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
	 * @param itemList - all the items the player want to get.
	 */
	void getItem(String items) throws ItemNotInLocationException, NotAnItemException, BagFullException, StakedItemException;
	
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
	
	Iterator<String> allLocationItems() throws NoObjectsException;
	
	Iterator<NonItem> allLocationObjects()  throws NoObjectsException;
	
	void dropItem(String items) throws ItemNotInBagException;
	
}

