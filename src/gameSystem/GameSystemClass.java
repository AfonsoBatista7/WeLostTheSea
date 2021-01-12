package gameSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import entity.*;
import gameSystem.exceptions.*;
import locations.*;
import locations.exceptions.*;
import objects.*;

public class GameSystemClass implements GameSystem {
	
	private List<Location> map;
	private Player player;
	private String timePlayed;
	private LocalDate startDate;
	private boolean descriptionsMode;
	private int timePlayedMinutes, timePlayedHours;
	
	public GameSystemClass() {
		map = new ArrayList<Location>(Arrays.asList(new BedRoom(), new NoWhere()));
		
		descriptionsMode = true;
		startDate = LocalDate.now();
	}
	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	Timer timer = new Timer();
	
	TimerTask taskMinutes = new TimerTask() {
		public void run() {
			if(timePlayedMinutes<59)
				timePlayedMinutes++;
			else {
				timePlayedMinutes=0;
				timePlayedHours++;
			}	
		}
	};
	
	public String getStartDate() {
		return startDate.format(format);
	} 
	
	public void startTimer() {
		timer.scheduleAtFixedRate(taskMinutes, 60000, 60000);
	}
	
	public void newPlayer(String name) {
		if(name.length()>22) throw new TooLongNameException();
		player = new PlayerClass(name, map.get(0));
	}
	
	public String timePlayed() {
		String strTimePlayedMinutes;
		if(timePlayedMinutes<10)
			strTimePlayedMinutes = "0" + timePlayedMinutes;
		else
			strTimePlayedMinutes = Integer.toString(timePlayedMinutes);
		timePlayed = timePlayedHours+":"+strTimePlayedMinutes;
		return timePlayed;
	}
	
	public void teleportToLocation(Location location) {
		player.setLocation(location);
	}
	
	public Iterator<String> splitItems(String items) {
		String str[] = items.split(" ");
		List<String> itemsType = new LinkedList<String>(); 
		
		for(String item: str) itemsType.add(item);
		
		return itemsType.iterator();
	}
	
	public void getItem(String item) {
		Item getItem = getCurrentLocation().getItem(item);
		player.getItem(getItem);
	}
	
	public void dropItem(String item) {
		Item getItem = player.dropItem(item);
		getCurrentLocation().dropItem(getItem);
	}
	
	public String getLocationName() {
		return getCurrentLocation().getLocationName();
	}
	
	public String getLocationDescription() {
		if(isInDescriptionMode()) return getCurrentLocation().getBigDescription();
		return getCurrentLocation().getSmallDescription();
	}
	
	public Iterator<ArrayList<Item>> listBag() {
		return player.listBag();
	}
	
	public Location getCurrentLocation() {
		return player.getLocation();
	}
	
	public String getPlayerName() {
		return player.getName();
	}
	
	public int getQuantity(String item) {
		return player.getQuantity(toSearch(item));
	}
	
	/**
	 * @param object - object name.
	 * @return the object name with a capital letter.
	 */
	private String toSearch(String object) {
		return object.toString().substring(0,1).toUpperCase() + object.toString().substring(1).toLowerCase();
	}
	
	public Iterator<LinkedList<Item>> allLocationItems() {
		return getCurrentLocation().allItems();
		
	}
	
	public Iterator<String> allLocationItemTypes() {
		return getCurrentLocation().allItemTypes();
	}
	
	public Iterator<NonItem> allLocationObjects() {
		return getCurrentLocation().allObjects();
	}
	
	public int getLocationItemQuant(String itemType) {
		return getCurrentLocation().itemQuant(toSearch(itemType));
	}
	
	public void setLocation(Entity entity, Location newLocation) {
		entity.setLocation(newLocation);
	}
	
	public void movePlayer(Directions dir) {
		moveTo(player, dir);
	}
	
	public boolean isInDescriptionMode() {
		return descriptionsMode;
	}
	
	public void descriptionMode() {
		descriptionsMode = !descriptionsMode;
	}
	
	public void moveTo(Entity entity, Directions dir) {
		int exit = Directions.NO_EXIT;
		Location loc = entity.getLocation();
		switch(dir) {
		case NORTH:
			exit = loc.getNorthLocation();
			break;
		case EAST:
			exit = loc.getEastLocation();
			break;
		case WEST:
			exit = loc.getWestLocation();
			break;
		case SOUTH:
			exit = loc.getSouthLocation();
			break;
		}
		if(exit==Directions.NO_EXIT) throw new NoExitException();
		
		if(entity.usingObject()) {
			entity.noLongerUsing();
			throw new WalkUsingObjectException();
		}
		
		setLocation(entity, map.get(exit));
	}
	
	/**
	 * @param entity - The entity.
	 * @return the total current money the <entity> have.
	 */
	private double getBalance(Entity entity) {
		return entity.getBalance();
	}
	
	public double getPlayerBalance() {
		return getBalance(player);
	}
	
	public double buy(String item, String seller) {
		Entity entSeller = player.getLocation().getEntity(seller);	
		return transactionSellBuy(item, player, entSeller);
	}
	
	public double sell(String item, String buyer) {
		Entity entBuyer = player.getLocation().getEntity(buyer);
		return transactionSellBuy(item, entBuyer, player);
	}

	
	/**
	 * @param item
	 * @param buyer
	 * @param seller
	 * @return
	 */
	private double transactionSellBuy(String item, Entity buyer, Entity seller ) {
		Item sellItem = seller.dropItem(item);
		double price = getItemTotalPrice(seller.getSellTax(),sellItem.getItemPrice());
		
		buyer.buy(price); seller.sell(price);									
		buyer.getItem(sellItem);
		return price;
	}
	
	public double getItemTotalPrice(double tax, double itemPrice) {
		return tax*itemPrice;
	}
	
	public int itemsGathered() {
		return player.itemsGathered();
	}
	
	public void action(Propertys property, String object) {
		NonItem nonItem = getCurrentLocation().getObject(object);
		if(!sameProperty(property, nonItem)) throw new DiferentPropertysException(); 
		
		switch(property) {
			case USE:
				
				break;
			case SIT:
				player.action(Actions.SIT, nonItem);
				break;
			case LAY:
				player.action(Actions.LAY, nonItem);
				break;
			case PUT:
				
				break;
				
		}
	}
	
	public boolean sameProperty(Propertys property, NonItem object) {
		return object.getObjectProperty().equals(property);
	}
	
	public void exit() {
		timer.cancel();
	}
}
