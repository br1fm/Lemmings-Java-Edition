package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

public class DownCaverRole extends AbstractRole{

	private static final String NAME = Messages.ROLE_DOWN_CAVER_NAME;
	private static final String SHORTCUT = Messages.ROLE_DOWN_CAVER_SHORTCUT;
	private static final String DETAILS = Messages.ROLE_DOWN_CAVER_DETAILS;
	
	public DownCaverRole() {
		super(NAME, SHORTCUT, DETAILS);
	}

	@Override
	public void play(Lemming lemming) {
		
	}

	@Override
	public String getIcon(Lemming lemming) {
		return Messages.LEMMING_DOWN_CAVER;
	}

	@Override
	public void manageFall(Lemming lemming) {
		lemming.fall();
	}

	@Override
	public boolean manageLanding(Lemming lemming) {
		return (lemming.getFall_force() > MAX_FALL);
	}
	
}
