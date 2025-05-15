package org.afonsobatista.entity.entities;

import java.util.*;

import org.afonsobatista.entity.Entity;
import org.afonsobatista.objects.*;

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

