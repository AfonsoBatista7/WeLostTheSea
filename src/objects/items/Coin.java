package objects.items;

import objects.ItemClass;

public class Coin extends ItemClass {
	private static final String TYPE = "Coin",
			DESCRIPTION = "A, sometimes valuable item, you can used it as a form of payment to optime other items";
	
	private int value;
	
	public Coin() {
		super(TYPE, DESCRIPTION);
		value=10;
	}
	
	public int getCoinValue() {
		return value;
	}
}
