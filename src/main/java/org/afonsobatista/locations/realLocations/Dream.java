package org.afonsobatista.locations.realLocations;

import java.util.*;

import org.afonsobatista.entity.*;
import org.afonsobatista.entity.entities.*;
import org.afonsobatista.gameSystem.*;
import org.afonsobatista.locations.*;
import org.afonsobatista.objects.*;

/**
 * The Player Dream.
 * @author Afonso Batista
 */
public class Dream extends LocationClass {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -864104470026276900L;

	private static final String DREAM_SMALL_DESCRIPTION = "[You are on a beautiful beach with bright sand and crystal water, "
		+ "the air is neither hot or cold. the sun light reflects on the sea and warms " 
		+ "your skin, bones and soul like a fireplace on a cold day of winter. You feel like everything is happyness and joy.]\n";
	
	private static final String DREAM_NAME = "";
		
		private static Map<String, LinkedList<Item>> items = new HashMap<String, LinkedList<Item>>() {
			private static final long serialVersionUID = -565691364300570895L;

			{	
			}
		};
		
		//List of objects in this location.
		private static Map<String, NonItem> objects = new HashMap<String, NonItem>() {
			private static final long serialVersionUID = -6565627091200982584L;

			{
			}
		};
		
		private static Map<String, Entity> entitys = new HashMap<String, Entity>() {
			private static final long serialVersionUID = -6565627091200982584L;

			{
				put("sailon", new Sailon(Actions.STAND));
			}
		};
		
		public Dream() {
			super(DREAM_NAME, DREAM_SMALL_DESCRIPTION, DREAM_SMALL_DESCRIPTION, items, objects, entitys, Directions.NO_EXIT, Directions.NO_EXIT, Directions.NO_EXIT, Directions.NO_EXIT);
		}
}
