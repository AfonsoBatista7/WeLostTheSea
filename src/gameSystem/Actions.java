package gameSystem;

public enum Actions {
	STAND(0), SIT(1), LAY(2);
	
	private int value;
	
	Actions(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
