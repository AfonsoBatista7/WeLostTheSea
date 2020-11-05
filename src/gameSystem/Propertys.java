package gameSystem;

/**
 * All the possible properties a object can have.
 * @author Afonso Batista
 */
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
