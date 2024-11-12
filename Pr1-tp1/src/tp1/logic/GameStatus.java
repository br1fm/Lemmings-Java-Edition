package tp1.logic;

public interface GameStatus {

	//Preguntar si está bien
	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	
	boolean playerLooses();
	boolean playerWins();
	String positionToString(int col, int row);
	int numLemmingsInBoard();
	int numLemmingsToWin();
	int numLemmingsExit();
	int numLemmingsDead();
	int getCycle();

}
