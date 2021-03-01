package gameSystem;

public enum Locations {
	DREAM(0), BEDROOM(1), NOWHERE(2);
	
	private int value;
	
	Locations(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
