package gameSystem;
import java.util.Timer;
import java.util.TimerTask;

import items.Item;
import miniGames.PCgame;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GameSystem {

	private Player player;
	private InventoryIterator ivenIterator;
	private LocalDate startDate;
	private LocationCollection locations;
	private PCgame miniGame;
	private static String timePlayed, previousObject;
	private static boolean start, exit, descriptionsMode;
	private static int addAmount, timePlayedMinutes, timePlayedHours;
	
	// Action Objects
	private String sittingObjects[] = {"Chair", "Armchair","Bed"};
	private String turnOnObjects[] = {"Computer"};
	private String itemsInGame[] = {"Steak" ,"Bottle", "Sword", "Bow", "Potion", "Arrow", "Coin", "Key", "Book", "Stone", "Letter", "Ring", "Shield"};
	
	private static final int STACK_ITEMS = 100, BAG_FULL = 10, COIN_PURSE_FULL = 1000000;
	
	public GameSystem() {
		start = false;
		exit = false;
		descriptionsMode = false;
		addAmount = 0;
		timePlayedMinutes = 0;
		timePlayedHours = 0;
		startDate = LocalDate.now();
		locations = new LocationCollection();
		previousObject = "";
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
	
	public boolean isStartOn() {
		return start;
	}
	
	public boolean isExitOn() {
		return exit;
	}
	
	public boolean isInDescriptionMode() {
		return descriptionsMode;
	}
	
	public void start(String name) {
	
		start = true;
		player = new Player(name);
		timer.scheduleAtFixedRate(taskMinutes, 60000, 60000);
	}
	
	/*
	public boolean existSaveFile(String save) {
		try {
			FileReader readSave	= new FileReader(save);
		} catch(FileNotFoundException e) {
			haveSave = false;
		}
		return haveSave;
	}*/
	
	public String timePlayed() {
		String strTimePlayedMinutes;
		if(timePlayedMinutes<10)
			strTimePlayedMinutes = "0" + timePlayedMinutes;
		else
			strTimePlayedMinutes = Integer.toString(timePlayedMinutes);
		timePlayed = timePlayedHours+":"+strTimePlayedMinutes;
		return timePlayed;
	}
	
	public String getPlayerLocation() {
		return player.getLocation();
	}
	
	public int isInFirstLocations() {
		if(getPlayerLocation().equals("BedRoom"))
			return 0;
		else if(getPlayerLocation().equals("NoWhere"))
			return 1;
		return -1;
	}
	
	public void setLocation(String location) {
		player.setLocation(location);
	}
	
	public void goLocation(String direction) {
		String location="";
		
		switch(getPlayerLocation()) {
			case "Spreech Forest":
				switch(direction) {
					case "n":
						location = "Frosty Hills";
						break;
					case "w":
						location = "Spreech Village";
						break;
					case "e":
						location = "Spreech Landscape";
						break;
				}
				break;
			case "Spreech Village":
				switch(direction) {
					case "n":
						location = "";
						break;
					case "s":
						location = "";               // PUT MORE NEW LOCATIONS
						break;
					case "w":
						location = "";
						break;
					case "e":
						location = "Spreech Forest";
						break;
				}
				break;
			case "Spreech Landscape":
				switch(direction) {
					case "w":
						location = "Spreech Forest";
						break;
				}
				break;
			case "Frosty Hills":
				switch(direction) {
					case "n":
						location = "Frosty Mountain";
						break;
					case "s":
						location = "Spreech Forest";
						break;
				}
				break;
			case "Frosty Mountain":
				switch(direction) {
					case "n":
						location = "";  // PUT MORE NEW LOCATIONS
						break;
					case "s":
						location = "Frosty Hills";
						break;
				}
				break;
		}
		if(location!="")
			player.setLocation(location);
	}
	
	public int getState() {
		return player.getState();
	}
	
	public String getStartDate() {
		return startDate.format(format);
	}
	
	public void exit() {
		exit = true;
	}
	
	public void sit() {
		player.sit();
	}
	
	public void stand() {
		player.stand();
	}
	
	public void lay() {
		player.lay();
	}
	
	public boolean hasObjectInLocation(String object) {	
		return locations.hasObjectInLocation(object, getPlayerLocation());
	}
	
	public String getPreviousObject() {
		return previousObject;
	}
	
	public void setPreviousObject(String object) {
		previousObject = object;
	}
	
	public void turnOnOff(String object) {
		locations.turnOnOff(object, getPlayerLocation());
	}
	
	public String getComputer() {
		return locations.getComputer(getPlayerLocation());
	}
	
	public void getMoney(int money) {
		player.incBalance(money);
	}
	
	public void descriptionMode() {
		if(isInDescriptionMode())
			descriptionsMode = false;
		else
			descriptionsMode = true;
	}
	
	public int itemsGathered() {
		return player.getItemsGathered();
	}
	
	public int playerBalance() {
		return player.getBalance();
	}
	
	public boolean enoughBalance(int money) {
		return playerBalance() > money;
	}
	
	public void incBalance() {
		int quantity = 1, futureBalance = playerBalance();                
		
		addAmount = quantity*100;
		futureBalance += addAmount;
		
		if(futureBalance < COIN_PURSE_FULL) {
			player.incBalance(addAmount);
		} else {
			addAmount = COIN_PURSE_FULL-playerBalance();
			player.incBalance(addAmount);
		}
	}
	
	public void decBalance() {
		int quantity = 1, futureBalance = playerBalance();                 
		
		addAmount = quantity*100;
		futureBalance += addAmount;
		
		if(futureBalance < COIN_PURSE_FULL) {
			player.decBalance(addAmount);
		} else {
			addAmount = COIN_PURSE_FULL-playerBalance();
			player.decBalance(addAmount);
		}
	}
	
	public boolean isBagFull() {
		return getBagSlots() == BAG_FULL;
	}
	
	public int getAddAmount() {
		return addAmount;
	}
	
	public boolean itsMoney(String itemName) {
		return itemName.equals("Coin");
	}
	
	public boolean isFullCoinPurse() {
		return playerBalance() == COIN_PURSE_FULL;
	}
	
	public boolean isEmptyCoinPurse() {
		return playerBalance() == 0;
	}
	
	public boolean isStakedItem(String itemName) {                    // REMAKE THIS
		return getBagItemQuantity(itemName) == STACK_ITEMS;
	}
	
	public int getFinalQuantity(String itemName, int quantity) {
		int futureItemQuantity;
		
		if(getLocationQuantity(itemName) < quantity)
			quantity = getLocationQuantity(itemName);
		
		futureItemQuantity = getBagItemQuantity(itemName)+quantity;
		
		if(futureItemQuantity > STACK_ITEMS)
			quantity = STACK_ITEMS-getBagItemQuantity(itemName);
		return quantity;
	}
	
	public void getItem(String itemName, int quantity) {
		
		quantity = getFinalQuantity(itemName, quantity);
		
		if(getBagItemQuantity(itemName) > 0)
			player.incQuantity(itemName, quantity);
		else
			player.addItem(getLocationItem(itemName, quantity));
		
		locations.getLocation(getPlayerLocation()).removeItem(itemName, quantity);
	}
	
	public int getLocationQuantity(String itemName) {
		return locations.getQuantity(itemName, getPlayerLocation());
	}
	
	public Item getLocationItem(String itemName, int quantity) {
		Item item = locations.getLocation(getPlayerLocation()).getItem(itemName);
		item.setQuantity(quantity);
		return item;
	}
	
	public Item getItemPlayer(String itemName, int quantity) {
		Item item = player.getItem(itemName);
		item.setQuantity(quantity);
		return item;
	}
	
	public void dropItem(String itemName, int quantity) {
		locations.getLocation(getPlayerLocation()).addItem(getItemPlayer(itemName, quantity), itemName, quantity);
		player.dropItem(itemName, quantity);
	}
	
	public int getDropedItems() {
		return player.getDropedItems();
	}
	
	public InventoryIterator createInventoryIterator() {
		ivenIterator = new InventoryIterator(player.getBagList(), getBagSlots());
		return ivenIterator;
	}
	
	public String getPlayerName() {
		return player.getName();
	}
	
	public int getBagSlots() {
		return player.getBagSlots();
	}
	
	public int getPlayesHp() {
		return player.getHp();
	}
	
	public String getBagItemName(String itemName) {
		return player.getItemName(itemName);
	}
	public int getBagItemQuantity(String itemName) {
		return player.getQuantity(itemName);
	}
	
	public String multiplier(int number, String string) {
		String result="";
		for(int i=0; i < number;i++)
			result += string;
		return result;
	}
	
	public boolean universalCanString(String object, String action[]) {
		
		boolean can = false;
		for(int i=0; i < action.length && !can; i++) {
			if(object.equalsIgnoreCase(action[i]))
				can = true;
		}
		return can;
	}
	
	public boolean canSit(String object) {
		return universalCanString(object, sittingObjects);
	}
	
	public boolean canTurnOn(String object) {
		return universalCanString(object, turnOnObjects);
	}
	
	public boolean hasItemInGame(String object) {
		return universalCanString(object, itemsInGame);
	}
	
	public void newGame(int range, int trys) {
		miniGame = new PCgame(range, trys);
	}
	
	public void decTryNum() {
		miniGame.decTrys();
	}
	
	public boolean isGreaterThan(int guess) {
		return miniGame.isGreaterThan(guess);
	}
	
	public boolean playerWin(int guess) {
		return miniGame.playerWin(guess);
	}
	
	public int getTryNum() {
		return miniGame.getTrys();
	}
	
	public boolean noTry() {
		return miniGame.noTry();
	}
	
	public int getRandomNum() {
		return miniGame.getRandomNum();
	}
}
