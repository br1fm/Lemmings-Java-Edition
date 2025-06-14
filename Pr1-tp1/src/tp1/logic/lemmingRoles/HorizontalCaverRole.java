package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class HorizontalCaverRole extends AbstractRole{
	
	private static final String NAME = Messages.ROLE_HORIZONTAL_CAVER_NAME;
	private static final String SHORTCUT = Messages.ROLE_HORIZONTAL_CAVER_SHORTCUT;
	private static final String DETAILS = Messages.ROLE_HORIZONTAL_CAVER_DETAILS;
	
	private boolean hasCaved;
	
	public HorizontalCaverRole() {
		super(NAME, SHORTCUT, DETAILS);
		hasCaved = false;
	}
	
	@Override
	public void play(Lemming lemming) {
		
		if(!hasCaved) {
			lemming.disableRole();
			
			if(!lemming.isOnGround()) {
				lemming.fall();
				lemming.resetFall_force();
			}
			
			else lemming.walk();
		}
		
	}

	@Override
	public String getIcon(Lemming lemming) {
		return Messages.LEMMING_HORIZONTAL_CAVER;
	}
	
	@Override
    public boolean interactWith(Wall wall, Lemming owner){
		
		if(owner.isOnRelativePos(wall.getPos(), owner.getDirection()) && owner.isOnGround()) {
			wall.die();
			hasCaved = true;
			return true;
		}
		
		else {
			hasCaved = false;
			return false;
		}
    }
	
}
