package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.WalkerRole;

/**
 * Clase que representa un lemming en el juego, que se mueve y interactúa con el entorno.
 */
public class Lemming {

	private Position pos;
	private Direction dir;
	private boolean is_alive, is_out;
	private int fall_force;
	private WalkerRole role;
	private Game game;
	
	/**
	 * Constructor de la clase Lemming.
	 * 
	 * @param pos La posición inicial del lemming.
	 * @param game El juego en el que está el lemming.
	 */
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
	 * Actualiza el estado del lemming en cada ciclo del juego.
	 * Si el lemming está vivo, verifica si ha llegado a la puerta de salida o si debe moverse.
	 */
	public void update() {
		if(is_alive) {
			if(game.isDoorAtPos(pos)) is_out = true;
			else role.play(this);
		}
	}
	
	/**
	 * Mueve al lemming según su estado y las condiciones del juego.
	 * Si no está en el suelo, intenta caer; si está en el suelo, puede caminar o morir.
	 */
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
	
	/**
	 * Devuelve la dirección actual del lemming.
	 * 
	 * @return La dirección del lemming.
	 */
	public Direction getDirection() {
		return dir;
	}
	
	/**
	 * Comprueba si el lemming está vivo.
	 * 
	 * @return true si el lemming está vivo, false en caso contrario.
	 */
	public boolean isAlive() {
		return is_alive;
	}
	
	/**
	 * Comprueba si el lemming ha salido del juego.
	 * 
	 * @return true si el lemming ha salido, false en caso contrario.
	 */
	public boolean isOut() {
		return is_out;
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
	 * Comprueba si el lemming está en el suelo.
	 * 
	 * @return true si el lemming está en el suelo, false en caso contrario.
	 */
	private Boolean isOnGround() {
		return (game.isWallAtPos(pos.nextPosition(Direction.DOWN)));
	}
	
	/**
	 * Hace que el lemming muera.
	 * Establece el estado de is_alive a false.
	 */
	private void die() {
		is_alive = false;
	}
	
	/**
	 * Hace que el lemming caiga a la posición ìnmediatamente abajo.
	 */
	public void fall() {		
		pos = pos.nextPosition(Direction.DOWN);
	}
	
	/**
	 * Hace que el lemming camine en la dirección actual.
	 * Cambia la dirección si hay una pared o si el lemming está en el borde.
	 */
	private void walk() {
		Position next_pos = pos.nextPosition(dir);
		if(game.isWallAtPos(next_pos) || game.isAtBorder(next_pos)) {
			dir.changeDirection(dir); //mirar
		}
		else {
		pos = next_pos;
		}
	}
	
	
	/**
	 * Devuelve un String del lemming.
	 * 
	 * @return Un string que representa al lemming según su rol.
	 */
	@Override
	public String toString() {
		return role.getIcon(this);
	}
	
	
}
