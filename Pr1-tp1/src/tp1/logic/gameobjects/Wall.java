package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;

/**
 * Clase que representa una pared en el tablero del juego.
 */
public class Wall extends GameObject{
	
	private Position pos;
	
	/**
	 * Constructor de la clase Wall.
	 * 
	 * @param col Columna de la posición de la wall.
	 * @param row Fila de la posición de la wall.
	 */
	public Wall(Position pos, Game game){
		super(pos, game);
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
	 * Actualiza el estado de la pared.
	 * No hace nada en el caso del objeto wall.
	 */
	@Override
	public void update() {}

	@Override
	public boolean isSolid() {
		return false;
	}
}
