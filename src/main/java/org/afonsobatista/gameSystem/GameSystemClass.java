package org.afonsobatista.gameSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.afonsobatista.entity.*;
import org.afonsobatista.entity.entities.Player;
import org.afonsobatista.entity.entities.PlayerClass;
import org.afonsobatista.gameSystem.exceptions.*;
import org.afonsobatista.locations.*;
import org.afonsobatista.locations.exceptions.*;
import org.afonsobatista.locations.realLocations.*;
import org.afonsobatista.objects.*;
import org.afonsobatista.objects.nonItems.Computer;

public class GameSystemClass implements GameSystem, Serializable {
	
	
	private static final long serialVersionUID = -3879778870212962205L;
	
	private List<Location> map;
	private Player player;
	private String timePlayed;
	private boolean descriptionsMode, gameHasStarted;
	private int timePlayedMinutes, timePlayedHours;
	private LocalDate startDate;
	transient private Timer timer;
	transient private TimerTask taskMinutes;
	
	public GameSystemClass() {
		map = new ArrayList<Location>(Arrays.asList(new Dream(), new BedRoom(), new NoWhere()));
		player = new PlayerClass(map.get(Locations.DREAM.getValue()));
		
		gameHasStarted = false;
		descriptionsMode = true;
		startDate = LocalDate.now();
	}
	
	public String getStartDate() {
		return startDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	} 
	
	public void startTimer() {
		timer = new Timer();
		taskMinutes = new TimerTask() {
			public void run() {
				if(timePlayedMinutes<59)
					timePlayedMinutes++;
				else {
					timePlayedMinutes=0;
					timePlayedHours++;
				}	
			}
		};
		timer.scheduleAtFixedRate(taskMinutes, 60000, 60000);
	}
	
	public void newPlayer(String name) {
		if(name.length()>22) throw new TooLongNameException();
		player.setName(name);
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
	
	public void setPlayerLocation(int location) {
		player.setLocation(map.get(location));
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
	
	public Iterator<Programs> getComputerPrograms() {
		return getComputer().getPrograms();
	}
	
	private Computer getComputer() {
		return ((Computer) getCurrentLocation().getObject("Computer"));
	}
	
	public String getTxt() {
		return getComputer().getTxt();
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
	
	public int getEntityQuantity(String entity, String item) {
		
		return player.getLocation().getEntity(entity).getQuantity(toSearch(item));
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
		
		if(entity.sittingObject()) {
			entity.noLongerSitting();
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
	
	public double buy(String item, String seller, int quantity) {
		Entity entSeller = player.getLocation().getEntity(seller);	
		return transactionSellBuy(item, player, entSeller, quantity);
	}
	
	public double sell(String item, String buyer, int quantity) {
		Entity entBuyer = player.getLocation().getEntity(buyer);
		return transactionSellBuy(item, entBuyer, player, quantity);
	}

	
	/**
	 * @param item
	 * @param buyer
	 * @param seller
	 * @return
	 */
	private double transactionSellBuy(String item, Entity buyer, Entity seller , int quantity) {
		if(quantity<1) throw new QuantityErrorException();
		int itemQuantity = seller.getQuantity(toSearch(item)),
			trueQuantity;
		Item sellItem=seller.dropItem(item);
		for(trueQuantity=1;trueQuantity<quantity && trueQuantity<itemQuantity;trueQuantity++)
			seller.dropItem(item);
		double price = getItemTotalPrice(seller.getSellTax(),sellItem.getItemPrice(), trueQuantity);
		
		buyer.buy(price); seller.sell(price);	
		for(int i=0; i<trueQuantity;i++)
			buyer.getItem(sellItem);
		return price;
	}
	
	public double getItemTotalPrice(double tax, double itemPrice, int quantity) {
		return tax*itemPrice*quantity;
	}
	
	public int itemsGathered() {
		return player.itemsGathered();
	}
	
	public void action(Propertys property, String object) {
		NonItem nonItem=null;
		if(object!=null) {	
			nonItem = getCurrentLocation().getObject(object);
			if(!sameProperty(property, nonItem)) throw new DiferentPropertysException(); 
		}
		
		switch(property) {
			case USE:
				player.action(Actions.USE, nonItem);
				break;
			case SIT:
				player.action(Actions.SIT, nonItem);
				break;
			case LAY:
				player.action(Actions.LAY, nonItem);
				break;
			case PUT:
				player.action(Actions.PUT, nonItem);
				break;
			case STAND:
				player.noLongerSitting();
				break;
				
		}
	}
	
	public boolean isUsing(String object) {
		return player.isUsingObject(getCurrentLocation().getObject(object));
	}
	
	private boolean sameProperty(Propertys property, NonItem object) {
		for(Propertys oProperty : object.getObjectProperty())
			if(property.equals(oProperty)) return true;
		return false;
	}
	
	public void startGame() {
		gameHasStarted = true;
		startTimer();
	}
	
	public boolean hasStarted() {
		return gameHasStarted;
	}
	
	private File createSaveFolder() {
		File folder = new File("./saves");
		if(!folder.exists()) folder.mkdir();
		return folder;
	}
	
	public ObjectOutputStream save() throws Exception {
		createSaveFolder();
		exit();
		
		FileOutputStream fos = new FileOutputStream("./saves/"+getPlayerName()+".sav");
		return new ObjectOutputStream(fos);	
	}
	
	public ObjectInputStream load(File file) throws Exception {
		return new ObjectInputStream(new FileInputStream(file));
	}
	
	public File[] getSaveFiles() {
		return createSaveFolder().listFiles();
	}
	
	public void exit() {
		if(gameHasStarted) timer.cancel();
		gameHasStarted=false;
	}
}
