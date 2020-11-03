package entety;

import java.util.*;

import entety.exceptions.ItemNotInBagException;
import objects.*;

public interface Player extends Entity {

	/**
	 * @return List all bag items.
	 */
	Iterator<ArrayList<Item>> listBag();
	
	/**
	 * @param item - item.
	 * @return The total quantity of an item. 
	 */
	int getQuantity(String item) throws ItemNotInBagException;

	int itemsGathered();
}

