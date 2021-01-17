package entity;

import java.util.*;

import entity.exceptions.ItemNotInBagException;
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
	 * @return the total of special items gathered.
	 */
	int itemsGathered();
}

