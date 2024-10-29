package tp1.logic.lemmingRoles;

import tp1.logic.Direction;
import tp1.logic.gameobjects.Lemming;

/**
 * Clase que representa el rol de un lemming caminante.
 */
public class WalkerRole {
	
	private final int MAX_FALL = 2;
	
	/**
	 * Hace que el lemming realice la acción de su rol.
	 * 
	 * @param lemming El lemming que realizará acción.
	 */
    public void play(Lemming lemming) {
    	lemming.move();
    }
    
    /**
	 * Devuelve el icono que representa al lemming según su dirección.
	 * 
	 * @param lemming El lemming cuyo icono se va a obtener.
	 * @return Un string que representa el icono del lemming.
	 */
    public String getIcon(Lemming lemming){
    	String str;
    	if(lemming.getDirection() == Direction.LEFT) str = "ᗺ";
    	else str = "B";
    	return str;
    }
    
    /**
	 * Gestiona el aterrizaje del lemming según la fuerza de la caída.
	 * 
	 * @param fall_force La fuerza de la caída del lemming.
	 * @return true si el lemming supera su fall_force máxima, false en caso contrario.
	 */
    public boolean manageLanding(int fall_force) {
    	return (fall_force > MAX_FALL);
    }
    
    /**
	 * Hace que el lemming caiga.
	 * 
	 * @param lemming El lemming que va a caer.
	 */
    public void manageFall(Lemming lemming) {
    	lemming.fall();
    }
    
}