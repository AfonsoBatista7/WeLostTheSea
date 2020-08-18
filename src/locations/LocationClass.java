package locations;

import java.util.*;

import locations.exceptions.*;
import objects.*;
import objects.Object;

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
	
	public Item getItem(String item) {
			
			List<Item> list = locationItems.get(item.toLowerCase());
			Object object = locationObjects.get(item.toLowerCase());
			
			if(list==null) {
				if(object!=null)
					throw new NotAnItemException(item);
				throw new ItemNotInLocationException(item);
			}
			
			Item getItem = list.remove(0);
			
			if(list.isEmpty()) locationItems.remove(item);
		
		return getItem;
	}
	
	public void dropItem(Item item) {
			
		String getItem = item.getObjectType().toLowerCase();
		LinkedList<Item> list = locationItems.get(getItem);
			
		if(list==null) {
			list = new LinkedList<Item>();
			locationItems.put(getItem, list);
		}
			
		list.add(item);
	}
			
	
}
	
