package items;

public class Sword extends ItemClass{

	private int damage;
	private String swordName = itemName;
	
	public Sword(int mainDamage, String itemName, int quantity) {
		super(itemName, quantity);
		damage = mainDamage;
	}
	
	public void enchantSword(int newDamage) {
		damage = newDamage;
	}
	
	public int getSwordDamage() {
		return damage;
	}
	
	public void rename(String name) {
		swordName = name;
	}
	
	public String getSwordName() {
		return swordName;
	}
}


