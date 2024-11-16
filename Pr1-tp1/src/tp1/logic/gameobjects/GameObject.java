package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.Direction;
import tp1.logic.GameWorld;

/*Todos los GameObject tienen al menos un atributo para almacenar su posición en el juego 
 * y otro booleano que indica si el objeto está vivo o no, y métodos auxiliares para 
 * manipular esa posición o para saber si el objeto está vivo o no. Por último, 
 * necesitaremos el siguiente método:*/

/*
    La clase abstracta GameObject tendrá los atributos y métodos básicos para 
    controlar la posición en el tablero y una referencia a la clase Game.
    De GameObject heredarán las clases Lemming, Wall y ExitDoor.
*/

public abstract class GameObject implements GameItem{

	private Position pos;
	private boolean is_alive, is_out;
	private GameWorld game;
	
	GameObject(Position pos, GameWorld game){
		this.game = game;
		this.pos = pos;
		this.is_out = false;
		is_alive = true;
	}
	
	public void update() {};
	
	public boolean isAlive() {
		return is_alive;
	}
	
	public boolean isFreed() {
		return is_out;
	}
	
	protected void escape() {
		is_out = true;
	}
	
	protected void die() {
		is_alive = false;
	}
	
	
	protected Position updatePosition(Direction dir) {
		pos = pos.nextPosition(dir);
		return pos;
	}
	
	/**
	 * Comprueba si el lemming está en el suelo.
	 * 
	 * @return true si el lemming está en el suelo, false en caso contrario.
	 */
	public boolean isOnGround() {
		return (game.isWallAtPos(pos.nextPosition(Direction.DOWN)));
	}
	
	/**
	 * Comprueba si el lemming está en la posición especificada.
	 * 
	 * @param pos La posición con la que se va a comparar.
	 * @return true si el lemming está en la posición proporcionada, false en caso contrario.
	 */
	public boolean isInPosition(Position pos) {
		return (pos.equals(this.pos));
	}
	
	/**
	 * Llama a la función isAtVoid de {@link Game#isAtVoid(Position pos)}
	 * 
	 * @return true si la función de Game es verdadera, false en caso contrario.
	 */
	public boolean isAtVoid() {
		return game.isAtVoid(pos);
	}

	public boolean isWallAtPos() {
		return game.isWallAtPos(pos);
	}
	
	public boolean isAtBorder() {
		return game.isAtBorder(pos);
	}
	
	public boolean isOut() {
		return game.isDoorAtPos(pos);
	}
	
	public boolean setRole(LemmingRole role) {
		return false;
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public boolean isExit() {
		return false;
	}
	
	public Position getPos() {
		return pos;
	}
	
	@Override
	public boolean interactWith(Lemming lemming) { return false; }
	@Override
	public boolean interactWith(Wall wall) { return false; }
	@Override
	public boolean interactWith(ExitDoor door) { return false; }
	
}
