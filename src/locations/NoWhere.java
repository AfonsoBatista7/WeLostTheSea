package locations;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import objects.*;

public class NoWhere extends LocationClass {

	private static final String NOWHERE_DESCRIPTION = "There's a beautiful day outside...\n"
			+ "You can see the sun rays entering by the BedRoom window and warming you...\n";
	private static final String NOWHERE_SMALL_DESCRIPTION = "";
	
	private static final String NOWHERE_NAME = "NOWHERE";
	
	private static Map<String, LinkedList<Item>> items = new HashMap<String, LinkedList<Item>>() {
		private static final long serialVersionUID = -565691364300570895L; {}};
	
	private static Map<String, NonItem> objects = new HashMap<String, NonItem>() {
		private static final long serialVersionUID = -6565627091200982584L; {}};
	
	public NoWhere() {
		super(NOWHERE_NAME, NOWHERE_DESCRIPTION, NOWHERE_SMALL_DESCRIPTION, items, objects, Directions.NO_EXIT, Directions.NO_EXIT, Directions.NO_EXIT, Directions.NO_EXIT);
	}
}
