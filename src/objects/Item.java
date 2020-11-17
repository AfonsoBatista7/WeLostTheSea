package objects;

/**
 * @author Afonso Batista
 */
public interface Item extends Object {
	
	/**
	 * @return Item name.
	 */
	String getItemName();
	
	/**
	 * Sets a new name for the item.
	 * @param name - New item name.
	 */
	void setItemName(String name);
}
