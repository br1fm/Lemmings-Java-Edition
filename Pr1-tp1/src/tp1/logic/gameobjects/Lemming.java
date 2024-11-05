package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.WalkerRole;

/**
 * Clase que representa un lemming en el juego, que se mueve y interactúa con el entorno.
 */
public class Lemming extends GameObject{

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
		super(pos, game);
		dir = Direction.RIGHT;
		is_alive = true;
		is_out = false;
		fall_force = 0;
		role = new WalkerRole();
	}
	
	/**
	 * Actualiza el estado del lemming en cada ciclo del juego.
	 * Si el lemming está vivo, verifica si ha llegado a la puerta de salida o si debe moverse.
	 */
	@Override
	public void update() {
		if(is_alive) { //creo que de esto se puede prescindir en el futuro
			if(game.isDoorAtPos(pos)) is_out = true;
			else role.play(this);
		}
	}
	
	/**
	 * Mueve al lemming según su estado y las condiciones del juego.
	 * Si no está en el suelo, intenta caer; si está en el suelo, puede caminar o morir.
	 */
	public void move() {
		
		isAlive();
		
		if(!isOnGround()){
			role.manageFall(this);
		}
		
		else{
			if(role.manageLanding(fall_force)) die();
			else {
				walk(dir);
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
	 * Comprueba si el lemming ha salido del juego.
	 * 
	 * @return true si el lemming ha salido, false en caso contrario.
	 */
	public boolean isOut() {
		return is_out; //TODO: Cambiar más adelante por una función que aumente en 1 
	}
	
	/**
	 * Hace que el lemming caiga a la posición ìnmediatamente abajo.
	 */
	public void fall() {		
		pos = pos.nextPosition(Direction.DOWN);
		walk(Direction.DOWN);
		fall_force++;
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

	@Override
	public boolean isSolid() {
		return false;
	}
	
}
