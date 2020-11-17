package objects;

/**
 * @author Afonso Batista
 *
 */
public class ObjectClass implements Object {

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
