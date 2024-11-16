package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

/**
 * Clase que representa una pared en el tablero del juego.
 */
public class Wall extends GameObject{
	
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
		return Messages.WALL;
	}
		
	@Override
	public boolean isSolid() {
		return true;
	}
	
	@Override
	public boolean receiveInteraction(GameItem other) {
		return other.interactWith(this);
	}
	
	@Override
	public boolean interactWith(Lemming lemming) {
		return true;
	}

}
