package Actor;

import java.util.*;

import locations.Location;
import locations.exceptions.NotAnItemException;
import objects.*;
import player.exceptions.*;


public interface Player extends Actor {

	/**
	 * @return List all bag items.
	 */
	Iterator<ArrayList<Item>> listBag();
	
	/**
	 * Gets items.
	 * @param items - list of items the player picked. 
	 */
	void getItem(Item item) throws BagFullException, StakedItemException;
	
	/**
	 * @param item - Item the player wants to drop.
	 * @return Item to drop.
	 * @throws ItemNotInBagException - If the wanted item is not in the bag.
	 */
	Item dropItem(String item) throws ItemNotInBagException;
	
	/**
	 * @param item - item.
	 * @return The total quantity of an item. 
	 */
	int getQuantity(String item) throws ItemNotInBagException;
	
	/**
	 * @return
	 */
	int getMoney();
	
	/**
	 * Sell something.
	 * @param price - Money you have to gain.
	 */
	void sell(int price);
	
	/**
	 * Buy something.
	 * @param price - Money you have to pay.
	 */
	void buy(int price);
}

