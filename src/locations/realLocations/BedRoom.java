package locations.realLocations;

import java.util.*;

import entity.Entity;
import gameSystem.Directions;
import gameSystem.Locations;
import gameSystem.Programs;
import locations.LocationClass;
import objects.items.*;
import objects.*;
import objects.nonItems.*;

/**
 * The player BedRoom.
 * @author Afonso Batista
 */
public class BedRoom extends LocationClass {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1285247334231281697L;

	private static final String BEDROOM_SMALL_DESCRIPTION = "There's a beautiful day outside...\n";
	
	private static final String BEDROOM_BIG_DESCRIPTION = BEDROOM_SMALL_DESCRIPTION + "You can see the sun rays entering "
			+ "by the BedRoom window and warming you...\n";
	
	private static final String BEDROOM_NAME = "%s'S BEDROOM";
	
	private static Map<String, LinkedList<Item>> items = new HashMap<String, LinkedList<Item>>() {
		private static final long serialVersionUID = -565691364300570895L;

		{
			put("book", new LinkedList<Item>(Arrays.asList(new Book("Instruction Manual",""), new Book("Diary",""), new Book())));
			put("sword", new LinkedList<Item>(Arrays.asList(new ItemClass("Sword", "Master Sword", 1000))));
			put("coin", new LinkedList<Item>(Arrays.asList(new Coin())));
		}
	};
	
	//List of objects in this location.
	private static Map<String, NonItem> objects = new HashMap<String, NonItem>() {
		private static final long serialVersionUID = -6565627091200982584L;

		{
			put("computer", new Computer(" above a Desk","", new LinkedList<Programs>(Arrays.asList(Programs.TXT, 
					Programs.ARCHIVE, Programs.BROWSER, Programs.VIDEOGAME, Programs.GAME))));
			put("desk", new Desk("", " Wooden"));
			put("bed", new Bed("", " red and white comfortable"));
			put("chair", new Chair("", " very comfortable"));
			put("armchair", new ArmChair("", " light brown leather"));
			put("shelf", new Shelf(" in front of the Desk", ""));
			put("bookshelf", new BookShelf("", ""));
		}
	};
	
	private static Map<String, Entity> entitys = new HashMap<String, Entity>() {
		private static final long serialVersionUID = -6565627091200982584L;

		{
			//put("mom", new EntityClass("Mom", 0, new ArrayList<Item>(Arrays.asList(new Book("Mom Advices", "")))));
		}
	};
	
	public BedRoom() {
		super(BEDROOM_NAME, BEDROOM_BIG_DESCRIPTION, BEDROOM_SMALL_DESCRIPTION, items, objects, entitys, Locations.NOWHERE.getValue(), Directions.NO_EXIT, Directions.NO_EXIT, Directions.NO_EXIT);
	}
}
