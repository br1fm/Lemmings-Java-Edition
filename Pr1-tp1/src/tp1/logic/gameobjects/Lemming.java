package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.WalkerRole;

public class Lemming {

	//TODO fill your code
	private Position pos;
	private Direction dir;
	private boolean is_alive;
	private int fall_force;
	private WalkerRole role;
	private Game game;
	private boolean falling;
	
	public Lemming(Position pos, Game game) {
		this.game = game;
		this.pos = pos;
		dir = Direction.RIGHT;
		is_alive = true;
		falling = false;
		fall_force = 0;
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
			role.play(this);
		}
	}
	
	public void move() {
		
		if(game.isWallAtPos(new Position(pos.getCol() + Direction.DOWN.getX(), 
					pos.getRow() + Direction.DOWN.getY()))){
			
			if(fall_force > 2) {
				die();
			}
			else {
				if(game.isWallAtPos(new Position(pos.getCol() + dir.getX(), 
						pos.getRow() + dir.getY()))) {
					if(dir.equals(Direction.LEFT)) dir = Direction.RIGHT;
					else dir = Direction.LEFT;
				}
				pos = new Position(pos.getCol() + dir.getX(), 
						pos.getRow() + dir.getY());
				falling = false;
				fall_force = 0;
			}
		}
		
		else{
			pos = new Position(pos.getCol() + Direction.DOWN.getX(), 
					pos.getRow() + Direction.DOWN.getY());
			falling = true;
			fall_force++;
		}
	}
	
	public Direction getDirection() {
		return dir;
	}
	
	public Boolean isAtPosition(Position comparison) {
		return (comparison.equals(pos));
	}
	
	private void die() {
		is_alive = false;
	}
	
	@Override
	
	public String toString() {
		return role.getIcon(this);
	}
	
	
}
