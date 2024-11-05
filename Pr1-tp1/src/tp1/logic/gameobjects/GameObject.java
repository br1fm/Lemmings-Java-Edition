package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.logic.Direction;
import tp1.logic.Game;

/*Todos los GameObject tienen al menos un atributo para almacenar su posición en el juego 
 * y otro booleano que indica si el objeto está vivo o no, y métodos auxiliares para 
 * manipular esa posición o para saber si el objeto está vivo o no. Por último, 
 * necesitaremos el siguiente método:*/

/*
    La clase abstracta GameObject tendrá los atributos y métodos básicos para 
    controlar la posición en el tablero y una referencia a la clase Game.
    De GameObject heredarán las clases Lemming, Wall y ExitDoor.
*/

public abstract class GameObject {

	private Position pos;
	private boolean is_alive;
	private Game game;
	
	GameObject(Position pos, Game game){
		this.game = game;
		this.pos = pos;
		is_alive = true;
	}
	
	public abstract void update();
	
	public abstract boolean isSolid();
	
	public boolean isAlive() {
		return is_alive;
	}
	
	/**
	 * Hace que el lemming camine en la dirección actual.
	 * Cambia la dirección si hay una pared o si el lemming está en el borde.
	 */
	protected void walk(Direction dir) {
		Position next_pos = pos.nextPosition(dir);
		if(game.isWallAtPos(next_pos) || game.isAtBorder(next_pos)) {
			dir = dir.changeDirection(); 
		}
		else {
		pos = next_pos;
		}
	}
	
	/**
	 * Comprueba si el lemming está en el suelo.
	 * 
	 * @return true si el lemming está en el suelo, false en caso contrario.
	 */
	protected Boolean isOnGround() {
		return (game.isWallAtPos(pos.nextPosition(Direction.DOWN)));
	}
	
	protected void die() {
		is_alive = false;
		
	}
	
	/**
	 * Comprueba si el lemming está en la posición especificada.
	 * 
	 * @param comparison La posición con la que se va a comparar.
	 * @return true si el lemming está en la posición proporcionada, false en caso contrario.
	 */
	public Boolean isAtPosition(Position comparison) {
		return (comparison.equals(pos));
	}
	
	/**
	 * Llama a la función isAtVoid de {@link Game#isAtVoid(dir)}
	 * 
	 * @return true si la función de Game es verdadera, false en caso contrario.
	 */
	protected boolean isAtVoid() {
		return game.isAtVoid(pos);
	}
	
}
