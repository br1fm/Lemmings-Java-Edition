package tp1.logic.lemmingRoles;

import tp1.logic.Direction;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class CaverRole extends AbstractRole{

	private static final String NAME = Messages.ROLE_CAVER_NAME;
	private static final String SHORTCUT = Messages.ROLE_CAVER_SHORTCUT;
	private static final String DETAILS = Messages.ROLE_CAVER_DETAILS;
	
	private Direction dir;
	private boolean hasCaved;
	
	CaverRole() {
		super(NAME, SHORTCUT, DETAILS);
		hasCaved = false;
	}
	
	CaverRole(Direction dir){
		super(NAME, SHORTCUT, DETAILS); 
		this.dir = dir;
		hasCaved = false;
	}

	@Override
    public LemmingRole parse(String[] role){
		if(role[1].equalsIgnoreCase(NAME) || role[1].equalsIgnoreCase(SHORTCUT)) {
			dir = Direction.NONE;
			dir = dir.getDirection(role[4]);
			if(dir != Direction.NONE) return new CaverRole();
		}
		return null;
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
		
		else {
		lemming.updatePosition(dir);
		}
		
	}

	@Override
	public String getIcon(Lemming lemming) {
		String aux;
		switch(dir) {
			case Direction.RIGHT:
			aux = "➡️";
				break;
			case Direction.RIGHT_DOWN:
			aux = "↘️";	
			break;
			case Direction.RIGHT_UP:
			aux = "↗️";
				break;
			case Direction.LEFT:
			aux = "⬅️";
				break;
			case Direction.LEFT_DOWN:
			aux = "↙️";
				break;
			case Direction.LEFT_UP:
			aux = "↖️";
				break;
			case Direction.UP:
			aux = "⬆";
				break;
			case Direction.DOWN:
			aux = "⬇️";
				break;
			default:
				aux = null;
			break;
		}
			
		return aux;
	}
	
	@Override
    public boolean interactWith(Wall wall, Lemming owner){
		
		if(owner.isOnRelativePos(wall.getPos(), dir)) {
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
