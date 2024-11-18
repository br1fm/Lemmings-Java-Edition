package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

/**
 * Clase que representa una pared de metal en el tablero del juego.
 */
public class MetalWall extends GameObject{

	/**
	 * Constructor de la clase MetalWall.
	 * 
	 * @param pos Posicion del MetalWall.
	 * @param game Interfaz GameWorld.
	 */
	public MetalWall(Position pos, GameWorld game) {
		super(pos, game);
	}

	@Override
	public boolean receiveInteraction(GameItem other) {
		return other.receiveInteraction(this);
	}

	/**
	 * Devuelve un String del MetalWall.
	 * 
	 * @return Un string que representa una pared de metal.
	 */
	@Override
	public String toString() {
		return Messages.METAL_WALL;
	}
		
	@Override
	public boolean isSolid() {
		return true;
	}
	
}
