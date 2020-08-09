package locations;

import java.util.*;

import locations.exceptions.*;
import objects.*;
import objects.Object;
import player.exceptions.BagFullException;
import player.exceptions.StakedItemException;

public class LocationClass implements Location {

	private Map<String, LinkedList<Item>> locationItems;
	private Map<String, NonItem> locationObjects;
	private String locationName, description;
	private int n, s, w, e;
	
	public LocationClass(String locationName ,String description, Map<String, LinkedList<Item>> items, Map<String, NonItem> objects, int n, int s, int w, int e) {
		this.locationName = locationName;
		this.description = description;
		this.locationItems = items;
		this.locationObjects = objects;
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
	
	public Iterator<NonItem> allObjects() {
		if(locationObjects.isEmpty()) throw new NoObjectsException();
		return locationObjects.values().iterator();
	}
	
	public Iterator<String> allItems() {
		if(locationItems.isEmpty()) throw new NoObjectsException();
		return locationItems.keySet().iterator();
	}
	
	public Iterator<Item> allItemsByType(String itemType) {
		List<Item> list = locationItems.get(itemType.toLowerCase());
		if(list==null) throw new ItemNotInLocationException(itemType);
		return list.iterator();
	}
	
	public Iterator<Item> getItem(Iterator<String> items) {
		List<Item> itemList = new LinkedList<Item>();
		
		while(items.hasNext()) {
			String itemType = items.next();
			List<Item> list = locationItems.get(itemType.toLowerCase());
			Object object = locationObjects.get(itemType.toLowerCase());
			
			if(list==null) {
				if(object!=null)
					throw new NotAnItemException(itemType);
				throw new ItemNotInLocationException(itemType);
			}
			
			Item item = list.remove(0);
			
			if(list.isEmpty()) locationItems.remove(itemType);
			
			itemList.add(item);
		}
		
		return itemList.iterator();
	}
	
	public void dropItem(Iterator<Item> items) {
		while(items.hasNext()) {
			Item item = items.next();
			
			String itemType = item.getObjectType().toLowerCase();
			LinkedList<Item> list = locationItems.get(itemType);
			
			if(list==null) {
				list = new LinkedList<Item>();
				locationItems.put(itemType, list);
			}
			
			list.add(item);
			
		}
	}
	
}
