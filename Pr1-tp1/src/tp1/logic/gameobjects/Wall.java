package tp1.logic.gameobjects;

import tp1.logic.Position;

/**
 * Clase que representa una pared en el tablero del juego.
 */
public class Wall {
	
	private Position pos;
	
	/**
	 * Constructor de la clase Wall.
	 * 
	 * @param col Columna de la posición de la wall.
	 * @param row Fila de la posición de la wall.
	 */
	public Wall(int col, int row) {
		pos = new Position(col, row);
	}
	
	/**
	 * Devuelve una representación en cadena de la pared.
	 * 
	 * @return Una cadena que representa la pared.
	 */
	@Override
	public String toString() {
		return "▓▓▓▓▓";
	}
	
	/**
	 * Comprueba si la pared está en la posición especificada.
	 * 
	 * @param comparison La posición con la que se va a comparar.
	 * @return true si la pared está en la posición proporcionada, false en caso contrario.
	 */
	public Boolean isAtPosition(Position comparison) {
		return (comparison.equals(pos));
	}
	
	/**
	 * Actualiza el estado de la pared.
	 * No hace nada en el caso del objeto wall.
	 */
	public void update() {}
}
