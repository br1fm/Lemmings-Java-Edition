package tp1.logic;

public interface GameWorld {

	boolean isAtVoid(Position pos);
	boolean isWallAtPos(Position pos); //Quitar
	boolean isAtBorder(Position pos);
	boolean isDoorAtPos(Position pos); //Quitar 

}
