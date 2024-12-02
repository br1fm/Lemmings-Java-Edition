package tp1.logic.gameobjects;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

/**
 * Clase que representa la puerta de salida en el tablero del juego.
 */
public class ExitDoor extends GameObject{
	
	//private Position pos;
	

	/**
	 * Constructor de la clase ExitDoor.
	 * 
	 * @param pos Posición de la puerta de salida.
	 */
	public ExitDoor(Position pos, GameWorld game) {
		super(pos, game);
	}
	
	// Constructor de copia profunda
    protected ExitDoor(ExitDoor other) {
        super(other);
    }
	
	//NUEVO
	public ExitDoor() {}

	/**
	 * Devuelve una representación en string de la exit door.
	 * 
	 * @return Una cadena que representa la puerta de salida.
	 */
	@Override
	public String toString() {
		return Messages.EXIT_DOOR;
	}

	@Override
	public boolean isExit() {
		return true;
	}
		
	@Override
	public boolean receiveInteraction(GameItem other) {
		return other.interactWith(this);
	}	
	
	@Override
	protected String getName() {
		return "exitdoor";
	}
	
	@Override
	protected String getShortcut() {
		return "ed";
	}

	@Override
	public GameObject parse(String line, GameWorld game) throws ObjectParseException, OffBoardException {
		
		try {
		String[] words = line.trim().split("\\s+");
		if(!getObjectNameFrom(words[1])) return null;
		else { 
			Position pos = getPositionFrom(words[0], game);
			return new ExitDoor(pos, game);
		}
		}catch(ArrayIndexOutOfBoundsException e) {
			throw new ObjectParseException("Not enough arguments: ");
		}
	}
	
	 @Override
	 public GameObject copy() {
	   return new ExitDoor(this);
	 }
	
}
