package tp1.logic.lemmingRoles;

import tp1.logic.Direction;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class DownCaverRole extends AbstractRole{

	private static final String NAME = Messages.ROLE_DOWN_CAVER_NAME;
	private static final String SHORTCUT = Messages.ROLE_DOWN_CAVER_SHORTCUT;
	private static final String DETAILS = Messages.ROLE_DOWN_CAVER_DETAILS;
	
	private boolean hasCaved;
	
	public DownCaverRole() {
		super(NAME, SHORTCUT, DETAILS);
		hasCaved = false;
	}
	
	private void excavate() {
		hasCaved = true;
	}

	@Override
	public void play(Lemming lemming) {
		if(!lemming.interact()) {
			lemming.disableRole();
			lemming.move();
		}
		else lemming.resetFall_force();
	}

	@Override
	public String getIcon(Lemming lemming) {
		return Messages.LEMMING_DOWN_CAVER;
	}

	@Override
	public void manageFall(Lemming lemming) {}

	@Override
	public boolean manageLanding(Lemming lemming) { return false; }
	
	@Override
    public boolean interactWith(Wall wall, Lemming owner){
		
		if(owner.isOnRelativePos(wall.getPos(), Direction.DOWN)) {
			wall.die();
			owner.fall();
			excavate();
			return true;
		}
		
		else return false;
    }
	
}
