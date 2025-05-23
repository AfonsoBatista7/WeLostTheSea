package org.afonsobatista.entity;

import org.afonsobatista.locations.Location;
import org.afonsobatista.objects.Item;
import org.afonsobatista.objects.NonItem;
import org.afonsobatista.objects.items.Coin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.afonsobatista.entity.exceptions.*;
import org.afonsobatista.gameSystem.Actions;

/**
 * The Entity Class.
 * @author Afonso Batista
 */
public class EntityClass implements Entity, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 361861719932985800L;
	
	private String name;
	private int bagSize;
	private Location location;
	private NonItem objectSitting, objectUsing;
	private double money, sellTax;
	private Actions action;
	public Map<String, ArrayList<Item>> bag;
	
	
	private static final int STACK_DEFAULT_SIZE = 64;
	private static final double SELL_TAX= 1.5; 				// POR ENQUANTO FIXO MAS QUERIA POR VARIAS CLASSES COM TAX DIFERENTES.
	protected static final int BAG_DEFAULT_SIZE = 10;
	
	public EntityClass(String name, Location location, double money, Actions action, Map<String, ArrayList<Item>> bag) {
		this.name = name;
		this.location = location;
		this.money = money;
		this.action = action;
		sellTax = SELL_TAX;
		this.bag = bag;
		bagSize = BAG_DEFAULT_SIZE;
	}
	
	public EntityClass(String name, Actions action, Map<String, ArrayList<Item>> bag) {
		this.name = name;
		this.action = action;
		sellTax = SELL_TAX;
		money = 10000000;
		this.bag = bag;
		bagSize = 10000;
	}
	
	
	public NonItem getSittingObject() {
		return objectSitting;
	}
	
	public NonItem getUsingObject() {
		return objectUsing;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public Actions getAction() {
		return action;
	}
	
	public double getSellTax() {
		return sellTax;
	}
	
	public void buy(double price) {
		if(money<price) throw new NoMoneyException();
		money-=price;
	}
	
	public void sell(double price) {
		money+=price;
	}
	
	public boolean isUsingObject(NonItem object) {
		return object.equals(objectUsing);
	}
	
	public boolean sittingObject() {
		return objectSitting!=null;
	}
	
	public void noLongerSitting() {
		if(action.equals(Actions.STAND)) throw new ObjectOccupiedException(this);
		objectSitting.stopUsing();
		objectSitting.stopAction();
		objectSitting = null;
		action = Actions.STAND;
	}
	
	public void action(Actions action, NonItem object) {
		if(action.equals(Actions.USE)) objectUsing = object;
		else {	
		
			if(sittingObject()) objectSitting.stopUsing();
		
		
			if(!object.isAvailable() || object.sameAction(action)) {
				objectSitting.objectOccupied(action, this);
				throw new ObjectOccupiedException(object.getUser());
			}
		
			if(sittingObject()) objectSitting.stopAction();
		
			objectSitting = object;
		}
		objectSitting.objectOccupied(action, this);
		
		this.action=action;
	}
	
	public void getItem(Item item) {
		if(isBagFull()) throw new BagFullException();
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
	
	public int getQuantity(String item) {
		ArrayList<Item> items = bag.get(item);
		if(items==null) throw new ItemNotInBagException(item);
		
		return items.size();
	}

}
