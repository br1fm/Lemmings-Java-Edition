package tp1.logic;

public interface GameWorld {

	boolean isAtVoid(Position pos);
	boolean isWallAtPos(Position pos);
	boolean isAtBorder(Position pos);
	boolean isDoorAtPos(Position pos);

}
