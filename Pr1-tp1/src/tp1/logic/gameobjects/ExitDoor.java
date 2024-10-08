package tp1.logic.gameobjects;

import tp1.logic.Position;

public class ExitDoor {
	
	Position pos;
	
	public ExitDoor(Position pos) {
		this.pos = pos;
	}
	
	public ExitDoor() {
		
	}
	
	@Override
	public String toString() {
		return "🚪";
	}
	
	public Boolean isAtPosition(Position comparison) {
		return (comparison.equals(pos));
	}
	
}
