package tp1.logic;

import tp1.logic.lemmingRoles.LemmingRole;

public interface GameModel {
	public boolean isFinished();
	public void update();
	public void reset();
	public void gameExit();
	public boolean setRole(LemmingRole role, Position comparison);
}
