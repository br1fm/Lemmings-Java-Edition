package tp1.logic;

/**
 * Define los métodos para gestionar y obtener el estado de un juego.
 * Esta interfaz proporciona las funcionalidades para verificar el estado del jugador,
 * así como obtener información sobre los lemmings en el tablero.
 */
public interface GameStatus {


    /**
     * Dimensión del tablero del juego en el eje X.
     */
	public static final int DIM_X = 10;
	
	/**
     * Dimensión del tablero del juego en el eje Y.
     */
	public static final int DIM_Y = 10;
	
	 /**
     * Verifica si el jugador ha perdido la partida.
     * 
     * @return true si el jugador pierde, false en caso contrario.
     */
	boolean playerLooses();
	
	/**
     * Verifica si el jugador ha ganado la partida.
     * 
     * @return true si el jugador gana, false en caso contrario.
     */
	boolean playerWins();
	
	/**
     * Convierte una posición (columna, fila) en una cadena de texto representativa.
     * 
     * @param col La columna de la posición.
     * @param row La fila de la posición.
     * @return Una cadena que representa la posición en formato de texto.
     */
	String positionToString(int col, int row);
	
	/**
     * Obtiene el número total de lemmings presentes en el tablero.
     * 
     * @return El número de lemmings en el tablero.
     */
	int numLemmingsInBoard();
	
	 /**
     * Obtiene el número de lemmings necesarios para que el jugador gane.
     * 
     * @return El número de lemmings necesarios para ganar.
     */
	int numLemmingsToWin();
	
	 /**
     * Obtiene el número de lemmings que han salido del tablero.
     * 
     * @return El número de lemmings que han escapado.
     */
	int numLemmingsExit();
	
	/**
     * Obtiene el número de lemmings muertos en el juego.
     * 
     * @return El número de lemmings muertos.
     */
	int numLemmingsDead();
	
	/**
     * Obtiene el ciclo actual del juego.
     * 
     * @return El número del ciclo actual.
     */
	int getCycle();

}
