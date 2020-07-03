package items;

public class ItemClass implements Item {

	private String type, name, description;
	
	public ItemClass(String type, String description) {
		this.type = type;
		this.description = description;
		name = type;
	}
	
	public String getItemType() {
		return type;
	}
	
	public String getItemName() {
		return name;
	}
	
	public void setItemName(String name) {
		this.name = name;
	}
	
	public String getItemDescription() {
		return description;
	}
}
