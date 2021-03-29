package items;

public interface Item {

	void incQuantity(int quantity);
	void decQuantity(int quantity);
	int getQuantity();
	void setQuantity(int quantity);
	String getItemName();
	
	
}
