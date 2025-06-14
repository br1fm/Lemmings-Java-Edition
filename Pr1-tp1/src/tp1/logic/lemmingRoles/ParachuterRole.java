package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

/**
 * Clase que presenta el rol de un lemming con paracaídas. 
 * Este rol permite que el lemming caiga de manera controlada, como si estuviera usando un paracaídas.
 * 
 */
public class ParachuterRole extends AbstractRole{
	
	private static final String NAME = Messages.ROLE_PARACHUTER_NAME;
	private static final String SHORTCUT = Messages.ROLE_PARACHUTER_SHORTCUT;
	private static final String DETAILS = Messages.ROLE_PARACHUTER_DETAILS;
	
    /**
     * Constructor de ParachuterRole.
     * Inicializa el rol con el nombre, atajo y detalles definidos en las constantes.
     */
	public ParachuterRole() {
		super(NAME, SHORTCUT, DETAILS);
	}

	 /**
     * Define el comportamiento del lemming cuando tiene el rol de paracaidista.
     * 
     * @param lemming El lemming que tiene este rol.
     */
	@Override
	public void play(Lemming lemming) {
		if(lemming.isOnGround()) {
			lemming.disableRole();
			lemming.walk();
		}
		else{
			lemming.fall();
			lemming.resetFall_force();
		}
	}

	 /**
     * Devuelve el ícono asociado con este rol de lemming.
     * 
     * @param lemming El lemming que tiene este rol.
     * @return El ícono que representa al lemming con este rol (un paracaídas).
     */
	@Override
	public String getIcon(Lemming lemming) {
		return Messages.PARACHUTE;
	}

	@Override
	public String helpText() {
		return DETAILS;
	}

}
