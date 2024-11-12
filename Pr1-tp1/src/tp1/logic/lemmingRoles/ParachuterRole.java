package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

public class ParachuterRole implements LemmingRole{
	
	private static final String NAME = Messages.ROLE_PARACHUTER_NAME;
	private static final String SHORTCUT = Messages.ROLE_PARACHUTER_SHORTCUT;
	private static final String DETAILS = Messages.ROLE_PARACHUTER_DETAILS;
	
	@Override
	public void start(Lemming lemming) {
		lemming.setRole(this);
	}

	@Override
	public void play(Lemming lemming) {
		lemming.move();
	}

	@Override
	public String getIcon(Lemming lemming) {
		return Messages.PARACHUTE;
	}
	
    /**
	 * Hace que el lemming caiga.
	 * 
	 * @param lemming El lemming que va a caer.
	 */
	@Override
    public void manageFall(Lemming lemming) {
    	lemming.fall();
    }
    
	@Override
	public boolean manageLanding(Lemming lemming) {
		lemming.disableRole();
		return false;
	}

	@Override
	public String helpText() {
		return DETAILS;
	}

	@Override
	public LemmingRole parse(String role) {
		if(role.equalsIgnoreCase(NAME) || role.equalsIgnoreCase(SHORTCUT)){
			return new ParachuterRole();
		}
		return null;
	}
	

}
