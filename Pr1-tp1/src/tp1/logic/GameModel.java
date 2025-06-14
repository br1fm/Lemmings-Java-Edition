package tp1.logic;

import tp1.exceptions.GameLoadException;
import tp1.exceptions.OffBoardException;
import tp1.logic.lemmingRoles.LemmingRole;

public interface GameModel {
	public boolean isFinished();
	public void update();
	public void reset();
	public void gameExit();
	public boolean setRole(LemmingRole role, Position comparison) throws OffBoardException;
	public void load(String fileName) throws GameLoadException;
	public void stop(Position pos);
}
