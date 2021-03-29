import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

import gameSystem.*;
import items.Item;

public class Main {
	
	/* First Option Constants */
	private static final String START = "START";
	private static final String INFORMATION = "INF";
	private static final String CREDITS = "CREDITS";
	private static final String EXIT = "EXIT";
	
	/* Second Option Constants */
	private static final String LOCATION = "LOCATION" ;
	private static final String DESCRIPTIONS = "DESC";
	private static final String WEST = "W";
	private static final String EAST = "E";
	private static final String NORTH = "N";
	private static final String SOUTH = "S";
	private static final String BAG_LIST = "BAG";
	private static final String PLAYER_CURRENT_STATUS = "STATUS";
	private static final String GET_ITEM = "GET";
	private static final String DROP_ITEM = "DROP";
	private static final String QUANTITY_ITEM = "QUANT";
	private static final String MONEY = "MONEY";
	private static final String NAME = "MYNAME";
	private static final String SIT = "SIT";
	private static final String LAY = "LAY";
	private static final String STAND = "STAND";
	private static final String TURN = "TURN";
	private static final String CLOSE = "CLOSE";
	private static final String CLICK = "CLICK";
	private static final String HELP = "HELP";
	
	/* Success Constants */
	private static final String SUCCESS_START = "\nWelcome to your Adventure!";
	private static final String SUCCESS_EXIT = "\nLeaving...";
	private static final String SUCCESS_DISCRIPTION_MODE_ON = "\nYour Adventure is now in description mode,"
																+ " which always gives int descriptions of locations.\n";
	private static final String SUCCESS_DESCRIPTION_MODE_OFF = "\nYour Adventure is no inter in description mode.\n";
	private static final String SUCCESS_YES = "Yes";
	private static final String SUCCESS_NO = "No";
	private static final String SUCCESS_GO_WEST = "\nYou walked a couple of steps to the West.\n";
	private static final String SUCCESS_GO_NORTH = "\nYou walked a couple of steps to the North.\n";
	private static final String SUCCESS_GO_SOUTH = "\nYou walked a couple of steps to the South.\n";
	private static final String SUCCESS_GO_EAST = "\nYou walked a couple of steps to the East.\n";         
	private static final String SUCCESS_LOCATION = "\n[ %s ]\n\n";
	private static final String SUCCESS_MINIGAME = "\nInsert numbers between 0 and %d\nYou have %s guesses\n";
	private static final String GO_WEST = "w";
	private static final String GO_NORTH = "n";
	private static final String GO_SOUTH = "s";
	private static final String GO_EAST = "e";
	
	/* Errors Constants */
	private static final String ERROR_INVALID_COMMAND = "\nHoo man! That must be a type of encrypted language I don't understand!\n\n";  
	private static final String ERROR_NO_SPACE = "\nYou can't put these item in your bag while it's full.\nYou need to drop something.\n\n";
	private static final String ERROR_NOT_FOUND = "\nYou don't have a %s in your Bag.\n\n";
	private static final String ERROR_EMPTY_BAG = "\nYour bag is empty.\n";
	private static final String ERROR_NOTHING_DROPPED = "\nNothing was dropped.\n\n";
	private static final String ERROR_NOT_AN_ITEM = "\nYou tried realy hard but, you couldn't put a %s in you bag...\n\n";
	private static final String ERROR_OBJECT_NOT_IN_LOCATION = "\n%s doesn't exist in this location...\n\n";
	private static final String ERROR_OBJECT_NOT_TO_SIT = "\nYou can't sit in a %s...\n\n";
	private static final String ERROR_OBJECT_NOT_TO_TURN_ON = "\nYou can't turn On/Off a %s...\n\n ";
	private static final String ERROR_COIN_PURSE_IS_FULL = "\nYou can't put more coins in your Coin Purse while it's full.\n\n";
	private static final String ERROR_COIN_PURSE_IS_EMPTY = "\nYou can't drop more coins while your Coin Purse it's empty.\n\n";
	private static final String ERROR_STAKED_ITEM = "\nYou can't put more %ss in your bag.\n\n";
	private static final String ERROR_BIG_NAME = "\nWooow! Looks like your name is to big for me to handle... Try write a smaller one. (<22)\n";
	private static final String ERROR_IN_BEDROOM = "\nYour door are closed, you can't go to any diretions in your room... Try something else.\n\n";
	private static final String ERROR_IN_NOWHERE = "\nHoo... What is this place I can't go anywhere... Its all darkness...\n\n";
	private static final String ERROR_CLICK_PROGRAM = "\nTry turn the Computer on first!\n\n";
	private static final String ERROR_PROGRAM_DONT_EXIST = "You don't have %s in your computer\n\n";
	
	private static String readOption( Scanner in ) {
		return in.next().toUpperCase();
		}
	
	private static void exeFirstOption( Scanner in,  GameSystem game, String option ) {
		switch(option) {
		case START:
			start(in,game);
			break;
		case INFORMATION:
			information();
			break;
		case CREDITS:
			credits();
			break;
		case EXIT:
			exit(game);
			break;
		case HELP:
			help(game);
			break;
		default:
			defaultError();
			break;
		}
	}
	
	private static void exeOption( Scanner in,  GameSystem game, String option ) {
		switch(option) {
		case INFORMATION:
			information();
			break;
		case CREDITS:
			credits();
			break;
		case LOCATION:
			location(game);
			break;
		case GET_ITEM:
			getItem(in, game);
			break;
		case DESCRIPTIONS:
			fullDescriptions(game);
			break;
		case BAG_LIST:
			bagList(game);
			break;
		case DROP_ITEM:
			dropItem(in, game);
			break;
		case QUANTITY_ITEM:
			howMuchItems(in, game);
			break;
		case MONEY:
			playerMoney(game);
			break;
		case PLAYER_CURRENT_STATUS:
			playerStatus(game);
			break;
		case NAME:
			myName(game);
			break;
		case WEST:
			goWest(game);
			break;
		case EAST:
			goEast(game);
			break;
		case NORTH:
			goNorth(game);
			break;
		case SOUTH:
			goSouth(game);
			break;
		case SIT:
			sit(in, game);
			break;
		case STAND:
			stand(game);
			break;
		case LAY:
			lay(game);
			break;
		case TURN:
			turnOnOff(in, game);
			break;
		case CLOSE:
			close(in, game);
			break;
		case CLICK:
			clickProgram(in, game);
			break;
		case HELP:
			help(game);
			break;
		case EXIT:
			exit(game);
			break;
		default:
			in.nextLine();
			defaultError();
			break;
		}
	}
	
	private static void printString(String text) {
		for(int i = 0; i < text.length(); i++){
		    System.out.printf("%c", text.charAt(i));
		    coolDown(65);
		}
	}
	
	private static void printStringSpeed(String text, int speed) {
		for(int i = 0; i < text.length(); i++){
		    System.out.printf("%c", text.charAt(i));
		    coolDown(speed);
		}
	}
	
	private static void coolDown(int time) {
		try{
	        Thread.sleep(time);
	    }catch(InterruptedException ex){
	        Thread.currentThread().interrupt();
	    }
	}

	private static void printMenu(GameSystem game) {
		System.out.printf("\n%s* We Lost The Sea *%s\n%s( Menu )%s\n**%s**\n*%s*\n%sStart\n%sInformation\n%sCredits\n%sExit\n*%s*\n**%s**\n\n"
				, game.multiplier(15, " "), game.multiplier(13, " "), game.multiplier(20, " ")
				, game.multiplier(20, " "), game.multiplier(45,"-"), game.multiplier(47, " ")
				, game.multiplier(22, " "), game.multiplier(19, " "), game.multiplier(21, " ")
				, game.multiplier(22, " "), game.multiplier(47, " "), game.multiplier(45,"-"));
	}
	
	private static void defaultError() {
		printString(ERROR_INVALID_COMMAND);
	}
	
	private static void start(Scanner in, GameSystem game ) {
		String option = SUCCESS_NO;
		String name;
		printString(SUCCESS_START);
		
		do {
			do {
				printString("\nSo... Whats your name?\n\n");
				System.out.print("> ");
				name = in.next() + in.nextLine();
				if(name.length()>22)
					printString(ERROR_BIG_NAME);
				else				
					do {
						printString(String.format("\nHi %s is that your name?\n Yes or No?\n\n> ", name));
						option = in.next();
						in.nextLine();
						if(!option.equalsIgnoreCase(SUCCESS_YES) && !option.equalsIgnoreCase(SUCCESS_NO))
							printString(ERROR_INVALID_COMMAND);
					} while(!option.equalsIgnoreCase(SUCCESS_YES) && !option.equalsIgnoreCase(SUCCESS_NO));
			} while(name.length()>22);
		} while(!option.equalsIgnoreCase(SUCCESS_YES));
			game.start(name);
			printString(String.format("\nHey %s, in this universe where you just entered,\nyou will witness one of the best journeys that you'll ever have!\n\n", name));
			System.out.println("[ PRESS ENTER TO CONTINUE ]");
			in.nextLine();
			System.out.printf("[ %s's %s ] \n\n", game.getPlayerName().toUpperCase(), game.getPlayerLocation().toUpperCase()); coolDown(1000);
			printString("There's a beautiful day outside...\n"); coolDown(900);
			printString("You can see the sun rays entering by the BedRoom window and warming you...\n"); coolDown(800);
			printString("[ You are standing in the middle of your Room...\nThere's a Computer above a Desk, a red and white comfortable Bed,\n"
						+ "a light brown leather ArmChair, an empty Shelf in front of your Desk and a BookShelf full of Books. ]\n\n");
		
	}
	
	private static void help(GameSystem game) {
		System.out.printf("\n%s\n\n Location - Tells you the name of your location.\n Desc - Description mode gives bigger "
				+ "descriptions of locations.\n W - Walk to the West.\n E - Walk to the East.\n N - Walk to the North.\n S - Walk to the South."
				+ "\n Bag - Opens your bag.\n Status - Gives you a lot of information about your game play"
				+ "\n Get ( item name, quantity ) -  Catches an item on the floor.\n Drop ( item name ) - Puts an item on the floor."
				+ "\n Quant ( item name ) - How much of an item do you have.\n Money - How much money do you have."
				+ "\n MyName - Tells you, your name.\n\n%s\n\n",game.multiplier(66, "="), game.multiplier(66, "="));
	}

	private static void goWest(GameSystem game) {
		if(game.isInFirstLocations()==0)
			printString(ERROR_IN_BEDROOM);
		else if(game.isInFirstLocations()==1)
			printString(ERROR_IN_NOWHERE);
		else {
			if(game.getState()==0)
				printString(SUCCESS_GO_WEST);
			else {
				printString("\nYou kindly stand up and walked a couple of steps to the West.\n");
				game.stand();
			}
			game.goLocation(GO_WEST);
			printString(String.format(SUCCESS_LOCATION, game.getPlayerLocation().toUpperCase()));
		}
	}
	
	private static void goEast(GameSystem game) {
		if(game.isInFirstLocations()==0)
			printString(ERROR_IN_BEDROOM);
		else if(game.isInFirstLocations()==1)
			printString(ERROR_IN_NOWHERE);
		else {
			if(game.getState()==0)
				printString(SUCCESS_GO_EAST);
			else {
				printString("\nYou kindly stand up and walked a couple of steps to the East.");
				game.stand();
			}
			game.goLocation(GO_EAST);
			printString(String.format(SUCCESS_LOCATION, game.getPlayerLocation().toUpperCase()));
		}
	}
	
	private static void goNorth(GameSystem game) {
		if(game.isInFirstLocations()==0)
			printString(ERROR_IN_BEDROOM);
		else if(game.isInFirstLocations()==1)
			printString(ERROR_IN_NOWHERE);
		else {
			if(game.getState()==0)
				printString(SUCCESS_GO_NORTH);
			else {
				printString("\nYou kindly stand up and walked a couple of steps to the North.");
				game.stand();
			}
			game.goLocation(GO_NORTH);
			printString(String.format(SUCCESS_LOCATION, game.getPlayerLocation().toUpperCase()));
		}
	}

	private static void goSouth(GameSystem game) {
		if(game.isInFirstLocations()==0)
			printString(ERROR_IN_BEDROOM);
		else if(game.isInFirstLocations()==1)
			printString(ERROR_IN_NOWHERE);
		else {
			if(game.getState()==0)
				printString(SUCCESS_GO_SOUTH);
			else {
				printString("\nYou kindly stand up and walked a couple of steps to the South.");
				game.stand();
			}
			game.goLocation(GO_SOUTH);
			printString(String.format(SUCCESS_LOCATION, game.getPlayerLocation().toUpperCase()));
		}
	}
	
	private static void turnOnOff(Scanner in, GameSystem game) {
		String object = in.next();
		in.nextLine();
		object = object.substring(0,1).toUpperCase() + object.substring(1).toLowerCase();
		
		if(!game.hasObjectInLocation(object))
			printString(String.format(ERROR_OBJECT_NOT_IN_LOCATION,object));
		else if(!game.canTurnOn(object))
			printString(String.format(ERROR_OBJECT_NOT_TO_TURN_ON, object));
		else {
			game.turnOnOff(object);
			if(game.getState() == 1)
				printString(String.format("\nThe %s has been turned %s.\n\n", object, game.getComputer()));
			else {
				game.sit();
				game.setPreviousObject(object);
				printString(String.format("\nYou kindly sat down on a Chair and turned the %s %s.\n\n", object, game.getComputer()));
			}
			if(object.equals("Computer") && game.getComputer().equals("On")) {
				for(int i=0; i<4; i++) {
					printString(".\n");
					coolDown(800);
				}
				printString("You successfully turned on your Computer.\n"); coolDown(700);
				printString("A lot of icons of Computer programs take care of the screen instantly...\n");
				printString("There's your favorite video game, a browser where you search all you want, a txt Archive and a lot of other stuff...\n"); coolDown(700);
				printString("Type \"Click\" and the name of the program you want to open or turn the computer off (Electrecity is getting expensive nowadays)...\n\n");
			} 
		}
	}
	
	private static void clickProgram(Scanner in, GameSystem game) {
		String program=in.next();
		if(game.getComputer().equals("Off"))
			printString(ERROR_CLICK_PROGRAM);
		else {	
			if(game.getState() == 1)
				printString(String.format("\nSo without thinking twice, you clicked on the %s.\n\n", program));
			else {
				game.sit();
				printString(String.format("\nYou kindly sitted down on a Chair and without thinking twice, clicked in the %s.\n\n", program));
			}
			switch(program.toUpperCase()) {
				case "TXT":
				case "ARCHIVE":
					printString("Archive: When You're all covererd between the nothingness of darkness..."
							+ "Try Close your Eyes, thats the best option sometimes...\n\n");
					break;
				case "BROWSER":
					break;
				case "VIDEOGAME":
				case "GAME":
					PCgame(in, game);
					break;
				default:
					printString(String.format(ERROR_PROGRAM_DONT_EXIST, program));
					break;
			}
		}
	}
	
	private static void PCgame(Scanner in, GameSystem game) {
		do {
			printString("Do you think you're lucky? Try to guess the number\n");
			printString("Insert the level number you want to play...\n");
			System.out.print( " (      Easy - 1     )\n"
							+ " (       Ok - 2      )\n"
							+ " (      Hard - 3     )\n"
							+ " (    HardCore - 4   )\n"
							+ " (   ÙÓkß”àHºå - 5   )\n\n> ");
			int level=0;
			try {
				level = in.nextInt();
			} catch(InputMismatchException e) {
				printString("\nThe level needs to be a number.\n\n");
				in.nextLine();
				return;
			}
			int tryNum=0;
			int range=0;
			do { switch(level) {
				case 1:
					tryNum=5; range=20;
					break;
				case 2:
					tryNum=6; range=30;
					break;
				case 3:
					tryNum=5; range=50;
					break;
				case 4:
					tryNum=1; range=100;
					break;
				case 5:
					spaceTravel(in, game);
					return;
				default:
					printString("Try a valid number.\n\n"); 
				}}while(level<1 || level>5);
			if(!game.getPlayerLocation().equals("NoWhere")) {
				game.newGame(range, tryNum);
				printString(String.format(SUCCESS_MINIGAME, range, tryNum));
				int guess;
				do {
					printString("Type your guess: ");
					guess=in.nextInt();
					game.decTryNum();
					if(game.playerWin(guess)) {
						printString(String.format("YOU WIN!!!!\nOnly %d guesses remained\n\n", game.getTryNum()));
						if(level==5) { game.getMoney(10000); printString("You also win 10000$!!!\n\n");}       //ERRRORRRRR
					} else if(!game.noTry()) {
						if(game.isGreaterThan(guess))
							printString("Try a lower number.\n\n");
						else
							printString("Try a greater number.\n\n");
						printString(String.format("%d still remain.\n", game.getTryNum()));
					}
				} while(!game.noTry() || game.playerWin(guess));
				if(game.noTry())
					printString(String.format("GAME OVER\nThe number was %d.\n",game.getRandomNum()));
				printString("Want to play more?\n YES  NO\n");
				System.out.println("");
			} else { break; }
		}while(in.next().equalsIgnoreCase("yes"));
	}
	
	private static void spaceTravel(Scanner in, GameSystem game) {
		printStringSpeed("Kkq6÷€¤½2 ¢7hßŒÕfõÕú4ú¦ôý^çUÐCê[–Éõƒ=¿PúgUOKcn”²âÉÞ²uÛŽçQÖLËÐT½QdXÆ*ª U¨U" + 
				"V±mu0Ùœgº0ßÊ0Û%¹DPÕ=ÄPK{èúoUÐôQéMønomBSNr4nníþö@õ€ˆ\"4¥[KZºÃj²âï§ô]CÔDØ†Êw=;ó6ã¹ÒÆÙ\n" + 
				"¹ mÈ[ZÃõ}ýï¨nO¥éeÐÇ×Ž–[Œ A=R,hm\f+V½­Çn2œÚÆ€U¸éí­=/WŸªŒö¶ºyD1ê#ëƒbz¥é¦ÄªA*¯Oêÿ }CQk" + 
				"Ò^‘eÉ\fA?º …-]ÝYÆí´ú Ð¬9¬Ù«,r£{ÝL6kn•Üc6rh¥V€[2êsŒzmí¶.Îô¶Ù§ÔP£h¢Sv)@‹‡UííAßÜÜ‚±‹e\n" + 
				"¹jÂÁS4Õºèt±è¶z]íýý§­Ý‘ˆGqÚŽÕ¨ú¢­Œj@!ê$(H×6zs¨ÝéáÓ;»½Föç¡ØÛƒj ¥¶­6ã{’ˆÒ.9'¨“q’±F%]\\bÈTª" + 
				"¡Mš[»Ûóé·ÉlOmc¹EŠ#H”¢&NÈá«Ô#7cseÚœÉE$nm(Åi²éÄÈ\"k­Ö}Ck©ÝÚê¡¿×mýB[rÿ ›ÔuÛŸŠu‡\fdFöçFöç\n" + 
				")„l=H©8gˆGÓ]ÈÀ4ÙÆS¿jufÛ½¹#kb»›‘Œ¥ Û´%¡CjPÝz}d·c»èê·\"I–Ô£\"DF”dÍŠf²Ä!º;ßi’EJQA\\DF\n\n",20);
		printString("What!?... "); coolDown(800); printString("What's happening!???"); coolDown(800); printStringSpeed("NOOOOOOOOOOOOOOOOOOO!\n", 20); coolDown(800);
		printString("You, by ignoring all laws of physics, traveling between the space and time, got sucked into the computer...\n");
		game.stand();
		game.turnOnOff("Computer");
		game.setLocation("NoWhere");
		System.out.printf(SUCCESS_LOCATION, game.getPlayerLocation().toUpperCase());
	}
	
	private static void close(Scanner in, GameSystem game) {
		if(in.next().toUpperCase().equals("EYES")) {
			if(game.getPlayerLocation().equals("NoWhere")) {
				coolDown(1000);
				printString("\nSuddenly..."); coolDown(1000);
				printString("\nYou close your eyes..."); coolDown(1000);
				printString("\nYou feel a small breeze..."); coolDown(1000);
				printString("\nAnd when you open'em..."); coolDown(1000);
				game.setLocation("Spreech Forest");
				printString("\nYou fall into a totally different reality..."); coolDown(1000);
				printString("\nA new peaceful and beautiful world, pixels are generated all around you..."); coolDown(1000);
				printString("\nForests, rivers, villages, and big wonderful mountains are created before your eyes!...\n"); coolDown(1000);
				printString(String.format(SUCCESS_LOCATION, game.getPlayerLocation().toUpperCase())); coolDown(1000);
				coolDown(1000);
				printString("\"Where am I ?\nIs that a new World?!\"\n\n");
			} else {
				printString("\nYou close your eyes... "); coolDown(700);
				printString("Sometimes feels good to stop a bit... "); coolDown(1000);
				printString("You open'em again.\n\n");
			}
		}
	}
	
	private static void sit(Scanner in, GameSystem game) {
		String object = in.next();
		in.nextLine();
		object = object.substring(0,1).toUpperCase() + object.substring(1).toLowerCase();
		
		if(!game.hasObjectInLocation(object))
			printString(String.format(ERROR_OBJECT_NOT_IN_LOCATION,object));
		else if(!game.canSit(object))
			printString(String.format(ERROR_OBJECT_NOT_TO_SIT,object));
		else {
			if(game.getState() != 1) {
				game.sit();
				printString(String.format("\nNow you are sat on a %s.\n\n", object));
			} else {
				game.sit();
				if(object.equals(game.getPreviousObject()))
					printString(String.format("\nSuddenly, you standed up and faster then the speed of light, sat again on the %s.\n\n", object));
				else
					printString(String.format("\nYou stand up from the %s and sat on a %s.\n\n", game.getPreviousObject(), object));
			}
			game.setPreviousObject(object);
		}
	}
	
	private static void stand(GameSystem game) {
		if(game.getState() != 0) {
			game.stand();
			printString("\nYou stand up.\n\n");
		} else
			printString("\nYou are already standing.\n\n");
	}
	
	private static void lay(GameSystem game) {
		if(game.getState() != 2) {
			game.lay();
			printString("\nYou laid down.\n\n");
		} else
			printString("\nYou are already lying down.\n\n");
	}
	
	private static void information() {
		printString("\nWe Lost The Sea is a Text Adventure type Game, you just need to type what you want to do and create your own journey."
				+ "\nAny command mismatch you can type ( Help ) to print a list of all the commands in game."
				+ "\nYou can walk for any direction you want (if there aren't some type of object blocking your way), such as ( 'N' - North 'S' - South 'E' - East 'W' - West )."
				+ "\nAnd a lot more to discover... Good luck Adventurer!!\n\n");
	}
	
	private static void credits() {
		printString("\nWE LOST THE SEE\nA Text Adventure Game\nBy Afonso Batista ( 2019-2020 ) \nThanks for playing this game!\n\n");
	}
	
	private static void playerStatus(GameSystem game) {
		if(game.isInFirstLocations()==0)
			System.out.printf("\n[ %s'S %s ]",game.getPlayerName().toUpperCase(), game.getPlayerLocation().toUpperCase());
		else
			System.out.printf("\n[ %s ]",game.getPlayerLocation().toUpperCase());
		System.out.printf("\nPLAYER"+ game.multiplier(25-game.getPlayerName().length(), " ") 
		+"%s\nMONEY"+ game.multiplier(25-Integer.toString(game.playerBalance()).length(), " ") + "$%d\nITEMS GATHERED"+
		game.multiplier(17-Integer.toString(game.itemsGathered()).length(), " ") +"%d\n\nTIME PLAYED"+ 
		game.multiplier(19-game.timePlayed().length(), " ") + " %s\nADVENTURE STARTED    %s\n\n", 
		game.getPlayerName(), game.playerBalance(), game.itemsGathered(), game.timePlayed(), game.getStartDate());
	}
	
	private static void myName(GameSystem game) {
		printString(String.format("\nYour Name is %s don't you remember ?\n\n",game.getPlayerName()));
	}
	
	private static void getItem(Scanner in, GameSystem game) {
		//do {
			String itemName = in.next();
			int quantity=0;
			try {
				quantity = in.nextInt();
			} catch (InputMismatchException e) {
				printString("\nThe item quantity needs to be a number.\n\n");
				in.nextLine();
				return;
			}
			itemName = itemName.substring(0,1).toUpperCase() + itemName.substring(1).toLowerCase();
			Random rand = new Random();
			
			if(!game.hasObjectInLocation(itemName))
				printString(String.format(ERROR_OBJECT_NOT_IN_LOCATION, itemName));
			else if(!game.hasItemInGame(itemName))
				printString(String.format(ERROR_NOT_AN_ITEM, itemName));
			else if(game.itsMoney(itemName)) {
				if(game.isFullCoinPurse())
					printString(ERROR_COIN_PURSE_IS_FULL);
				else {
					game.incBalance();
					printString(String.format("\nYou earned $%d, now you have $%d in your Coin Purse\n\n",game.getAddAmount(), game.playerBalance()));
				}
			} else if(game.isBagFull())
				printString(ERROR_NO_SPACE);
			else if(game.isStakedItem(itemName))
				printString(String.format(ERROR_STAKED_ITEM, itemName));
			else {
				int number = rand.nextInt(50);
				quantity = game.getFinalQuantity(itemName, quantity);
				if(number <= 20) {
					game.getItem(itemName, quantity);
					printString("\nTaken.\n\n");
				} else if(number > 20 && number <= 45) {
					game.getItem(itemName, quantity);
					if(quantity==1)
						printString(String.format("\nYou have put a %s in your Bag.\n\n", itemName));
					else
						printString(String.format("\nYou have put %d %ss in your Bag.\n\n",quantity, itemName));
				} else if(number > 45 && number < 49) {
					game.getItem(itemName, quantity);
					printString(String.format("\nNice catch, %s!\n\n", game.getPlayerName()));
				} else {
					printString("\nYou get hit by a wave of laziness, causing you to refuse to pick up the item...\n");
				}
			}
		//} while(in.hasNext());     NÃO FUNCIONA
	}
	
	private static void dropItem(Scanner in, GameSystem game) {
		int quantity = 0;
		Random rand = new Random();
		String itemName = in.next();
		in.nextLine();
		itemName = itemName.substring(0,1).toUpperCase() + itemName.substring(1).toLowerCase();
		
		if(game.itsMoney(itemName)) {
			if(game.isEmptyCoinPurse()) {
				printString(ERROR_COIN_PURSE_IS_EMPTY);
			} else {
				game.decBalance();
				printString(String.format("\nYou droped $%d, now you have $%d in your Coin Purse\n\n",game.getAddAmount(), game.playerBalance()));
			}
		} else if(game.getBagItemQuantity(itemName)==0) {
			printString(String.format(ERROR_NOT_FOUND, itemName));
		} else {
			if(game.getBagItemQuantity(itemName)>1) {
				printString(String.format("\nYou Have: %d %s(s) in your Bag, how much of these do you want to drop?\n\n",game.getBagItemQuantity(itemName), itemName));		
				try {                                                
					quantity = in.nextInt();
				} catch(InputMismatchException e) {
					printString("\nThe item quantity needs to be a number.\n\n");
					in.nextLine();
					return;
				}
				if(quantity<=0)
					printString(ERROR_NOTHING_DROPPED);
				else
					game.dropItem(itemName, quantity);
			} else
				game.dropItem(itemName, 1);
			int number = rand.nextInt(50);
					
			if(number <= 20) {
				printString("\nYou have droped the item.\n");
			} else if(number > 20 && number <= 40) {
				if(game.getDropedItems()==1)
					printString(String.format("\nNow 1 %s is droped in the middle of %s.\n\n", itemName, game.getPlayerLocation()));
				else
					printString(String.format("\nNow %d %ss are droped in the middle of %s.\n\n", game.getDropedItems(), itemName, game.getPlayerLocation()));
			} else if(number > 40 && number < 49) {
				if(game.getDropedItems()==1)
					printString(String.format("\nYou throw away as far as you can 1 %s!\n\n", itemName));
				else
					printString(String.format("\nYou throw away as far as you can %d %ss!\n\n", game.getDropedItems(), itemName));  
			} else {
				printString(String.format("\nBetween wind sounds %s says :\n\"hmmm now I fell lighter...\"\n\n", game.getPlayerName()));	
			}
		}	
	}
	
	private static void howMuchItems(Scanner in, GameSystem game) {
		String itemName = in.next();
		in.nextLine();
		if(game.getBagItemQuantity(itemName) == 0)
			printString(String.format(ERROR_NOT_FOUND, itemName));
		else if(game.getBagItemQuantity(itemName)>1)
			printString(String.format("\nYou have %d %ss in your bag.\n\n",game.getBagItemQuantity(itemName), game.getBagItemName(itemName)));
		else
			printString(String.format("\nYou have a %s in your bag.\n\n", game.getBagItemName(itemName)));
	}
	
	private static void playerMoney(GameSystem game) {
		if(game.playerBalance()<=0)
			printString("\nYou don't have any coins in your Coin Purse.\n");
		else if(game.playerBalance()==1)
			printString("\nYou have 1$ in your Coin Purse.\n");
		else if(game.playerBalance()>1 && !game.isFullCoinPurse())
			printString(String.format("\nYou have %d$ in your Coin Purse.\n\n", game.playerBalance()));
		else
			printString(String.format("\n\"Wowww... my Coin Purse feels realy heavy...\"\nYour Coin Purse are full now, with %d$ !!!\n\n", game.playerBalance()));
	}
	
	private static void location(GameSystem game) {
		System.out.printf(SUCCESS_LOCATION ,game.getPlayerLocation().toUpperCase());
	}
	
	private static void bagList(GameSystem game) {
		InventoryIterator list = game.createInventoryIterator();
		if(!list.hasNext())
			printString(ERROR_EMPTY_BAG);
		else {
			System.out.println("\nYour Bag:");
			while(list.hasNext()) {
				Item items = list.next();
			
				System.out.printf("[%s]: x%d\n\n", items.getItemName(), items.getQuantity());
			}
		}
		printString("");
	}
	
	private static void fullDescriptions(GameSystem game) {
		if(!game.isInDescriptionMode()) {
			printString(SUCCESS_DISCRIPTION_MODE_ON);
		} else {
			printString(SUCCESS_DESCRIPTION_MODE_OFF);
		}
		game.descriptionMode();
	}

	private static void exit(GameSystem game) {
		printString(SUCCESS_EXIT);
		game.exit();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		GameSystem game = new GameSystem();
		printMenu(game);
		while(!game.isStartOn() && !game.isExitOn()) {
			System.out.print("> ");
			exeFirstOption(in, game, readOption(in));
		}
		while(!game.isExitOn()) {
			System.out.print("> ");
			exeOption(in, game, readOption(in));
		}
			
		in.close();
	}

}
