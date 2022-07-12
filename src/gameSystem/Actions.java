package gameSystem;

/**
 * All actions a entity can have with the specific object. 
 * @author Afonso Batista
 *
 */
public enum Actions {
	NOTHING(-1), STAND(0), SIT(1), LAY(2), PUT(3), USE(4);
	
	private int value;
	
	Actions(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
