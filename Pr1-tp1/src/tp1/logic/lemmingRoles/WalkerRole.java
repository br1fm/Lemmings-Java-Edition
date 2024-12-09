package tp1.logic.lemmingRoles;

import tp1.logic.Direction;
import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

/**
 * Clase que representa el rol de un lemming caminante.
 */
public class WalkerRole extends AbstractRole implements LemmingRole{
	
	private static final String NAME = Messages.ROLE_WALKER_NAME;
	private static final String SHORTCUT = Messages.ROLE_WALKER_SHORTCUT;
	private static final String DETAILS = Messages.ROLE_WALKER_DETAILS;
	
	public WalkerRole() {
		super(NAME, SHORTCUT, DETAILS);
	}
	
	@Override
	public void start(Lemming lemming) {
		lemming.disableRole();
	}
	
	/**
	 * Hace que el lemming realice la acción de su rol.
	 * 
	 * @param lemming El lemming que realizará acción.
	 */
	@Override
    public void play(Lemming lemming) {
    	if(!lemming.isOnGround()) {
    		lemming.fall();
    	}
    	
    	else {
    		if(lemming.getFall_force() > MAX_FALL) lemming.die();
    		else {
    			lemming.walk();
    			lemming.resetFall_force();
    		}
    	}
    	
    }
	
    /**
	 * Devuelve el icono que representa al lemming según su dirección.
	 * 
	 * @param lemming El lemming cuyo icono se va a obtener.
	 * @return Un string que representa el icono del lemming.
	 */
    public String getIcon(Lemming lemming){
    	String str;
    	if(lemming.getDirection() == Direction.LEFT) str = Messages.LEMMING_LEFT; 
    	else str = Messages.LEMMING_RIGHT;
    	return str;
    }
    
    /**
	 * Gestiona el aterrizaje del lemming según la fuerza de la caída.
	 * 
	 * @param fall_force La fuerza de la caída del lemming.
	 * @return true si el lemming supera su fall_force máxima, false en caso contrario.
	 */
    public boolean manageLanding(Lemming lemming) {
    	return (lemming.getFall_force() > MAX_FALL);
    }
    
	
}