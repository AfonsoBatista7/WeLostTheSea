package items;

public class ItemClass implements Item {

	protected String itemName;
	protected int quantity;
	
	public ItemClass(String itemName, int quantity) {
		this.itemName = itemName;
		this.quantity = quantity;
	}
	
	public ItemClass(String itemName) {
		this.itemName = itemName;
	}
	
	public void incQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	public void decQuantity(int quantity) {
		this.quantity -= quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getItemName() {
		return itemName;
	}
}
