package tp1.logic.gameobjects;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.logic.GameWorld;
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
	public Wall(Position pos, GameWorld game){
		super(pos, game);
	}
	
	// Constructor de copia profunda
    protected Wall(Wall other) {
        super(other);
    }
	
	//NUEVO
	public Wall() {}

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
	protected String getName() {
		return "wall";
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

	@Override
	protected String getShortcut() {
		return "w";
	}

	@Override
	public GameObject parse(String line, GameWorld game) throws ObjectParseException, OffBoardException {
		try {
		String[] words = line.trim().split("\\s+");
		
		if(!getObjectNameFrom(words[1])) return null;
		else { 
			Position pos = getPositionFrom(words[0], game);
			return new Wall(pos, game);
		}
		}catch(ArrayIndexOutOfBoundsException e) {
			throw new ObjectParseException("Not enough arguments: ");
		}
	}
	
	 @Override
	 public GameObject copy() {
	   return new Wall(this);
	 }

}
