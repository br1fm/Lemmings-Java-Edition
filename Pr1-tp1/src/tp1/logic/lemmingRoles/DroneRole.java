package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

public class DroneRole extends AbstractRole{

	private static final String NAME = Messages.ROLE_DRONE_NAME;
	private static final String SHORTCUT = Messages.ROLE_DRONE_SHORTCUT;
	private static final String DETAILS = Messages.ROLE_DOWN_DRONE_DETAILS;
	
	
	DroneRole(String name, String shortcut, String details) {
		super(NAME, SHORTCUT, DETAILS);
	}

	@Override
	public void play(Lemming lemming) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getIcon(Lemming lemming) {
		// TODO Auto-generated method stub
		return null;
	}

}
