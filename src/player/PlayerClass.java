package player;
import java.util.*;

import player.exceptions.*;
import items.*;
import locations.*;

public class PlayerClass implements Player {

	private static final int BAG_DEFAULT_SIZE = 10;
	private static final int STACK_DEFAULT_SIZE = 64;
	
	private String name;
	private int bagSize;
	private Location location;
	private Map<String, ArrayList<Item>> bag;
	
	public PlayerClass(String name, Location location) {
		this.name = name;
		this.location = location;
		bagSize=BAG_DEFAULT_SIZE;
		bag = new HashMap<String, ArrayList<Item>>(bagSize);
	}
	
	public String getName() {
		return name;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location newLocation) {
		location = newLocation;
	}
	
	public void upgradeBag(int size) {
		Map<String, ArrayList<Item>> newBag = new HashMap<String, ArrayList<Item>>(size);
		newBag.putAll(bag);
		bag = newBag;
			
	}
	
	public void getItem(List<Item> items) {
		for(Item item: items) {
			
			if(isBagFull()) throw new BagFullException();
			
			String itemType = item.getItemType();
			ArrayList<Item> list = bag.get(itemType);
			
			if(list==null) {
				list = new ArrayList<Item>();
				bag.put(itemType, list);
			} else if(isStackedItem(itemType)) throw new StakedItemException(itemType);
			
			list.add(item);
			
		}
	}
	
	private boolean isStackedItem(String itemType) {
		return bag.get(itemType).size() == STACK_DEFAULT_SIZE;
	}
	
	private boolean isBagFull() {
		return bag.size()==bagSize;
	}
	
	public Iterator<ArrayList<Item>> listBag() {
		Iterator<ArrayList<Item>> it = bag.values().iterator();
		if(!it.hasNext()) throw new EmpetyBagException();
		return it;
	}
}
