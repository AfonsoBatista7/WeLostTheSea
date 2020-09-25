package entety;
import java.util.*;

import entety.exceptions.BagFullException;
import entety.exceptions.EmpetyBagException;
import entety.exceptions.ItemNotInBagException;
import entety.exceptions.StakedItemException;
import locations.*;
import objects.*;

public class PlayerClass extends EntetyClass implements Player {

	private static final int BAG_DEFAULT_SIZE = 10, STACK_DEFAULT_SIZE = 64, MONEY_DEFAULT = 100, ACTION = 0;
	
	private int bagSize, itemsGathered;
	private Map<String, ArrayList<Item>> bag;
	
	public PlayerClass(String name, Location location) {
		super(name, location, MONEY_DEFAULT, ACTION);
		bagSize=BAG_DEFAULT_SIZE;
		bag = new HashMap<String, ArrayList<Item>>(bagSize);
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
	
	public void getItem(Item item) {
			if(isBagFull()) throw new BagFullException();
			
			String itemType = item.getObjectType();
			ArrayList<Item> list = bag.get(itemType);
			
			if(list==null) {
				list = new ArrayList<Item>();
				bag.put(itemType, list);
			} else if(isStackedItem(itemType)) throw new StakedItemException(itemType);
			
			list.add(item);
	}
	
	public Item dropItem(String item) {
		
		item = item.substring(0,1).toUpperCase() + item.substring(1).toLowerCase();
		List<Item> list = bag.get(item);
					
		if(list==null) throw new ItemNotInBagException(item);
					
		Item getItem = list.remove(0);
			
		if(list.isEmpty()) bag.remove(item);
				
		return getItem;
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
	
	public int itemsGathered() {
		return itemsGathered;
	}
	
}
