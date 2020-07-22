package locations;

import java.util.*;
import objects.items.*;
import objects.*;
import objects.nonItems.*;
import objects.Object;

public class BedRoom extends LocationClass {
	
	private static final String BEDROOM_DESCRIPTION = "There's a beautiful day outside...\n"
			+ "You can see the sun rays entering by the BedRoom window and warming you...\n";
	
	private static final String BEDROOM_NAME = "%s'S BEDROOM";
	
	private static Map<String, LinkedList<Item>> items = new HashMap<String, LinkedList<Item>>() {
		private static final long serialVersionUID = -565691364300570895L;

		{
			put("book", new LinkedList<Item>(Arrays.asList(new Book("Instruction Manual",""), new Book("Diary",""), new Book())));	
		}
	};
	
	private static Map<String, Object> objects = new HashMap<String, Object>() {
		private static final long serialVersionUID = -6565627091200982584L;

		{
			put("computer", new Computer("above a Desk",""));
			put("desk", new Desk("", "Wooden"));
			put("bed", new ObjectClass("", "red and white comfortable"));
			put("armchair", new ObjectClass("", "light brown leather"));
			put("shelf", new ObjectClass("in front of the Desk", ""));
			put("bookshelf", new ObjectClass("", ""));
		}
	};
	
	public BedRoom() {
		super(BEDROOM_NAME, BEDROOM_DESCRIPTION, items, objects, Directions.NO_EXIT, Directions.NO_EXIT, Directions.NO_EXIT, Directions.NO_EXIT);
	}
}
