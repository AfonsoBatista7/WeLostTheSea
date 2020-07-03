package locations;

import java.util.*;
import items.*;

public class BedRoom extends LocationClass {
	
	private static final String BEDROOM_DESCRIPTION = "There's a beautiful day outside...\n"
			+ "You can see the sun rays entering by the BedRoom window and warming you...\n";
	
	private static final String BEDROOM_NAME = "'s BEDROOM";
	
	private static Map<String, LinkedList<Item>> items = new HashMap<String, LinkedList<Item>>() {
		private static final long serialVersionUID = -565691364300570895L;

		{
			put("book", new LinkedList<Item>(Arrays.asList(new ItemClass("Book","first"), new ItemClass("Book","second"), new ItemClass("Book","third"))));
		}
	};
	
	public BedRoom() {
		super(BEDROOM_NAME, BEDROOM_DESCRIPTION, items, Directions.NO_EXIT, Directions.NO_EXIT, Directions.NO_EXIT, Directions.NO_EXIT);
	}
}
