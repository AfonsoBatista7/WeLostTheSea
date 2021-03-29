package miniGames;
import java.util.Random;

public class PCgame {

	private int tryNum, randomNum;
	
	
	public PCgame(int range, int tryNum) {
		this.tryNum = tryNum;
		randomNum = generateNumber(range);
	}
	
	public int getRandomNum() {
		return randomNum;
	}
	
	public int getTrys() {
		return tryNum;
	}
	
	public void decTrys() {
		tryNum--;
	}
	
	private int generateNumber(int range) {
		Random rand = new Random();
		return rand.nextInt(range);	
	}
	
	public boolean playerWin(int guess) {
		return guess == randomNum;
	}
	
	public boolean isGreaterThan(int guess) {
		return guess > randomNum;
	}
	
	public boolean noTry() {
		return tryNum==0;
	}
	
}