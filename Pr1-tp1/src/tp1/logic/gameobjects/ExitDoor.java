package tp1.logic.gameobjects;

import tp1.logic.Game;
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
	public ExitDoor(Position pos, Game game) {
		super(pos, game);
	}
	
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
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	//TEMPORAL
		//------------------------------------------------------------------------------
		
		@Override
		public boolean isSolid() {
			return false;
		}

		@Override
		public boolean isExit() {
			return true;
		}
		
		//------------------------------------------------------------------------------
		//TEMPORAL
	
}
