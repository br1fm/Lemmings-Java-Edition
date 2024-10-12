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
		
		addWalls(new Wall(4, 6));
		addWalls(new Wall(5, 6));
		addWalls(new Wall(6, 6));
		addWalls(new Wall(7, 6));
		addWalls(new Wall(7, 5));
		addWalls(new Wall(8, 9));
		addWalls(new Wall(9, 9));
		addWalls(new Wall(8, 8));
		addWalls(new Wall(0, 9));
		addWalls(new Wall(1, 9));
		addWalls(new Wall(4, 4));
		addWalls(new Wall(3, 4));
		addWalls(new Wall(2, 4));
		addWalls(new Wall(8, 1));
		addWalls(new Wall(9, 1));
		
		addExitDoor(new ExitDoor(new Position(4, 5)));
		
		addLemmings(new Lemming(new Position (9, 0), this));
		addLemmings(new Lemming(new Position (2, 3), this));

	}
	
	private void initGame1() {
		
		addWalls(new Wall(4, 6));
		addWalls(new Wall(5, 6));
		addWalls(new Wall(6, 6));
		addWalls(new Wall(7, 6));
		addWalls(new Wall(7, 5));
		addWalls(new Wall(8, 9));
		addWalls(new Wall(9, 9));
		addWalls(new Wall(8, 8));
		addWalls(new Wall(0, 9));
		addWalls(new Wall(1, 9));
		addWalls(new Wall(4, 4));
		addWalls(new Wall(3, 4));
		addWalls(new Wall(2, 4));
		addWalls(new Wall(8, 1));
		addWalls(new Wall(9, 1));
		
		addExitDoor(new ExitDoor(new Position(4, 5)));
		
		addLemmings(new Lemming(new Position (9, 0), this));
		addLemmings(new Lemming(new Position (2, 3), this));
		addLemmings(new Lemming(new Position (3, 3), this));
		addLemmings(new Lemming(new Position (0, 8), this));
		
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
		return ((2 - container.numLemmingsExit()));
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
	
	
	public boolean isWallAtPos(Position comparison) {
		return container.isWallAtPos(comparison);
	}
	
	public boolean isDoorAtPos(Position comparison) {
		return container.isDoorAtPos(comparison);
	}
	
	//CAMBIO: pasar como parametro un tipo Lemming
	//TODO: tanto los parámetros de addLemmings como el de addWalls están sacados del coño
	private void addLemmings(Lemming lemming) {
		container.add(lemming);

	}
	
	//CAMBIO: pasar como parametro un tipo Wall
	private void addWalls(Wall wall) {
		container.add(wall);

	}
	
	private void addExitDoor(ExitDoor exitDoor) {
		container.add(exitDoor);
	}
	
	public void update() {
		container.update();
		game_cycle++;
	}

	
	
}
