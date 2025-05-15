package org.afonsobatista.objects.nonItems;

import org.afonsobatista.gameSystem.Propertys;
import org.afonsobatista.objects.*;

/**
 * @author Afonso Batista
 *
 */
public class ArmChair extends NonItemClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6384316036197636541L;
	
	private static final String TYPE = "ArmChair";
	private static final Propertys[] PROPERTY = {Propertys.SIT};
	
	public ArmChair(String direction, String description) {
		super(TYPE, direction, description, PROPERTY);
	}

}
