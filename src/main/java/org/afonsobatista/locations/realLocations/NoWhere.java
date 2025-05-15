package org.afonsobatista.locations.realLocations;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.afonsobatista.entity.Entity;
import org.afonsobatista.gameSystem.Directions;
import org.afonsobatista.gameSystem.Locations;
import org.afonsobatista.locations.LocationClass;
import org.afonsobatista.objects.*;

/**
 * NoWhere location.
 * @author Afonso Batista
 */
public class NoWhere extends LocationClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3582525387350679900L;
	
	private static final String NOWHERE_SMALL_DESCRIPTION = "Ooh... What is this place I can't go anywhere... Its all darkness...\n";
	private static final String NOWHERE_BIG_DESCRIPTION = NOWHERE_SMALL_DESCRIPTION + "Seems like I'm falling into a painless void...\n";
	
	private static final String NOWHERE_NAME = "NOWHERE";
	
	private static Map<String, LinkedList<Item>> items = new HashMap<String, LinkedList<Item>>() {
		private static final long serialVersionUID = -565691364300570895L; {}};
	
	private static Map<String, NonItem> objects = new HashMap<String, NonItem>() {
		private static final long serialVersionUID = -6565627091200982584L; {}};
		
		private static Map<String, Entity> entitys = new HashMap<String, Entity>() {
			private static final long serialVersionUID = -6565627091200982584L; {}};
	
	public NoWhere() {
		super(NOWHERE_NAME, NOWHERE_BIG_DESCRIPTION, NOWHERE_SMALL_DESCRIPTION, items, objects, entitys, Locations.BEDROOM.getValue(), Directions.NO_EXIT, Directions.NO_EXIT, Directions.NO_EXIT);
	}
}
