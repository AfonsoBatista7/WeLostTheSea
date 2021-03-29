package locations;

import java.io.Serializable;
import java.util.*;

import entity.Entity;
import gameSystem.Actions;
import locations.exceptions.*;
import objects.*;

/**
 * @author Afonso Batista
 *
 */
public class LocationClass implements Location, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7021493368825983509L;
	
	private Map<String, LinkedList<Item>> locationItems;
	private Map<String, NonItem> locationObjects;
	private Map<String, Entity> locationEntitys;
	private String locationName, bigDescription, smallDescription;
	private int n, s, w, e;
	
	public LocationClass(String locationName ,String bigDescription, String smallDescription ,
			Map<String, LinkedList<Item>> items, Map<String, NonItem> objects, Map<String, Entity> entitys ,int n, int s, int w, int e) {
		locationItems = items;
		locationObjects = objects;
		locationEntitys = entitys;
		this.locationName = locationName;
		this.bigDescription = bigDescription;
		this.smallDescription = smallDescription;
		this.n = n;
		this.s = s;
		this.w = w;
		this.e = e;
	}
	
	public String getLocationName() {
		return locationName;
	}
	
	public String getBigDescription() {
		return bigDescription;
	}
	
	public String getSmallDescription() {
		return smallDescription;
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
	
	public Iterator<LinkedList<Item>> allItems() {
		if(locationItems.isEmpty()) throw new NoObjectsException();
		return locationItems.values().iterator();
	}
	
	public Iterator<String> allItemTypes() {
		if(locationItems.isEmpty()) throw new NoObjectsException();
		return locationItems.keySet().iterator();
	}
	
	public Iterator<Item> allItemsByType(String itemType) {
		List<Item> list = locationItems.get(itemType.toLowerCase());
		if(list==null) throw new ObjectNotInLocationException(itemType);
		return list.iterator();
	}
	
	public Iterator<Entity> allEntities() {
		if(locationEntitys.isEmpty()) throw new NoEntitiesException();
		return locationEntitys.values().iterator();
	}
	
	public Entity getEntity(String name) {
		Entity entity = locationEntitys.get(name);
		if(entity==null) throw new EntityNotInLocationException();
		return entity;
	}
		
	public boolean nonItemNotInLocation(String object) {
		if(!itsAnNonItem(object)) throw new ItsAnItemException(object);
		return locationObjects.get(object.toLowerCase())==null;
	}
	
	public boolean itemNotInLocation(String item) {
		if(!itsAnItem(item)) throw new NotAnItemException(item);
		return locationItems.get(item.toLowerCase())==null;
	}
	
	public NonItem getObject(String object) {
		if(nonItemNotInLocation(object)) throw new ObjectNotInLocationException(object);
		return locationObjects.get(object.toLowerCase());
	}
	
	public Item getItem(String item) {
			
			if(itemNotInLocation(item)) throw new ObjectNotInLocationException(item);
			
			List<Item> list = locationItems.get(item.toLowerCase());
			Item getItem = list.remove(0);
			
			if(list.isEmpty()) locationItems.remove(item);
		
		return getItem;
	}
	
	public void actionObject(NonItem object, Actions action, Entity user) {
		locationObjects.get(object.getObjectType().toLowerCase()).objectOccupied(action, user);
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
			
	public int itemQuant(String itemType) {
		return locationItems.get(itemType.toLowerCase()).size();
	}
	
	/**
	 * @param item - item to see if it is an Item.
	 * @return true if <item> is an item and false if not.
	 */
	private boolean itsAnItem(String item) {
		return locationObjects.get(item.toLowerCase())==null;
	}
	
	/**
	 * @param object - object to see if it is a nonItem.
	 * @return true if <item> is a nonItem and false if not.
	 */
	private boolean itsAnNonItem(String object) {
		return locationItems.get(object.toLowerCase())==null;
	}

	
}
	
