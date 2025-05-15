package org.afonsobatista.objects.nonItems;

import org.afonsobatista.gameSystem.Propertys;
import org.afonsobatista.objects.*;

/**
 * @author Afonso Batista
 *
 */
public class Desk extends NonItemClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2546869323896330184L;
	
	private static final String TYPE = "Desk";
	private static final Propertys[] PROPERTY = {Propertys.PUT};
	
	public Desk(String direction, String description) {
		super(TYPE, direction, description, PROPERTY);	
	}
	

}
