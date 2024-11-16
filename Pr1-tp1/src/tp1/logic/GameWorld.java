package tp1.logic;

import tp1.logic.gameobjects.GameItem;

public interface GameWorld {

	boolean isAtVoid(Position pos);
	boolean isWallAtPos(Position pos); //Quitar
	boolean isAtBorder(Position pos);
	boolean isDoorAtPos(Position pos); //Quitar 
	public boolean receiveInteractionsFrom(GameItem obj);
	public boolean isInBoard(Position pos);
	
}
