package tp1.logic;

import tp1.logic.gameobjects.GameItem;

public interface GameWorld {

	boolean isAtVoid(Position pos);
	boolean isSolidAtPos(Position pos); 
	boolean isAtBorder(Position pos);
	boolean isExitAtPos(Position pos);  
	public boolean receiveInteractionsFrom(GameItem obj);
	public boolean isInBoard(Position pos);
	
}
