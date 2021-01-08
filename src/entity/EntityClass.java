package entity;

import locations.Location;
import objects.Item;
import objects.NonItem;
import objects.items.Coin;

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
	private int action, bagSize;
	private Location location;
	private NonItem objectUsing;
	private double money, sellTax;
	protected Map<String, ArrayList<Item>> bag;
	
	private static final int BAG_DEFAULT_SIZE = 10, STACK_DEFAULT_SIZE = 64;
	private static final double SELL_TAX= 1.5; 							// POR ENQUANTO � FIXO MAS QUERIA POR VARIAS CLASSES COM TAX DIFERENTES.
	
	public EntityClass(String name, Location location, double money, int action) {
		this.name = name;
		this.location = location;
		this.money = money;
		this.action = action;
		bagSize = BAG_DEFAULT_SIZE;
		sellTax = SELL_TAX;
		bag = new HashMap<String, ArrayList<Item>>(bagSize);
	}
	
	public EntityClass(String name, int action, ArrayList<Item> bag) {
		this.name = name;
		this.action = action;
		money = 10000000;
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
	
	public double getBalance() {
		return money;
	}
	
	public int getAction() {
		return action;
	}
	
	public double getSellTax() {
		return sellTax;
	}
	
	public void buy(double price) {
		if(money<price) throw new NoMoneyException();
		money=-price;
	}
	
	public void sell(double price) {
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
		
		if(!object.isAvailable()) throw new ObjectOccupiedException(object.getUser());         
		if(usingObject()) getLocation().actionObject(objectUsing, this);
		objectUsing = object;
		getLocation().actionObject(object, this);

		this.action=actionValue;
	}
	
	public void getItem(Item item) {
		if(isBagFull()) throw new BagFullException();
		if(item instanceof Coin) { money+= ((Coin) item).getCoinValue(); return; }
		String itemType = item.getObjectType();
		if(item instanceof Coin) { money+= (item.getItemPrice()); return; }
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
