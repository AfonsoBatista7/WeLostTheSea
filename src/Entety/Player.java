package entety;

import java.util.*;

import entety.exceptions.ItemNotInBagException;
import objects.*;

/**
 * The player.
 * @author Afonso Batista
 */
public interface Player extends Entity {

	/**
	 * @return List all bag items.
	 */
	Iterator<ArrayList<Item>> listBag();
	
	/**
	 * @param item - item.
	 * @return the total quantity of an item. 
	 */
	int getQuantity(String item) throws ItemNotInBagException;

	/**
	 * @return the total of special items gathered.
	 */
	int itemsGathered();
}

