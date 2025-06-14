package tp1.logic.lemmingRoles;
import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

public class BlockerRole extends AbstractRole{

	private static final String NAME = Messages.ROLE_BLOCKER_NAME;
	private static final String SHORTCUT = Messages.ROLE_BLOCKER_SHORTCUT;
	private static final String DETAILS = Messages.ROLE_BLOCKER_DETAILS;
	
	BlockerRole() {
		super(NAME, SHORTCUT, DETAILS);
	}

	@Override
	public void start(Lemming lemming) {
		lemming.setRole(this);
	}
	
	@Override
	public void play(Lemming lemming) {
		if(!lemming.isOnGround()) lemming.fall();
	}

	@Override
	public String getIcon(Lemming lemming) {
		return Messages.LEMMMING_BLOCKER;
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	
}
