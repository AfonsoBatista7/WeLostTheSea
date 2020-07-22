package objects;

public interface Item extends Object {
	
	/**
	 * @return Item name.
	 */
	String getItemName();
	
	/**
	 * @param name - New item name.
	 */
	void setItemName(String name);
}
