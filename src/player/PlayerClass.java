package player;
import java.util.*;

import player.exceptions.*;
import locations.*;
import locations.exceptions.ItemNotInLocationException;
import locations.exceptions.NotAnItemException;
import objects.*;
import objects.Object;

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
	
	public int getQuantity(String item) {
		ArrayList<Item> items = bag.get(item);
		if(items==null) throw new ItemNotInBagException(item);
		
		return items.size();
	}
	
	public void upgradeBag(int size) {
		Map<String, ArrayList<Item>> newBag = new HashMap<String, ArrayList<Item>>(size);
		newBag.putAll(bag);
		bag = newBag;
			
	}
	
	public void getItem(Iterator<Item> items) {
		while(items.hasNext()) {
			Item item = items.next();
			if(isBagFull()) throw new BagFullException();
			
			String itemType = item.getObjectType();
			ArrayList<Item> list = bag.get(itemType);
			
			if(list==null) {
				list = new ArrayList<Item>();
				bag.put(itemType, list);
			} else if(isStackedItem(itemType)) throw new StakedItemException(itemType);
			
			list.add(item);
			
		}
	}
	
	public Iterator<Item> dropItem(Iterator<String> items) {
		List<Item> itemList = new LinkedList<Item>();
				
		while(items.hasNext()) {
			String itemType = items.next();
			itemType = itemType.substring(0,1).toUpperCase() + itemType.substring(1).toLowerCase();
			List<Item> list = bag.get(itemType);
					
			if(list==null) throw new ItemNotInBagException(itemType);
					
			Item item = list.remove(0);
				
			if(list.isEmpty()) bag.remove(itemType);
				
			itemList.add(item);
			}
				
		return itemList.iterator();
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
