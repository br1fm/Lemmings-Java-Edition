package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;

public class Lemming {

	//TODO fill your code
	private Position pos;
	private Direction dir;
	private boolean is_alive;
	
	public Lemming(int col, int row) {
		pos = new Position(col, row);
		dir = Direction.RIGHT;
		is_alive = true;
	}
	
	/**
	 *  Implements the automatic update	
	 */
	public void update() {
		//TODO fill your code
	}
	
	public Direction getDirection() {
		return dir;
	}
	
	public Boolean isAtPosition(int col, int row) {
		Position comparison = new Position(col,row);
		return (comparison.equals(pos));
	}

	//CAMBIO: provisional, más adelante cambia de B a B invertida 
	//si va de derecha a izda o de izquierda a derecha.
	@Override
	public String toString() {
		return "B";
	}
	
}
