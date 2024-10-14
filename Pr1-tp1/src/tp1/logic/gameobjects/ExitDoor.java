package tp1.logic.gameobjects;

import tp1.logic.Position;

/**
 * Clase que representa la puerta de salida en el tablero del juego.
 */
public class ExitDoor {
	
	private Position pos;
	

	/**
	 * Constructor de la clase ExitDoor.
	 * 
	 * @param pos Posición de la puerta de salida.
	 */
	public ExitDoor(Position pos) {
		this.pos = pos;
	}
	
	/**
	 * Devuelve una representación en string de la exit door.
	 * 
	 * @return Una cadena que representa la puerta de salida.
	 */
	@Override
	public String toString() {
		return "🚪";
	}
	
	/**
	 * Comprueba si la exit door está en la posición especificada.
	 * 
	 * @param comparison La posición con la que se va a comparar.
	 * @return true si la puerta de salida está en la posición pasada por parámetro, false en caso contrario.
	 */
	public Boolean isAtPosition(Position comparison) {
		return (comparison.equals(pos));
	}
	
}
