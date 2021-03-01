package entity.entities;
import java.io.Serializable;
import java.util.*;

import entity.EntityClass;
import entity.exceptions.EmpetyBagException;
import locations.*;
import objects.*;

public class PlayerClass extends EntityClass implements Player, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4206642425890107132L;
	
	private static final int ACTION = 0;
	private static final double MONEY_DEFAULT = 1000;
	private static final String DEFAULT_NAME = "Jey";
	
	protected static Map<String, ArrayList<Item>> bag = new HashMap<String, ArrayList<Item>>(BAG_DEFAULT_SIZE);
	private int itemsGathered;
	
	
	public PlayerClass(Location location) {
		super(DEFAULT_NAME, location, MONEY_DEFAULT, ACTION, bag);
	}
	
	public void upgradeBag(int size) {
		Map<String, ArrayList<Item>> newBag = new HashMap<String, ArrayList<Item>>(size);
		newBag.putAll(super.bag);
		super.bag = newBag;
			
	}
	
	public Iterator<ArrayList<Item>> listBag() {
		Iterator<ArrayList<Item>> it = super.bag.values().iterator();
		if(!it.hasNext()) throw new EmpetyBagException();
		return it;
	}
	
	public int itemsGathered() {
		return itemsGathered;
	}
	
}
