package tp1.logic.lemmingRoles;

import tp1.logic.Direction;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

/**
 * Clase que presenta el rol de un lemming que puede cavar hacia abajo. 
 * Este rol permite que el lemming se desplace hacia abajo, destruyendo las paredes normales que se encuentren en su camino.
 * 
 */
public class DownCaverRole extends AbstractRole{

	private static final String NAME = Messages.ROLE_DOWN_CAVER_NAME;
	private static final String SHORTCUT = Messages.ROLE_DOWN_CAVER_SHORTCUT;
	private static final String DETAILS = Messages.ROLE_DOWN_CAVER_DETAILS;
	
	 /**
     * Constructor de DownCaverRole.
     * Inicializa el rol con el nombre, atajo y detalles definidos en las constantes.
     */
	public DownCaverRole() {
		super(NAME, SHORTCUT, DETAILS);
	}
	
    /**
     * Define el comportamiento del lemming cuando está en el rol de DownCaver.
     * 
     * @param lemming El lemming que tiene este rol.
     */
	@Override
	public void play(Lemming lemming) {
		if(!lemming.interact()) {
			lemming.disableRole();
			lemming.move();
		}
		else lemming.resetFall_force();
	}
	
    /**
     * Devuelve el ícono asociado con este rol de lemming.
     * 
     * @param lemming El lemming que tiene este rol.
     * @return El ícono que representa al lemming con este rol.
     */
	@Override
	public String getIcon(Lemming lemming) {
		return Messages.LEMMING_DOWN_CAVER;
	}

	@Override
	public void manageFall(Lemming lemming) {}

	@Override
	public boolean manageLanding(Lemming lemming) { return false; }
	
    /**
     * Define cómo el lemming interactúa con una pared cuando tiene el rol de DownCaver.
     * Si la pared está debajo del lemming, la pared es destruida y el lemming cae a través de ella.
     * 
     * @param wall La pared con la que el lemming interactúa.
     * @param owner El lemming que tiene este rol.
     * @return {@code true} si la pared es destruida, {@code false} si no.
     */
	@Override
    public boolean interactWith(Wall wall, Lemming owner){
		
		if(owner.isOnRelativePos(wall.getPos(), Direction.DOWN)) {
			wall.die();
			owner.fall();
			return true;
		}
		
		else return false;
    }
	
	
}
