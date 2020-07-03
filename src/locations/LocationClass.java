package locations;

import java.util.*;

import locations.exceptions.*;
import items.*;

public class LocationClass implements Location {

	private Map<String,LinkedList<Item>> locationItems;
	private String locationName, description;
	private int n, s, w, e;
	
	public LocationClass(String locationName ,String description, Map<String,LinkedList<Item>> items, int n, int s, int w, int e) {
		this.locationName = locationName;
		this.description = description;
		this.locationItems = items;
		this.n = n;
		this.s = s;
		this.w = w;
		this.e = e;
	}
	
	public String getLocationName() {
		return locationName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getNorthLocation() {
		return n;
	}
	
	public int getSouthLocation() {
		return s;
	}
	
	public int getWestLocation() {
		return w;
	}
	
	public int getEastLocation() {
		return e;
	}
	
	public Iterator<Item> getItem(List<String> items) {
		List<Item> itemList = new LinkedList<Item>();
		for(String itemType: items) {

			List<Item> list = locationItems.get(itemType.toLowerCase());
			
			if(list==null) throw new ItemNotInLocationException(itemType);
			Item item = list.remove(0);
			
			if(list.isEmpty()) locationItems.remove(itemType);
			
			if(!(item instanceof Item)) throw new NotAnItemException(itemType);
			
			itemList.add(item);
		}
		
		return itemList.iterator();
	}
	
	public Iterator<String> listItemsInLocation() {
		return locationItems.keySet().iterator();
	}
}
