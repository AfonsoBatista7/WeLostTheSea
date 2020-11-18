package entity;

import locations.Location;
import objects.Item;
import objects.NonItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import entity.exceptions.*;
import gameSystem.Actions;

/**
 * The Entity Class.
 * @author Afonso Batista
 */
public class EntityClass implements Entity {

	private String name;
	private int money, action;
	private Location location;
	private NonItem objectUsing;
	private int bagSize;
	protected Map<String, ArrayList<Item>> bag;
	
	private static final int BAG_DEFAULT_SIZE = 10, STACK_DEFAULT_SIZE = 64;
	
	public EntityClass(String name, Location location, int money, int action) {
		this.name = name;
		this.location = location;
		this.money = money;
		this.action = action;
		bagSize=BAG_DEFAULT_SIZE;
		bag = new HashMap<String, ArrayList<Item>>(bagSize);
	}
	
	public EntityClass(String name, Location location, int action) {
		this.name = name;
		this.location = location;
		this.action = action;
	}
	
	public NonItem getUsingObject() {
		return objectUsing;
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
	
	public int getBalance() {
		return money;
	}
	
	public int getAction() {
		return action;
	}
	
	public void buy(int price) {
		money=-price;
	}
	
	public void sell(int price) {
		money+=price;
	}
	
	public boolean usingObject() {
		return objectUsing!=null;
	}
	
	public void noLongerUsing() {
		objectUsing.objectOccupied(null);
		objectUsing = null;
	}
	
	public void action(Actions action, NonItem object) {
		int actionValue = action.getValue();
		
		if(!object.isAvailable()) throw new ObjectOccupiedException(object.getUser());         //MELHORAR CODIGO
		if(usingObject()) getLocation().actionObject(objectUsing, this);
		objectUsing = object;
		getLocation().actionObject(object, this);

		this.action=actionValue;
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
	
	/**
	 * @param itemType - The type of the item that you want.
	 * @return true if the item is already stacked (he's quantity on bag
	 * is greater than 64) and false if not.
	 */
	private boolean isStackedItem(String itemType) {
		return bag.get(itemType).size() == STACK_DEFAULT_SIZE;
	}
	
	/**
	 * @return true if the bag is full and false if not.
	 */
	private boolean isBagFull() {
		return bag.size()==bagSize;
	}

}
