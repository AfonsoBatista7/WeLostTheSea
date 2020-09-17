package gameSystem;

public enum Propertys {
	USE(0), SIT(1), LAY(2), PUT(3);
	
	public int value;
	
	Propertys(int value) {
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
}
