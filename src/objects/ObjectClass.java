package objects;

import java.io.Serializable;

/**
 * @author Afonso Batista
 *
 */
public class ObjectClass implements Object, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2103035688559547552L;
	
	private String type, description;
	
	public ObjectClass(String type, String description) {
		this.type = type;
		this.description = description;
	}
	
	public String getObjectType() {
		return type;
	}
	
	public String getObjectDescription() {
		return description;
	}
	
}
