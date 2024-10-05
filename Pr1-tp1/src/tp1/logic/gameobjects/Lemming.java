package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.WalkerRole;

public class Lemming {

	//TODO fill your code
	private Position pos;
	private Direction dir;
	private boolean is_alive, is_out;
	private int fall_force;
	private WalkerRole role;
	private Game game;
	
	public Lemming(Position pos, Game game) {
		this.game = game;
		this.pos = pos;
		dir = Direction.RIGHT;
		is_alive = true;
		is_out = false;
		fall_force = pos.getRow();
		role = new WalkerRole();
	}
	
	/**
	 *  Implements the automatic update	
	 */
	
	/* TENER EN CUENTA 1: si está cayendo aparecerá justo encima del suelo para en la siguiente iteración aterrizar,
	 *  que consistirá en morir o dar un paso.*/
	
	/*TENER EN CUENTA 2: Para saber si están cayendo o si mueren en una caída también es necesario delegar en su acción
	 * (acción = play del role)*/
	public void update() {
		if(is_alive) {
			if(game.isDoorAtPos(pos)) is_out = true;
			else role.play(this);
		}
	}
	
	public void move() {
			
		if(!isOnGround()){
			role.manageFall(this);
		}
		
		else{
			if(role.manageLanding(pos.getRow() - fall_force)) die();
			else {
				walk();
				fall_force = pos.getRow();
			}
		}
		
		if(pos.isAtVoid()) die();
	}
	
	
	public Direction getDirection() {
		return dir;
	}
	
	public boolean isAlive() {
		return is_alive;
	}
	
	public boolean isOut() {
		return is_out;
	}
	
	public Boolean isAtPosition(Position comparison) {
		return (comparison.equals(pos));
	}
	
	private Boolean isOnGround() {
		return (game.isWallAtPos(new Position(pos.getCol() + Direction.DOWN.getX(), 
				pos.getRow() + Direction.DOWN.getY())));
	}
	
	private void die() {
		is_alive = false;
	}
	
	public void fall() {
		pos = new Position(pos.getCol() + Direction.DOWN.getX(), 
				pos.getRow() + Direction.DOWN.getY());
	}
	
	private void walk() {
		if(game.isWallAtPos(new Position(pos.getCol() + dir.getX(), 
				pos.getRow() + dir.getY())) || pos.isAtBorder()) {
			if(dir.equals(Direction.LEFT)) dir = Direction.RIGHT;
			else dir = Direction.LEFT;
		}
		pos = new Position(pos.getCol() + dir.getX(), 
				pos.getRow() + dir.getY());
	}
	
	@Override
	
	public String toString() {
		return role.getIcon(this);
	}
	
	
}
