package items;

public interface Item {

	/**
	 * @return Item type.
	 */
	String getItemType();
	
	/**
	 * @return Item name.
	 */
	String getItemName();
	
	/**
	 * @return Item description.
	 */
	String getItemDescription();
	
	/**
	 * @param name - New item name.
	 */
	void setItemName(String name);
}
