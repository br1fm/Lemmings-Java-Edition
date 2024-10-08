package tp1.logic;

import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.logic.gameobjects.ExitDoor;

public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	private GameObjectContainer container;
	private int game_cycle = 0;
	
	public Game(int nLevel) {
		this.container = new GameObjectContainer();
		initGames(nLevel);
	}
	
	private void initGames(int nLevel) {
		switch (nLevel) {
		case 0:
			initGame0();
			break;
		case 1:
			initGame1();
			break;
		default:
			System.out.println("Level not supported !");
		}
	}
	
	private void initGame0() {
		addWalls(new Wall(2, 5));
	}
	
	private void initGame1() {
		
	}
	
	public int getCycle() {
		return game_cycle;
	}

	public int numLemmingsInBoard() {
		return container.numLemmingsInBoard();
	}

	public int numLemmingsDead() {
		return container.numLemmingsDead();
	}

	public int numLemmingsExit() {
		return container.numLemmingsExit();
	}

	//TODO: implementar esta función (cambiar el 2)
	public int numLemmingsToWin() {
		return ((container.numLemmingsExit() - 2));
	}

	public String positionToString(int col, int row) {
		return container.positionToString(col, row);
	}

	public boolean playerWins() {
		return (numLemmingsToWin() == 0);
	}

	public boolean playerLooses() {
		return (numLemmingsInBoard() == 0 && numLemmingsToWin() != 0);
	}

	public boolean gameEnds() {
		return (playerLooses() || playerWins());
	}
	
	public String help() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("\n")
	      .append("Available commands:\r\n")
	      .append("[r]eset: start a new game\r\n")
	      .append("[h]elp: print this help message\r\n")
	      .append("[e]xit: end the execution of the game\r\n")
	      .append("[n]one | \"\": skips cycle\n");
	    
	    return sb.toString();
	}
	
	public boolean isWallAtPos(Position comparison) {
		return container.isWallAtPos(comparison);
	}
	
	public boolean isDoorAtPos(Position comparison) {
		return container.isDoorAtPos(comparison);
	}
	
	//CAMBIO: pasar como parametro un tipo Lemming
	//TODO: tanto los parámetros de addLemmings como el de addWalls están sacados del coño
	private void addLemmings(Lemming lemming) {
		container.add(new Lemming(new Position(2,4), this));
		container.add(new Lemming(new Position(5,4), this));
	}
	
	//CAMBIO: pasar como parametro un tipo Wall
	private void addWalls(Wall wall) {
		container.add(wall);
		/*container.add(new Wall(3, 5));
		container.add(new Wall(4, 5));
		container.add(new Wall(5, 5));
		container.add(new Wall(6, 5));
		container.add(new Wall(6, 4));
		container.add(new Wall(1, 7));*/
		//container.add(new Wall(3, 4));
	}
	
	private void addExitDoor(ExitDoor exitDoor) {
		container.add(new ExitDoor(new Position(1, 6)));
	}
	
	public void update() {
		container.update();
		game_cycle++;
	}
	
	
}
