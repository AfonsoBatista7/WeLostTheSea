package locations;

import java.util.*;
import objects.items.*;
import objects.*;
import objects.nonItems.*;
import objects.Object;

public class BedRoom extends LocationClass {
	
	private static final String BEDROOM_BIG_DESCRIPTION = "There's a beautiful day outside...\n"
			+ "You can see the sun rays entering by the BedRoom window and warming you...\n";
	private static final String BEDROOM_SMALL_DESCRIPTION = "";
	
	private static final String BEDROOM_NAME = "%s'S BEDROOM";
	
	private static Map<String, LinkedList<Item>> items = new HashMap<String, LinkedList<Item>>() {
		private static final long serialVersionUID = -565691364300570895L;

		{
			put("book", new LinkedList<Item>(Arrays.asList(new Book("Instruction Manual",""), new Book("Diary",""), new Book())));
			put("sword", new LinkedList<Item>(Arrays.asList(new ItemClass("Sword","", "Master Sword"))));
		}
	};
	
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
	
	public BedRoom() {
		super(BEDROOM_NAME, BEDROOM_BIG_DESCRIPTION, BEDROOM_SMALL_DESCRIPTION, items, objects, 1, Directions.NO_EXIT, Directions.NO_EXIT, Directions.NO_EXIT);
	}
}
