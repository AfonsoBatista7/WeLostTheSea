import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javax.xml.ws.Response;

import entity.exceptions.*;
import gameSystem.*;
import gameSystem.exceptions.*;
import locations.exceptions.*;
import objects.*;

/**
 * Main Program.
 * @author Afonso Batista
 */
public class Main {
	/* Other Constants */
	private static final String YES = "YES", NO = "NO";
	private static final String YOUR_BAG = "\nYour Bag:";
	private static final int MAIN_SPEED = 65;
	
	/* Game lines */
	private static final String 
		START_NEW_PLAYER = "\n[SAILON] - And yours is...\n\n> ",                                     //TODO Then make a dialogue system
		START_IS_THAT_YOUR_NAME = "\n[SAILON] - Hi %s is that realy your name?\n Yes or No?\n\n> ",               //TODO I want to have an easter egg that if the playes choses the name Sailon he gets a custom message.
		ITEM_QUANTITY_QUESTION_SELL = "\nHow much items do you want to sell?: ",
		ITEM_QUANTITY_QUESTION_BUY = "\nnHow much items do you want to buy?:",
		GAME_SAVE = "\n\tYour Adventure Has been Saved :D.\n",
		GAME_LOADED = "\n\t---Game loaded---\n",
		AFTER_LOAD = "Back where you left off\n\n",
		EXIT_SAVE = "\nDo you want to save your game progress?\n\tYes or No?\n\n> ";
			
	
	
	/* Success Constants */
	private static final String 
		SUCCESS_MENU = "\n%s* We Lost The Sea *%s\n%s( Menu )%s\n**%s**\n*%s*\n%sStart\n%sInformation\n%sCredits\n%sExit\n%s(*Test*)\n*%s*\n**%s**\n\n",
		SUCCESS_INF = "\nWe Lost The Sea is a Text Adventure type Game, you just need to type what you want to do and create your own journey.\n"
						+ "\nAny command mismatch you can type ( Help ) to print a list of all the commands in game.\n"
						+ "\nYou can walk for any direction you want (if there aren't some type of object blocking your way), such as ( 'N' - North 'S' - South 'E' - East 'W' - West ).\n"
						+ "\nAnd a lot more to discover... Good luck Adventurer!!\n\n",
		SUCCESS_CREDITS = "\nWE LOST THE SEE\nA Text Adventure Game\nBy Afonso Batista ( 2019-2020 ) \nThanks for playing this game!\n\n",
		SUCCESS_DISCRIPTION_MODE_ON = "\nYour Adventure is now in description mode, which always gives bigger descriptions of locations.\n\n",
		SUCCESS_DESCRIPTION_MODE_OFF = "\nYour Adventure is no longer in description mode.\n\n",
		SUCCESS_MINIGAME = "\nInsert numbers between 0 and %d\nYou have %s guesses\n",
		SUCCESS_MYNAME = "\nYour Name is %s don't you remember ?\n\n",
		SUCCESS_GET_1 = "\nTaken.",
		SUCCESS_GET_2 = "\nYou have put %s in your Bag.",
		SUCCESS_GET_3 = "\nNice catch, %s!",
		SUCCESS_GET_4 = "\nYou get hit by a wave of laziness, causing you to refuse to pick up the item...\n",
		SUCCESS_DROP_1 = "\nYou have droped the item.",
		SUCCESS_DROP_2 = "\nNow %s are droped in the middle of %s.",
		SUCCESS_DROP_3 = "\nYou throw away as far as you can %s!",
		SUCCESS_DROP_4 = "\nBetween wind sounds %s says :\n\"hmmm now I fell lighter...\"",
		SUCCESS_ITEM_QUANTITY = "\nYou have %d of that item\n\n",
		SUCCESS_WALKING = "\nYou walked a couple of steps to the %s.\n",
		SUCCESS_SIT = "\nYou sat on a %s.\n\n",
		SUCCESS_LAY = "\nYou Lay down in %s.\n\n",
		SUCCESS_STAND = "\nYou stand up.\n",
		SUCCESS_PUT = "\nYou have put %s on %s.\n\n",
		SUCCESS_CLOSE = "\nYou have closed %s.\n\n",
		SUCCESS_PLAYER_MONEY = "\nYou have %.2f$ in your pocket.\n\n",
		SUCCESS_SELL_ITEM = "\nYou have sold a %s to %s and earn %.2f$ in the transaction.\n\n",
		SUCCESS_BUY_ITEM = "\nYou have bought a %s to %s and paid %.2f$ in the transaction.\n\n",
		SUCCESS_EXIT = "Leaving...";
	
	/* Error Constants*/
	
	private static final String 
		ERROR_INVALID_COMMAND = "\nHoo man! That must be an encrypted type of language I don't understand!\n\n",
		ERROR_TOO_LONG_NAME = "\n[SAILON] - Wooow! Looks like your name is to big for me to handle... You are definitively trying to prank me... Try a smaller one. (<22)\n",
		ERROR_OBJECT_NOT_IN_LOCATION = "\n%s doesn't exist in this location...",
		ERROR_NOT_AN_ITEM = "\nYou tried realy hard but, you couldn't put a %s in your bag...",
		ERROR_NO_SPACE = "\nYou can't put these item in your bag while it's full.\nYou need to drop something.",
		ERROR_STAKED_ITEM = "\nYou can't put more %ss in your bag.",
		ERROR_EMPTY_BAG = " * Empty *\n",
		ERROR_ITEM_NOT_IN_BAG = "\nYou don't have %s on your bag.",
		ERROR_ITEM_NOT_IN_BAG_TRANSACTION = "\n%s don't have %s in bag.\n\n",
	 	ERROR_NO_ITEMS_IN_LOCATION = "\nThere's no items in this location.\n",
	 	ERROR_ITS_AN_ITEM = "\nThats not an object, %s is an item.\n\n",
	 	ERROR_DIFERENT_PROPERTY = "\nYou can't %s in this object.\n\n",
	 	ERROR_ALREADY_DOING_THAT = "\n%s is already doing that.\n\n",
	 	ERROR_NO_EXIT = "\nYou can't go that way.\n\n",
	 	ERROR_WALK_OBJECT ="\nYou stop what you're doing and,",
	 	ERROR_SCANNER_NUM = "\nTry to insert a number in quantity.\n\n",
		ERROR_QUANTITY = "\nYou need to insert a quantity >= 1\n\n",
		ERROR_ALREADY_STARTED = "\nYou can't do this command now, because you already started your game or you haven't started yet\n\n",
		ERROR_NO_SAVES = "\t* You have no saves yet *\n",
		ERROR_NOT_NUMBER_LOAD = "\nWhile chosing your save file make sure you type a number.\n\n",
		ERROR_EXCEPTION_PROBLEM = "A problem has occurred!\n%s: %s\n";

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		GameSystem game = new GameSystemClass();
		GameSystem newSave;
		Command cm;
		printMenu();
		do{
			System.out.print("> ");
			cm = getCommand(in);
			newSave = exeOption(in, game, cm);
			if(newSave!=null) game = newSave;
		} while(!cm.equals(Command.EXIT));
		in.close();
	}
	
	private enum Command {
		
		START("- Starts the game."), INF("- Give you some information about the all game."),
		LOCATION("- Tells you the name of your location."), DESC("- Description mode gives bigger descriptions of locations."),
		W("- Walk to the West."), E("- Walk to the East."), N("- Walk to the North."), S("- Walk to the South."),
		BAG("- Opens your bag."), STATUS("- Gives you a lot of information about your game play."), 
		GET("<item name> - Catch a floor item."), DROP("<item name> - Puts an item at the floor."),
		QUANT("<item name> - How much of an item do you have."), MYNAME("- Tells you, your name."), 
		MONEY("- How much money do you have."), SIT("<object name> - You sit on an object."), 
		LAY("<object name> - You lay on an object."), STAND("- You stand up if you're down."), PUT("<object name> <second object name> - Put an object above a second object."), 
		TURN("<object name> - Turns an object on or off."), CLOSE("<object name> - Close an object."),
		CLICK("<program name> - Clicks on a program."), ITEMS("- Tells you every item you can encounter at the location you in."),
		OBJECTS("- Tells you every object you can find at the location yuor in."), SELL("<item name> <person name> - Sells an item to another person."), 
		BUY("<person name> - First tells you all the seller have to sell and then you can buy from him."), CREDITS("- Shows the credits of the game."), 
		HELP("- Shows the available commands"), SAVE("- Saves your game state"), LOAD("- Loads a old save state"),EXIT("- Ends your adventure until you come back."), TEST("- Just for testing..."), UNKNOWN("");
		
		private String description;

		Command (String description) { this.description = description; }
		/**
		 * @return The description of the command.
		 */
		public String getDescription() { return this.description; }
		
	};
	
	/**
	 * @param in - Scanner
	 * @return The user input command.
	 */
	private static Command getCommand(Scanner in) {
		try {
			return Command.valueOf(in.next().toUpperCase());
		} catch(IllegalArgumentException e) {
			return Command.UNKNOWN;
		}
	}

	/**
	 * Execute one available option.
	 * @param in - Scanner.
	 * @param game - GameSystem
	 * @param option - the user input.
	 */
	private static GameSystem exeOption(Scanner in, GameSystem game, Command cm) {
		switch(cm) {
			case START:
				start(in,game);
				break;
			case TEST:
				test(in,game);
				break;
			case INF:
				information();
				break;
			case CREDITS:
				credits();
				break;
			case LOCATION:
				location(game);
				break;
			case GET:
				getItem(in, game);
				break;
			case DROP:
				dropItem(in, game);
				break;
			case DESC:
				fullDescriptions(game);
				break;
			case BAG:
				bagList(game);
				break;
			case QUANT:
				howMuchItems(in, game);
				break;
			case MONEY:
				playerMoney(game);
				break;
			case STATUS:
				playerStatus(game);
				break;
			case MYNAME:
				myName(game);
				break;
			case W:
				goDirection(game, Directions.WEST);
				break;
			case E:
				goDirection(game, Directions.EAST);
				break;
			case N:
				goDirection(game, Directions.NORTH);
				break;
			case S:
				goDirection(game, Directions.SOUTH);
				break;
			case SIT:
				action(in, game, Propertys.SIT);
				break;
			case STAND:
				stand(game);
				break;
			case LAY:
				action(in, game, Propertys.LAY);
				break;
			case PUT:
				action(in, game, Propertys.PUT);
				break;
			case ITEMS:
				locationItems(game);
				break;
			case OBJECTS:
				locationObjects(game);
				break;
			case SELL:
				transaction(in, game, Command.SELL);
				break;
			case BUY:
				transaction(in, game, Command.BUY);
				break;
			case HELP:
				help();
				break;
			case SAVE:
				save(game);
				break;
			case LOAD:
				game = load(in);
				break;
			case EXIT:
				exit(in, game);
				break;
			default:
				defaultError(in);
				break;
		}
		return game;
	}
	
	public static void test(Scanner in, GameSystem game) {
		if(!game.hasStarted()) {
			game.newPlayer("Afonso");
			game.startGame();
			game.setPlayerLocation(Locations.BEDROOM.getValue());
			System.out.print("\n");
		} else printString(ERROR_ALREADY_STARTED, MAIN_SPEED);
	}
	
	/**
	 * @param number - number of times you want to multiply.
	 * @param string - String you want to multiply.
	 * @return the input string multiplied by <number> times.
	 */
	public static String multiplier(int number, String string) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < number;i++)
			sb.append(string);
		return sb.toString();
	}
	
	/**
	 * Prints a <text> at a certain <speed>.
	 * @param text - String to print.
	 * @param speed - Speed to print the string in milliseconds.
	 */
	private static void printString(String text, int speed) {
		int counter=0;
		for(int i = 0; i < text.length(); i++) {
			
			char character = text.charAt(i);
			counter++;
			
				
			System.out.printf("%c", character);                           
		    if(Character.compare('\n',character)==0) counter=0;
		    if(counter>=60 && text.length()-i>50 && Character.compare(' ',character)==0) {
		    	counter=0; System.out.println("");
		    }
		    
		    coolDown(speed);
	
		}
	}
	
	/**
	 * Makes a cooldown of <time> seconds between prints.
	 * @param time - coolDown time.
	 */
	private static void coolDown(int time) {
		try{
			Thread.sleep(time);
	    } catch(InterruptedException ex){
	        Thread.currentThread().interrupt();
	    }
	}
	
	private static File createSaveFolder() {
		File folder = new File("./saves");
		if(!folder.exists()) folder.mkdir();
		return folder;
	}
	
	private static void save(GameSystem game) {
		if(game.hasStarted()) {  
			try {
				createSaveFolder();
				
				game.exit();
				
				FileOutputStream fos = new FileOutputStream("./saves/"+game.getPlayerName()+".sav");
				ObjectOutputStream oos = new ObjectOutputStream(fos);												
				
				oos.writeObject(game);
				oos.flush();
				oos.close();
				
				System.out.println(GAME_SAVE);                                       //METER METODO NA CLASSE TOPO
				
				game.startGame();
			} catch(Exception e) {
				printString(String.format(ERROR_EXCEPTION_PROBLEM, e.getClass(), e.getMessage()), MAIN_SPEED);
			}
		} else printString(ERROR_ALREADY_STARTED, MAIN_SPEED);
	}
	
	private static GameSystem load(Scanner in) {
		try {
			File folder = createSaveFolder();
			
			File[] files = folder.listFiles();
			System.out.println("\nSaves:\n");
			
			if(files.length==0) System.out.println(ERROR_NO_SAVES);
			
			
			else {
				
				for(int i=1; i<files.length+1; i++) {
					System.out.printf("%d. %s\n", i, files[i-1].getName());
				}
				
				int num;
				do {
					printString("\nChose your save: ", MAIN_SPEED);
					num = in.nextInt();
				} while(num>files.length || num<=0);
			
				FileInputStream fis = new FileInputStream(files[num-1]);
				ObjectInputStream ois = new ObjectInputStream(fis);
				GameSystem game = (GameSystem) ois.readObject();
				ois.close();
				System.out.println(GAME_LOADED);
				printString(AFTER_LOAD, MAIN_SPEED);
				game.startGame();
				return game;
			}
		} catch(InputMismatchException e) {
			in.nextLine();
			printString(ERROR_NOT_NUMBER_LOAD,MAIN_SPEED);
			
		} catch(Exception e) {
			printString(String.format(ERROR_EXCEPTION_PROBLEM, e.getClass(), e.getMessage()), MAIN_SPEED);
		}
		return null;
	}
	
	/**
	 * Prints the game Menu.
	 */
	private static void printMenu() {
		System.out.printf(SUCCESS_MENU
				, multiplier(15, " "), multiplier(13, " "), multiplier(20, " ")
				, multiplier(20, " "), multiplier(45, "-"), multiplier(47, " ")
				, multiplier(22, " "), multiplier(19, " "), multiplier(21, " ")
				, multiplier(22, " "), multiplier(20, " "), multiplier(47, " "), multiplier(45,"-"));
	}
	
	/**
	 * Prints all the available comments
	 */
	private static void help() {
		System.out.print(multiplier(66, "=")+"\n");
		for(Command cm : Command.values())
			if(!cm.equals(Command.UNKNOWN)) {
				String command = cm.toString().substring(0,1).toUpperCase() + cm.toString().substring(1).toLowerCase();
				System.out.printf("%s %s\n", command, cm.getDescription());
			}
		System.out.print(multiplier(66, "=")+"\n\n");
	}
	
	/**
	 * Starts the game.
	 * @param in - Scanner
	 * @param game - GameSystem
	 */
	private static void start(Scanner in, GameSystem game) {
		if(!game.hasStarted()) {
			printString("\n...",500); coolDown(500); printString(" ...",500); coolDown(500); printString(" ...\n",500);
			printString("\nWhere am I?\n",MAIN_SPEED*2); coolDown(500);
			printString("\n*You look around to see where you are.*\n\n", MAIN_SPEED*2); coolDown(500);
			locationInf(game); coolDown(500);
			System.out.print("[ PRESS ENTER TO CONTINUE ]"); in.nextLine(); in.nextLine();
			printString("\nSuddenly! ",60); coolDown(600); printString("A realy old man, with a big grey beard, that seems to be a master of wisdom, approaches at you...\n", MAIN_SPEED);
			coolDown(500);
			printString("\n[???] - Do you mind if I sit next to you young man?\n\n> ", MAIN_SPEED*2);
			
			newPlayer(in, game);
			game.startGame();
			printString(String.format("", game.getPlayerName()), MAIN_SPEED);  //TODO START SPEECH
			game.setPlayerLocation(Locations.BEDROOM.getValue());
			System.out.print("[ PRESS ENTER TO CONTINUE ]"); in.nextLine();
			enterNewLocation(game);
			printString("You are standing in the middle of your Room...\n\n", MAIN_SPEED);
			 
		} else printString(ERROR_ALREADY_STARTED, MAIN_SPEED);
		
		 
	}
	
	private static void chooseName(GameSystem game, Scanner in) {
		String option, name;
		File[] files = createSaveFolder().listFiles();
		do {
			printString(START_NEW_PLAYER, MAIN_SPEED);
			name = in.next()+in.nextLine();
			printString(String.format(START_IS_THAT_YOUR_NAME, name), MAIN_SPEED);
			option = in.next().toUpperCase(); in.nextLine();
		} while(option.equals(NO));
		try {
			if(!option.equals(YES)) throw new InvalidOptionException();
			
			
			for(File file: files)
				
				if(file.getName().toUpperCase().equals((name+".sav").toUpperCase())) throw new NameAlreadyExistsException();
				
			game.newPlayer(name);
		} catch(TooLongNameException e) {
			printString(ERROR_TOO_LONG_NAME, MAIN_SPEED);
			chooseName(game, in);
		} catch(InvalidOptionException e) {
			printString("\n[SAILON] - You see young man... I'm old... but I'm not that old... what in the world \""+option+"\" means in this situation?\n", MAIN_SPEED);
			chooseName(game, in);
		} catch(NameAlreadyExistsException e) {
			printString("\n[SAILON] - I'm sorry young man, but I already met someone with that name... Can you change it so that I don't confuse them, please?\n", MAIN_SPEED);
			chooseName(game, in);
		}
		
	}
	
	/**
	 * Prints the name and first description of a location.
	 * @param game - GameSystem
	 */
	private static void enterNewLocation(GameSystem game) {
		location(game); coolDown(1000);
		locationInf(game); coolDown(800);
		if(game.isInDescriptionMode())locationObjects(game);
	}
	
	private static void locationObjects(GameSystem game) {
		if(game.hasStarted()) {
			try {
				Iterator<NonItem> it = game.allLocationObjects();
				printString(String.format("[ There's "), MAIN_SPEED);
				while(it.hasNext()) {
					NonItem ob = it.next();
					if(!it.hasNext()) printString("and ", MAIN_SPEED);
					printString(String.format("a%s %s%s", ob.getObjectDescription(), ob.getObjectType(), ob.getDirection()), MAIN_SPEED);              //Diferenciar an e a 
					if(!it.hasNext()) printString(". ]\n\n", MAIN_SPEED);
					else printString(", ", MAIN_SPEED);
				}
			} catch(NoObjectsException e) {}
		} else printString(ERROR_ALREADY_STARTED, MAIN_SPEED);
	}
	
	/**
	 * Prints all the items at the location.
	 * @param game - GameSystem
	 */
	private static void locationItems(GameSystem game) {
		if(game.hasStarted()) {
			try {
				Iterator<LinkedList<Item>> it = game.allLocationItems();
				while(it.hasNext()) {
					Iterator<Item> itItem = it.next().iterator();
					boolean first = true;
					while(itItem.hasNext()) {
						Item item = itItem.next();
						if(first) {
							System.out.printf("\n%s x%d:\n",item.getObjectType(), game.getLocationItemQuant(item.getObjectType()) ); first = false;
						}
						System.out.printf("	%s\n",item.getItemName());
					}
				}
			} catch(NoObjectsException e) {
				printString(ERROR_NO_ITEMS_IN_LOCATION, MAIN_SPEED);
			}
			System.out.print("\n");
		} else printString(ERROR_ALREADY_STARTED, MAIN_SPEED);
	}
	
	/**
	 * Prints all the information about the location.
	 * @param game - GameSystem
	 */
	private static void locationInf(GameSystem game) {
		printString(String.format("%s\n",game.getLocationDescription()), MAIN_SPEED);
	}
	
	/**
	 * Give you some information about the all game.
	 */
	private static void information() {
		printString(SUCCESS_INF, MAIN_SPEED);
	}
	
	/**
	 * Shows the credits of the game.
	 */
	private static void credits() {
		printString(SUCCESS_CREDITS, MAIN_SPEED);
	}
	
	/**
	 * Adds a new player to the game.
	 * @param game - GameSystem
	 */
	private static void newPlayer(Scanner in, GameSystem game) {
		
		String option;
		
		do {
			option = in.next().toUpperCase(); in.nextLine();
			if(option.equals(YES)) printString("\n[???] - Never talk to strangers... I compreend your position young man...\n\n", MAIN_SPEED);
			else if(option.equals(NO)) printString("\n[???] - Thank you very much young man, I can feel your good energy...\n\n",MAIN_SPEED);
		} while(!option.equals(YES) && !option.equals(NO));
		
		printString("[???] - Soooo... Anyway... Hi, my name is Sailon", MAIN_SPEED); coolDown(500);
		chooseName(game, in);
		
		
	}
	
	
	/**
	 * Tells you the name of your location at the moment.
	 * @param game - GameSystem
	 */
	private static void location(GameSystem game) {
		if(game.hasStarted())
			System.out.printf("\n["+game.getLocationName()+"]\n\n", game.getPlayerName().toUpperCase());
		else  printString(ERROR_ALREADY_STARTED, MAIN_SPEED);
		
	}

	/**
	 * Catch a floor item.
	 * @param in - Scanner
	 * @param game - GameSystem
	 */
	private static void getItem(Scanner in, GameSystem game) {
		if(game.hasStarted()) {
			Random rand = new Random();
			String items = in.next()+in.nextLine();
			Iterator<String> itemsType = game.splitItems(items); 
		
			while(itemsType.hasNext()) {
				int number = rand.nextInt(50);
				try {
					String item = itemsType.next();
					if(number!=50) {
						game.getItem(item);
						
						if(number<=20) printString(SUCCESS_GET_1, MAIN_SPEED);
						else if(number<20 && number>=45) printString(String.format(SUCCESS_GET_2, item), MAIN_SPEED);                  
						else printString(String.format(SUCCESS_GET_3, game.getPlayerName()), MAIN_SPEED);
						
					} else printString(SUCCESS_GET_4, MAIN_SPEED);
				} catch(ObjectNotInLocationException e) {
					printString(String.format(ERROR_OBJECT_NOT_IN_LOCATION, e.getItemType()),MAIN_SPEED);
				} catch(NotAnItemException e) {
					printString(String.format(ERROR_NOT_AN_ITEM, e.getItemType()), MAIN_SPEED);
				} catch(BagFullException e) {
					printString(ERROR_NO_SPACE, MAIN_SPEED);
				} catch(StakedItemException e) {
					printString(String.format(ERROR_STAKED_ITEM, e.getItemType()), MAIN_SPEED);
				}
			}
			System.out.println("\n");
		} else  printString(ERROR_ALREADY_STARTED, MAIN_SPEED);
	}
	
	/**
	 * Puts an bag item on the floor.
	 * @param in - Scanner
	 * @param game - GameSystem
	 */
	private static void dropItem(Scanner in, GameSystem game) {
		if(game.hasStarted()) {
			Random rand = new Random();
			String items = in.next()+in.nextLine();
			Iterator<String> itemsType = game.splitItems(items);
			
			while(itemsType.hasNext()) {
				int number = rand.nextInt(50);
				try {
					String item = itemsType.next();
					game.dropItem(item);
					
					if(number<=20) printString(SUCCESS_DROP_1, MAIN_SPEED);
					else if(number<20 && number>=40) printString(String.format(SUCCESS_DROP_2, item, game.getLocationName()), MAIN_SPEED);
					else if(number>40 && number<49) printString(String.format(SUCCESS_DROP_3, item), MAIN_SPEED);
					else printString(String.format(SUCCESS_DROP_4, game.getPlayerName()), MAIN_SPEED);
					
				} catch(ItemNotInBagException e) {
					printString(String.format(ERROR_ITEM_NOT_IN_BAG, e.getItemType()), MAIN_SPEED);
				} 
			}
			System.out.println("\n");
		} else  printString(ERROR_ALREADY_STARTED, MAIN_SPEED);
	}

	/**
	 * Description mode gives bigger descriptions of locations
	 * @param game - GameSystem
	 */
	private static void fullDescriptions(GameSystem game) {
		if(game.hasStarted()) {
			if(!game.isInDescriptionMode())
				printString(SUCCESS_DISCRIPTION_MODE_ON, MAIN_SPEED);
			else
				printString(SUCCESS_DESCRIPTION_MODE_OFF, MAIN_SPEED);
			game.descriptionMode();
		} else  printString(ERROR_ALREADY_STARTED, MAIN_SPEED);
	}

	/**
	 * Opens your bag.
	 * @param game - GameSystem
	 */
	private static void bagList(GameSystem game) {
		if(game.hasStarted()) {
			System.out.println(YOUR_BAG);
			try {
				Iterator<ArrayList<Item>> it = game.listBag();
				while(it.hasNext()) {
					ArrayList<Item> list = it.next();
					Item item = list.get(0);
					int quantity = list.size();
					
					System.out.printf("[%s]: x%d\n\n", item.getObjectType(), quantity);
				}
			} catch(EmpetyBagException e) {
				System.out.println(ERROR_EMPTY_BAG);
			}
		} else printString(ERROR_ALREADY_STARTED, MAIN_SPEED);
	}

	/**
	 * How much of an item do you have.
	 * @param in - Scanner
	 * @param game - GameSystem
	 */
	private static void howMuchItems(Scanner in, GameSystem game) {
		if(game.hasStarted()) {
			String item = in.next(); in.nextLine();
			
			try {
				printString(String.format(SUCCESS_ITEM_QUANTITY, game.getQuantity(item)), MAIN_SPEED);
			} catch (ItemNotInBagException e) {
				printString(String.format(ERROR_ITEM_NOT_IN_BAG, item), MAIN_SPEED);
			}
		} else printString(ERROR_ALREADY_STARTED, MAIN_SPEED);
	}

	/**
	 * How much money do you have.
	 * @param game - GameSystem
	 */
	private static void playerMoney(GameSystem game) {
		if(game.hasStarted())
			printString(String.format(SUCCESS_PLAYER_MONEY, game.getPlayerBalance()), MAIN_SPEED);
		else printString(ERROR_ALREADY_STARTED, MAIN_SPEED);
	}

	/**
	 * Gives you a lot of information about your game play.
	 * @param game - GameSystem
	 */
	private static void playerStatus(GameSystem game) {
		if(game.hasStarted()) {
			location(game);
			System.out.printf("\nPLAYER"+multiplier(25-game.getPlayerName().length(), " ") 
							+"%s\nMONEY"+multiplier(24-Double.toString(game.getPlayerBalance()).length(), " ")
							+"$%.2f\nITEMS GATHERED"+multiplier(17-Integer.toString(game.itemsGathered()).length(), " ")
							+"%d\n\nTIME PLAYED"+ multiplier(19-game.timePlayed().length(), " ")
							+" %s\nADVENTURE STARTED    %s\n\n", 
							game.getPlayerName(), game.getPlayerBalance(), game.itemsGathered(), game.timePlayed(), game.getStartDate());
		} else printString(ERROR_ALREADY_STARTED, MAIN_SPEED);
	}

	/**
	 * Tells you, your name.
	 * @param game - GameSystem
	 */
	private static void myName(GameSystem game) {
		if(game.hasStarted())
			printString(String.format(SUCCESS_MYNAME,game.getPlayerName()), MAIN_SPEED);
		else printString(ERROR_ALREADY_STARTED, MAIN_SPEED);
	}

	/**
	 * Walk to a certain direction (West, East, North, South).
	 * @param game - GameSystem
	 * @param string - direction.
	 */
	private static void goDirection(GameSystem game, Directions direction) {
		if(game.hasStarted()) {
			try {
				switch(direction) {
				case NORTH:
					game.movePlayer(Directions.NORTH);
					break;
				case WEST:
					game.movePlayer(Directions.WEST);
					break;
				case EAST:
					game.movePlayer(Directions.EAST);
					break;
				case SOUTH:
					game.movePlayer(Directions.SOUTH);
					break;
				}
				printString(String.format(SUCCESS_WALKING, direction), MAIN_SPEED);
				enterNewLocation(game);
			} catch(NoExitException e) {
				printString(ERROR_NO_EXIT, MAIN_SPEED);
			} catch(WalkUsingObjectException e) {
				printString(ERROR_WALK_OBJECT, MAIN_SPEED);
				goDirection(game, direction);
			}
		} else printString(ERROR_ALREADY_STARTED, MAIN_SPEED);
	}

	/**
	 * 
	 * @param in - Scanner
	 * @param game - GameSystem
	 */
	public static void action(Scanner in, GameSystem game, Propertys property) {
		if(game.hasStarted()) {
			String object = in.next(); in.nextLine();
			
			try {
				
				game.action(property, object);
				
				switch(property) {
				case USE:
					printString(String.format("",object), MAIN_SPEED);
					break;
				case SIT:
					printString(String.format(SUCCESS_SIT, object), MAIN_SPEED);
					break;
				case LAY:
					printString(String.format(SUCCESS_LAY, object), MAIN_SPEED);
					break;
				case PUT:
					String secondObject = in.next(); in.nextLine();
					printString(String.format(SUCCESS_PUT, object, secondObject), MAIN_SPEED);
					break;
				}
				
			} catch(ItsAnItemException e) {
				printString(String.format(ERROR_ITS_AN_ITEM,object), MAIN_SPEED);
			} catch(ObjectNotInLocationException e) {
				printString(String.format(ERROR_OBJECT_NOT_IN_LOCATION+"\n\n",object), MAIN_SPEED);
			} catch(DiferentPropertysException e) {
				printString(String.format(ERROR_DIFERENT_PROPERTY,property.name().toLowerCase()), MAIN_SPEED);
			} catch(ObjectOccupiedException e) {
				printString(String.format(ERROR_ALREADY_DOING_THAT, e.getEntety().getName()),MAIN_SPEED);
			}
		} else printString(ERROR_ALREADY_STARTED, MAIN_SPEED);
	}

	/**
	 * You stand up if you're down.
	 * @param game - GameSystem
	 */
	private static void stand(GameSystem game) {
		
	}
	
	/**
	 * Buy or sell an item with a entity.
	 * @param in - Scanner
	 * @param game - GameSystem
	 * @param transaction - BUY or SELL
	 */
	private static void transaction(Scanner in, GameSystem game, Command transaction) {
		if(game.hasStarted()) {
			String item = in.next(),
				   entity = in.next();
			in.nextLine();
			int quantity=1;
			double price;
				
			try {
				switch(transaction) {
					case BUY:
						if(game.getEntityQuantity(entity, item)>1) {
							printString(ITEM_QUANTITY_QUESTION_BUY, MAIN_SPEED);
							quantity = in.nextInt();
							in.nextLine();
						}
						price = game.buy(item, entity, quantity);
						printString(String.format(SUCCESS_BUY_ITEM, item, entity, price),MAIN_SPEED);
						break;
					case SELL:
						if(game.getQuantity(item)>1) {
							printString(ITEM_QUANTITY_QUESTION_SELL, MAIN_SPEED);
							quantity = in.nextInt();
							in.nextLine();
						}
						price = game.sell(item, entity, quantity);
						printString(String.format(SUCCESS_SELL_ITEM, item, entity, price),MAIN_SPEED);
						break;
					default:
						break;
				}
			} catch(InputMismatchException e) {
				printString(ERROR_SCANNER_NUM, MAIN_SPEED);
				in.nextLine();
			} catch(ItemNotInBagException e) {
				String seller = entity;
				if(transaction.equals(Command.SELL)) seller = "You";	
				printString(String.format(ERROR_ITEM_NOT_IN_BAG_TRANSACTION, seller, item), MAIN_SPEED);
			} catch(EntityNotInLocationException e) {
				printString(String.format("\n"+entity+" isn't in "+game.getLocationName()+".\n\n", game.getPlayerName().toUpperCase()), MAIN_SPEED);
			} catch(QuantityErrorException e) {
				printString(ERROR_QUANTITY, MAIN_SPEED);
			}
		} else printString(ERROR_ALREADY_STARTED, MAIN_SPEED);
	}
	
	/**
	 * Prints an error message when the insert command does not exist.
	 */
	private static void defaultError(Scanner in) {
		in.nextLine();
		printString(ERROR_INVALID_COMMAND, MAIN_SPEED);
	}
	
	/**
	 * Ends your adventure until you come back.
	 */
	private static void exit(Scanner in, GameSystem game) {
		String response;
		if(game.hasStarted())
			do {
				printString(EXIT_SAVE, MAIN_SPEED);
				response = in.next().toUpperCase(); in.nextLine();
				if(response.equals(YES))
					save(game);
				else if(response.equals(NO))
					printString("\nAs you wish...\n\n", MAIN_SPEED);
			} while(!response.equals(YES) && !response.equals(NO));
			
		
		printString(SUCCESS_EXIT, MAIN_SPEED);
		game.exit();
	}
}
