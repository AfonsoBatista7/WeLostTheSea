package gameSystem;

import items.Item;

public class InventoryIterator {

	private Item[] bag;
	private int counter, nextItem; 
	
	public InventoryIterator(Item[] bag, int counter) {
		this.counter = counter; 
		this.bag = bag;
		nextItem=0;
	}
	
	public boolean hasNext() {
		return nextItem < counter;
	}
	
	public Item next() {
		return bag[nextItem++];
	}
}