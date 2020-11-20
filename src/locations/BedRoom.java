package locations;

import java.util.*;

import entity.Entity;
import entity.EntityClass;
import gameSystem.Directions;
import objects.items.*;
import objects.*;
import objects.nonItems.*;

/**
 * The player BedRoom.
 * @author Afonso Batista
 */
/**
 * @author Afonso Batista
 *
 */
public class BedRoom extends LocationClass {
	
	private static final String BEDROOM_SMALL_DESCRIPTION = "There's a beautiful day outside...\n";
	
	private static final String BEDROOM_BIG_DESCRIPTION = BEDROOM_SMALL_DESCRIPTION + "You can see the sun rays entering "
			+ "by the BedRoom window and warming you...\n";
	
	private static final String BEDROOM_NAME = "%s'S BEDROOM";
	
	private static Map<String, LinkedList<Item>> items = new HashMap<String, LinkedList<Item>>() {
		private static final long serialVersionUID = -565691364300570895L;

		{
			put("book", new LinkedList<Item>(Arrays.asList(new Book("Instruction Manual",""), new Book("Diary",""), new Book())));
			put("sword", new LinkedList<Item>(Arrays.asList(new ItemClass("Sword","", "Master Sword"))));
			put("coin", new LinkedList<Item>(Arrays.asList(new Coin())));
		}
	};
	
	//List of objects in this location.
	private static Map<String, NonItem> objects = new HashMap<String, NonItem>() {
		private static final long serialVersionUID = -6565627091200982584L;

		{
			put("computer", new Computer(" above a Desk",""));
			put("desk", new Desk("", " Wooden"));
			put("bed", new Bed("", " red and white comfortable"));
			put("armchair", new ArmChair("", " light brown leather"));
			put("shelf", new Shelf(" in front of the Desk", ""));
			put("bookshelf", new BookShelf("", ""));
		}
	};
	
	private static Map<String, Entity> entitys = new HashMap<String, Entity>() {
		private static final long serialVersionUID = -6565627091200982584L;

		{
			put("mom", new EntityClass("Mom", 0));
		}
	};
	
	public BedRoom() {
		super(BEDROOM_NAME, BEDROOM_BIG_DESCRIPTION, BEDROOM_SMALL_DESCRIPTION, items, objects, entitys, 1, Directions.NO_EXIT, Directions.NO_EXIT, Directions.NO_EXIT);
	}
}
