package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;

public class Lemming {

	//TODO fill your code
	private Position pos;
	
	public Lemming(int fila, int columna) {
		pos = new Position(fila, columna);
	}
	
	/**
	 *  Implements the automatic update	
	 */
	public void update() {
		//TODO fill your code
	}

	//CAMBIO: provisional, más adelante cambia de B a B invertida 
	//si va de derecha a izda o de izquierda a derecha.
	@Override
	public String toString() {
		return "B";
	}
	
}
