package locations;

import items.Item;

public class NoWhere extends LocationClass{

	private static Item[] items = {};
	
	public NoWhere() {
		super("NoWhere", items);
	}
	
}
