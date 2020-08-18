package objects;

public class ItemClass extends ObjectClass implements Item {

	private String name;
	
	public ItemClass(String type, String description) {
		super(type, description);
		name = type;
	}
	
	public ItemClass(String type, String description, String name) {
		super(type, description);
		this.name = name;
	}
	
	public String getItemName() {
		return name;
	}
	
	public void setItemName(String name) {
		this.name = name;
	}
	
}
