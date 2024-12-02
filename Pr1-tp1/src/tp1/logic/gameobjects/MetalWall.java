package tp1.logic.gameobjects;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
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

	// Constructor de copia profunda
    protected MetalWall(MetalWall other) {
        super(other);
    }
	
	//NUEVO
	public MetalWall() {}

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
	
	@Override
	protected String getName() {
		return "metalwall";
	}

	@Override
	protected String getShortcut() {
		return "mw";
	}

	@Override
	public GameObject parse(String line, GameWorld game) throws ObjectParseException, OffBoardException {
		
		try {
		String[] words = line.trim().split("\\s+");
		
		if(!getObjectNameFrom(words[1])) return null;
		else { 
			Position pos = getPositionFrom(words[0], game);
			return new MetalWall(pos, game);
		}
		}catch(ArrayIndexOutOfBoundsException e) {
			throw new ObjectParseException("Not enough arguments: ");
		}
	}
	
	 @Override
	 public GameObject copy() {
	   return new MetalWall(this);
	 }
	
}
