package tp1.logic;

import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.MetalWall;
import tp1.logic.gameobjects.Wall;

import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.ParachuterRole;
import tp1.logic.lemmingRoles.WalkerRole;
import tp1.exceptions.GameLoadException;
import tp1.exceptions.OffBoardException;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.GameObject;

/**
 * Clase principal del juego que gestiona la lógica, objetos y niveles del juego.
 */
public class Game implements GameModel, GameStatus, GameWorld{

	private int lems_to_win;
	private int lems_in_board;
	private GameObjectContainer container;
	private int game_cycle = 0;
	private int level; 
	private boolean exit = false;
	private GameConfiguration conf = FileGameConfiguration.NONE;
	
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
		if(conf == FileGameConfiguration.NONE) {
			this.container = new GameObjectContainer();
			resetGame_cycle();
			initGames(this.level);
		}
		else {
			this.container = new GameObjectContainer(conf.getGameObjects());
			this.lems_to_win = conf.numLemmingsToWin();
			this.game_cycle = conf.getCycle();
			this.lems_in_board = conf.numLemmingsInBoard();
			container.setFreedLemmings(conf.numLemmingsExit());
			container.setDeadlemmings(conf.numLemmingsDead());
		}
	}
	
	private void resetGame_cycle() {
		game_cycle = 0;
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
			initGame2();
		}
	}
	
	/**
	 * Inicializa el nivel 0 del juego, agregando paredes, lemmings y la puerta de salida.
	 */
	private void initGame0() {
		
		// Puerta de salida
		addObject(new ExitDoor(new Position(4, 5)));
		
		// Paredes
		addObject(new Wall(new Position(4, 6)));
		addObject(new Wall(new Position(5, 6)));
		addObject(new Wall(new Position(6, 6)));
		addObject(new Wall(new Position(7, 6)));
		addObject(new Wall(new Position(7, 5)));
		addObject(new Wall(new Position(8, 9)));
		addObject(new Wall(new Position(9, 9)));
		addObject(new Wall(new Position(8, 8)));
		addObject(new Wall(new Position(0, 9)));
		addObject(new Wall(new Position(1, 9)));
		addObject(new Wall(new Position(4, 4)));
		addObject(new Wall(new Position(3, 4)));
		addObject(new Wall(new Position(2, 4)));
		addObject(new Wall(new Position(8, 1)));
		addObject(new Wall(new Position(9, 1)));
		
		// Lemmings
		addObject(new Lemming(new Position(9, 0), this, new WalkerRole(), Direction.RIGHT, 0));
		addObject(new Lemming(new Position(2, 3), this, new WalkerRole(), Direction.RIGHT, 0));
		addObject(new Lemming(new Position(0, 8), this, new WalkerRole(), Direction.RIGHT, 0));
		
		lems_to_win = 2;
		lems_in_board = 3;

	}

	/**
	 * Inicializa el nivel 1 del juego, agregando paredes, lemmings y la puerta de salida.
	 */
	private void initGame1() {
		
		// Puerta de salida
		addObject(new ExitDoor(new Position(4, 5)));
		
		// Paredes
		addObject(new Wall(new Position(4, 6)));
		addObject(new Wall(new Position(5, 6)));
		addObject(new Wall(new Position(6, 6)));
		addObject(new Wall(new Position(7, 6)));
		addObject(new Wall(new Position(7, 5)));
		addObject(new Wall(new Position(8, 9)));
		addObject(new Wall(new Position(9, 9)));
		addObject(new Wall(new Position(8, 8)));
		addObject(new Wall(new Position(0, 9)));
		addObject(new Wall(new Position(1, 9)));
		addObject(new Wall(new Position(4, 4)));
		addObject(new Wall(new Position(3, 4)));
		addObject(new Wall(new Position(2, 4)));
		addObject(new Wall(new Position(8, 1)));
		addObject(new Wall(new Position(9, 1)));
		
		// Lemmings
		addObject(new Lemming(new Position(9, 0), this, new WalkerRole(), Direction.RIGHT, 0));
		addObject(new Lemming(new Position(2, 3), this, new WalkerRole(), Direction.RIGHT, 0));
		addObject(new Lemming(new Position(3, 3), this, new WalkerRole(), Direction.RIGHT, 0));
		addObject(new Lemming(new Position(0, 8), this, new WalkerRole(), Direction.RIGHT, 0));
		
		lems_to_win = 2;
		lems_in_board = 4;
	}
	
	private void initGame2() {
		
		// Paredes
		addObject(new Wall(new Position(4, 6)));
		addObject(new Wall(new Position(5, 6)));
		addObject(new Wall(new Position(6, 6)));
		addObject(new Wall(new Position(7, 6)));
		addObject(new Wall(new Position(7, 5)));
		addObject(new Wall(new Position(8, 9)));
		addObject(new Wall(new Position(9, 9)));
		addObject(new Wall(new Position(8, 8)));
		addObject(new Wall(new Position(0, 9)));
		addObject(new Wall(new Position(1, 9)));
		addObject(new Wall(new Position(4, 4)));
		addObject(new Wall(new Position(3, 4)));
		addObject(new Wall(new Position(2, 4)));
		addObject(new Wall(new Position(8, 1)));
		addObject(new Wall(new Position(9, 1)));
		addObject(new Wall(new Position(3, 5)));
		addObject(new MetalWall(new Position(3, 6)));
		
		// Lemmings
		addObject(new Lemming(new Position(9, 0), this, new WalkerRole(), Direction.RIGHT, 0));
		addObject(new Lemming(new Position(6, 0), this, new WalkerRole(), Direction.RIGHT, 0));
		addObject(new Lemming(new Position(6, 0), this, new ParachuterRole(), Direction.RIGHT, 0));
		addObject(new Lemming(new Position(0, 8), this, new WalkerRole(), Direction.RIGHT, 0));
		addObject(new Lemming(new Position(2, 3), this, new WalkerRole(), Direction.RIGHT, 0));
		addObject(new Lemming(new Position(3, 3), this, new WalkerRole(), Direction.RIGHT, 0));
		
		// Puerta de salida
		addObject(new ExitDoor(new Position(4, 5)));

		lems_to_win = 2;
		lems_in_board = 6;
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
		return container.numLemmingsInBoard(lems_in_board);
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
		return lems_to_win - numLemmingsExit();
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
	
	public void gameExit() {
		exit = true;
	}

	/**
	 * Comprueba si el juego ha terminado, ya sea porque el jugador ha ganado o perdido.
	 * 
	 * @return true si el juego ha terminado, false en caso contrario.
	 */
	public boolean isFinished() {
		return (playerLooses() || playerWins() || exit);
	}
	
	/**
	 * Comprueba si hay una pared en la posición especificada.
	 * 
	 * @param comparison Posición a comparar.
	 * @return true si hay una pared en la posición, false en caso contrario.
	 */
	public boolean isSolidAtPos(Position comparison) {
		return container.isSolidAtPos(comparison);
	}
	
	/**
	 * Comprueba si hay una puerta de salida en la posición especificada.
	 * 
	 * @param comparison Posición a comparar.
	 * @return true si hay una puerta de salida en la posición, false en caso contrario.
	 */
	public boolean isExitAtPos(Position comparison) {
		return container.isExitAtPos(comparison);
	}
	
	/**
	 * Agrega un GameObject al contenedor del juego.
	 * 
	 * @param o Objeto GameObject a agregar.
	 */
	public void addObject(GameObject o) {
		container.add(o);
	}
	
	/**
	 * Actualiza el estado del juego, moviendo los objetos y avanzando el ciclo del juego.
	 */
	public void update() {
		container.update();
		game_cycle++;
	}
	
	 /**
	 * Comprueba si la posición está en el borde del tablero.
	 * 
	 * @return true si la posición está en el borde, false en caso contrario.
	 */
	 public boolean isAtBorder(Position pos) {
			return (pos.getCol() == DIM_X||
					pos.getCol() == -1);
	}
		
	 /**
	 * Comprueba si la posición está fuera del tablero (en el vacío).
	 * @param pos objeto de tipo Position que indica la posición a comparar.
	 * @return true si la posición está en el vacío, false en caso contrario.
	 */
	public boolean isAtVoid(Position pos) {
			return (pos.getRow() >= DIM_Y);
	}
	
	 /**
	 * Comprueba si la posición está dentro del tablero.
	 * @param pos objeto de tipo Position que indica la posición a comparar.
	 * @return true si la posición está en el tablero, false en caso contrario.
	 */
	public boolean isInBoard(Position pos) {
		return ((pos.getCol() > -1 && pos.getCol() < DIM_X) &&
				(pos.getRow() > -1 && pos.getRow() < DIM_Y));
	}

	 /**
	 * LLama y devuelve el resultado del setRole del contenedor de objetos.
	 * @param role parametro de tipo LemmingRole que indica el rol del lemming.
	 * @param comparison objeto de tipo Position que indica la posición a comparar.
	 * @return true si el rol se ha aplicado correctamente, false en caso contrario.
	 * @throws OffBoardException 
	 */
	@Override
	public boolean setRole(LemmingRole role, Position comparison) throws OffBoardException {
		if(!isInBoard(comparison)) throw new OffBoardException("Position (" + comparison.getRow() + "," +
														       comparison.getCol() + ") is off board");
		return container.setRole(role, comparison);
	}
	
	 /**
	 * LLama y devuelve el resultado del receiveInteractionsFrom del contenedor de objetos.
	 * @param obj parametro de tipo GameItem que hace referencia al objeto.
	 * @return true si el rol se ha aplicado correctamente, false en caso contrario.
	 */
	@Override
	public boolean receiveInteractionsFrom(GameItem obj) {
		return container.receiveInteractionsFrom(obj);
	}

	@Override
	public void load(String fileName) throws GameLoadException {
		this.conf = new FileGameConfiguration(fileName, this);
		reset();
	}

	@Override
	public void stop(Position pos) {
		container.stop(pos);
	}

}
