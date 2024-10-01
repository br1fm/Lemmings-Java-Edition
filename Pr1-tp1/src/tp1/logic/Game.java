package tp1.logic;

import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	private GameObjectContainer container;
	private int game_cycle = 0;
	//CAMBIO: Variable para el num inicial de lemmings/walls, 
	//luego hay que quitarlo, solo para pruebas y tal
	public static final int N_LEMMINGS = 1;
	public static final int N_WALLS = 1;
	
	public Game(int nLevel) {
		//CAMBIO: en el futuro número lemmings / walls viene determinado por nLevel?
		this.container = new GameObjectContainer(N_LEMMINGS, N_WALLS);
		addLemmings(nLevel);
		addWalls(nLevel);
	}

	public int getCycle() {
		return game_cycle;
	}

	public int numLemmingsInBoard() {
		return container.numLemmingsBoard();
		//return 0;
	}

	public int numLemmingsDead() {
		//return N_LEMMINGS - numLemmingsInBoard();
		return 0;
	}

	public int numLemmingsExit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int numLemmingsToWin() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String positionToString(int col, int row) {
		// TODO Auto-generated method stub
		return container.positionToString(col, row);
	}

	public boolean playerWins() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean playerLooses() {
		// TODO Auto-generated method stub
		return false;
	}

	public String help() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//CAMBIO: tanto los parámetros de addLemmings como el de addWalls están sacados del coño
	private void addLemmings(int nLevel) {
		//CAMBIO: Cambiar en cuanto se pueda. Por ahora solo añado uno
		container.add(new Lemming(0,2));
	}
	
	private void addWalls(int nLevel) {
		container.add(new Wall(2,3));
	}
	
	public void update() {
		game_cycle++;
	}
	
	public void move() {

	}
}
