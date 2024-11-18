package tp1.logic;

import tp1.logic.gameobjects.GameItem;

/**
 * Define los métodos para interactuar con el mundo del juego.
 * Esta interfaz proporciona funciones para verificar las características de las posiciones
 * dentro del tablero y gestionar las interacciones entre los objetos del juego.
 */
public interface GameWorld {

	/**
     * Verifica si una posición está fuera del mundo del juego (vacío).
     * 
     * @param pos La posición a verificar.
     * @return true si la posición está fuera del mundo, false en caso contrario.
     */
	boolean isAtVoid(Position pos);
	
	/**
     * Verifica si una posición es sólida, es decir, si es una superficie o estructura que no puede ser atravesada.
     * 
     * @param pos La posición a verificar.
     * @return true si la posición es sólida, false en caso contrario.
     */
	boolean isSolidAtPos(Position pos); 
	
	/**
     * Verifica si una posición está en el borde del tablero del juego.
     * 
     * @param pos La posición a verificar.
     * @return true si la posición está en el borde, false en caso contrario.
     */
	boolean isAtBorder(Position pos);
	
	/**
     * Verifica si una posición corresponde a una puerta de salida.
     * 
     * @param pos La posición a verificar.
     * @return true si la posición es una puerta de salida, false en caso contrario.
     */
	boolean isExitAtPos(Position pos);  
	
	/**
     * Permite que el mundo del juego reciba interacciones de un objeto.
     * 
     * @param obj El objeto que realiza la interacción.
     * @return true si la interacción fue exitosa, false en caso contrario.
     */
	public boolean receiveInteractionsFrom(GameItem obj);
	
	/**
     * Verifica si una posición está dentro de los límites del tablero.
     * 
     * @param pos La posición a verificar.
     * @return true si la posición está dentro del tablero, false si está fuera.
     */
	public boolean isInBoard(Position pos);
	
}
