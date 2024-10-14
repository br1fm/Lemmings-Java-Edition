package tp1.logic;

import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.logic.gameobjects.ExitDoor;

/**
 * Clase principal del juego que gestiona la lógica, objetos y niveles del juego.
 */
public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	private int lems_to_win;
	private GameObjectContainer container;
	private int game_cycle = 0;
	private int level; 
	
	/**
	 * Constructor de la clase Game.
	 * Inicializa el contenedor de objetos del juego y carga el nivel especificado.
	 * 
	 * @param nLevel Nivel del juego que se desea inicializar.
	 */
	public Game(int nLevel) {
		this.container = new GameObjectContainer();
		initGames(nLevel);
		this.level = nLevel;
	}
	
	/**
	 * Reinicia el juego al estado inicial del nivel actual.
	 */
	public void reset() {
		this.container = new GameObjectContainer();
		initGames(this.level);
	}
	
	/**
	 * Inicializa el juego de acuerdo con nLevel.
	 * 
	 * @param nLevel Nivel del juego que se desea inicializar.
	 */
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
	
	/**
	 * Inicializa el nivel 0 del juego, agregando paredes, lemmings y la puerta de salida.
	 */
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
		addLemmings(new Lemming(new Position (3, 3), this));
		addLemmings(new Lemming(new Position (0, 8), this));
		lems_to_win = 2;

	}
	
	/**
	 * Inicializa el nivel 1 del juego, agregando paredes, lemmings y la puerta de salida.
	 */
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
		lems_to_win = 2;
		
	}
	
	/**
	 * Devuelve el número del ciclo actual del juego.
	 * 
	 * @return Número de ciclo del juego.
	 */
	public int getCycle() {
		return game_cycle;
	}

	/**
	 * Devuelve el número de lemmings que actualmente están en el tablero.
	 * 
	 * @return Número de lemmings en el tablero.
	 */
	public int numLemmingsInBoard() {
		return container.numLemmingsInBoard();
	}

	/**
	 * Devuelve el número de lemmings que han muerto.
	 * 
	 * @return Número de lemmings muertos.
	 */
	public int numLemmingsDead() {
		return container.numLemmingsDead();
	}

	/**
	 * Devuelve el número de lemmings que salieron por la puerta.
	 * 
	 * @return Número de lemmings liberados.
	 */
	public int numLemmingsExit() {
		return container.numLemmingsExit();
	}

	/**
	 * Devuelve el número de lemmings que aún necesitan alcanzar la puerta de salida
	 * para ganar el juego.
	 * 
	 * @return Número de lemmings restantes para ganar.
	 */
	public int numLemmingsToWin() {
		return ((lems_to_win - container.numLemmingsExit()));
	}

	/**
	 * Devuelve un string del contenido de una celda del tablero.
	 * 
	 * @param col Columna de la posición.
	 * @param row Fila de la posición.
	 * @return Representación del objeto en la posición.
	 */
	public String positionToString(int col, int row) {
		return container.positionToString(col, row);
	}

	/**
	 * Comprueba si el jugador ha ganado el juego.
	 * 
	 * @return true si el jugador ha ganado, false en caso contrario.
	 */
	public boolean playerWins() {
		return (numLemmingsToWin() == 0);
	}


	/**
	 * Comprueba si el jugador ha perdido el juego.
	 * 
	 * @return true si el jugador ha perdido, false en caso contrario.
	 */
	public boolean playerLooses() {
		return (numLemmingsInBoard() == 0 && numLemmingsToWin() != 0);
	}

	/**
	 * Comprueba si el juego ha terminado, ya sea porque el jugador ha ganado o perdido.
	 * 
	 * @return true si el juego ha terminado, false en caso contrario.
	 */
	public boolean gameEnds() {
		return (playerLooses() || playerWins());
	}
	
	/**
	 * Comprueba si hay una pared en la posición especificada.
	 * 
	 * @param comparison Posición a comparar.
	 * @return true si hay una pared en la posición, false en caso contrario.
	 */
	public boolean isWallAtPos(Position comparison) {
		return container.isWallAtPos(comparison);
	}
	
	/**
	 * Comprueba si hay una puerta de salida en la posición especificada.
	 * 
	 * @param comparison Posición a comparar.
	 * @return true si hay una puerta de salida en la posición, false en caso contrario.
	 */
	public boolean isDoorAtPos(Position comparison) {
		return container.isDoorAtPos(comparison);
	}
	
	/**
	 * Agrega un lemming al contenedor del juego.
	 * 
	 * @param lemming Objeto Lemming a agregar.
	 */
	private void addLemmings(Lemming lemming) {
		container.add(lemming);

	}
	

	/**
	 * Agrega una pared al contenedor del juego.
	 * 
	 * @param wall Objeto Wall a agregar.
	 */
	private void addWalls(Wall wall) {
		container.add(wall);

	}
	
	/**
	 * Agrega una puerta de salida al contenedor del juego.
	 * 
	 * @param exitDoor Objeto ExitDoor a agregar.
	 */
	private void addExitDoor(ExitDoor exitDoor) {
		container.add(exitDoor);
	}
	
	/**
	 * Actualiza el estado del juego, moviendo los objetos y avanzando el ciclo del juego.
	 */
	public void update() {
		container.update();
		game_cycle++;
	}
	
}
