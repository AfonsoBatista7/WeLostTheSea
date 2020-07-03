package gameSystem;

import java.util.*;

import items.*;
import gameSystem.exceptions.*;
import player.exceptions.*;
import locations.exceptions.*;

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
}
