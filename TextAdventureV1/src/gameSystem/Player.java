package gameSystem;

import items.Item;

public class Player {

	private Item[] bag;
	private String name, location;
	private int level, HP, balance, bagCounter, itemsGathered, state;
	private int droppedItems;
	
	private static final int DEFAULT_SIZE = 10, START_HP = 100, START_MONEY = 1000;
	
	public Player( String name ) {
		bag=new Item[DEFAULT_SIZE];
		HP=START_HP;
		balance=START_MONEY;
		level=0;
		bagCounter=0;
		droppedItems=0;
		itemsGathered=0;
		location="BedRoom";
		state=0;                   // 0 - Standing    1 - Sit     2 - Lying 
		this.name = name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getState() {
		return state;
	}
	
	public void stand() {
		state = 0;
	}
	
	public void sit() {
		state = 1;
	}
	
	public void lay() {
		state = 2;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getHp() {
		return HP;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void incBalance(int addAmount) {
		balance += addAmount;
	}
	
	public void decBalance(int addAmount) {
		balance -= addAmount;
	}
	
	public void addItem(Item item) {
		bag[bagCounter++] = item;
	}
	
	public Item getItem(String itemName) {
		return bag[findItem(itemName)];
	}
	
	public void dropItem(String itemName, int quantity) {
		droppedItems = 0;
		if(getQuantity(itemName) <= quantity) {
			droppedItems=getQuantity(itemName);
			for(int i = findItem(itemName); i < bagCounter-1; i++) {
				bag[i] = bag[i + 1];
			}
			bagCounter--;
		} else {
			decQuantity(itemName, quantity);
			droppedItems = quantity;
		}
	}
	
	private int findItem(String itemName) {
		int i = 0;
		while (i < bagCounter) {
			if(bag[i].getItemName().equalsIgnoreCase(itemName)) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public String getItemName(String itemName) {
		return getItem(itemName).getItemName();
	}
	
	public boolean itemExists(String itemName) {
		return findItem(itemName) != -1;
	}
	
	public void incQuantity(String itemName, int quantity) {
		getItem(itemName).incQuantity(quantity);
	}
	
	public void decQuantity(String itemName, int quantity) {
		getItem(itemName).decQuantity(quantity);
	}
	
	public int getQuantity(String itemName) {
		int quantity=0;
		if(itemExists(itemName))
			quantity=bag[findItem(itemName)].getQuantity();
		return quantity;
	}
	
	public int getBagSlots() {
		return bagCounter;
	}
	
	public int getDropedItems() {
		return droppedItems;
	}
	
	public int getItemsGathered() {
		return itemsGathered;
	}
	
	public Item[] getBagList() {
		return bag;
	}
}
