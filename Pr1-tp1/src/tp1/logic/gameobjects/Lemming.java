package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.ParachuterRole;
import tp1.logic.lemmingRoles.WalkerRole;

/**
 * Clase que representa un lemming en el juego, que se mueve y interactúa con el entorno.
 */
public class Lemming extends GameObject{

	private Direction dir;
	private int fall_force;
	private LemmingRole role;
	
	/**
	 * Constructor de la clase Lemming.
	 * 
	 * @param pos La posición inicial del lemming.
	 * @param game El juego en el que está el lemming.
	 */
	public Lemming(Position pos, Game game) {
		super(pos, game);
		dir = Direction.RIGHT;
		fall_force = 0;
		role = new ParachuterRole(); //cuando lo quites, quita el import
	}
	
	/**
	 * Actualiza el estado del lemming en cada ciclo del juego.
	 * Si el lemming está vivo, verifica si ha llegado a la puerta de salida o si debe moverse.
	 */
	@Override
	public void update() {
		if(!isOut()) role.play(this);
		else escape();
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
			if(role.manageLanding(this)) die();
			else {
				walk();
				fall_force = 0;
			}
		}
		
		if(isAtVoid()) die();
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
	 * Hace que el lemming caiga a la posición inmediatamente abajo.
	 */
	public void fall() {		
		updatePosition(Direction.DOWN);
		fall_force++;
	}
	
	/**
	 * Hace que el lemming camine en la dirección actual.
	 * Cambia la dirección si hay una pared o si el lemming está en el borde.
	 */
	protected void walk() {
		updatePosition(dir);
		if(isWallAtPos() || isAtBorder()) {
			dir = dir.changeDirection();
			updatePosition(dir);
		}
	}
	
	public void setRole(LemmingRole role) {
		this.role = role;
	}
	
	public void disableRole() {
		role = new WalkerRole();
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

	//------------------------------------------------------------------------------
	//TEMPORAL
	
	@Override
	public boolean isSolid() {
		return false;
	}

	@Override
	public boolean isExit() {
		return false;
	}

	public int getFall_force() {
		return fall_force;
	}
	
	//------------------------------------------------------------------------------
	//TEMPORAL
	
}
