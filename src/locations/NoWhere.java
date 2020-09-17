package locations;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import gameSystem.Directions;
import objects.*;

public class NoWhere extends LocationClass {

	private static final String NOWHERE_SMALL_DESCRIPTION = "Ooh... What is this place I can't go anywhere... Its all darkness...\n";
	private static final String NOWHERE_BIG_DESCRIPTION = NOWHERE_SMALL_DESCRIPTION + "Seems like I'm falling into a painless void...\n";
	
	private static final String NOWHERE_NAME = "NOWHERE";
	
	private static Map<String, LinkedList<Item>> items = new HashMap<String, LinkedList<Item>>() {
		private static final long serialVersionUID = -565691364300570895L; {}};
	
	private static Map<String, NonItem> objects = new HashMap<String, NonItem>() {
		private static final long serialVersionUID = -6565627091200982584L; {}};
	
	public NoWhere() {
		super(NOWHERE_NAME, NOWHERE_BIG_DESCRIPTION, NOWHERE_SMALL_DESCRIPTION, items, objects, 0, Directions.NO_EXIT, Directions.NO_EXIT, Directions.NO_EXIT);
	}
}
