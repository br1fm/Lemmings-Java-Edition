package tp1.logic.gameobjects;

import tp1.logic.Position;

public class Wall {
	
	private Position pos;
	
	public Wall(int col, int row) {
		pos = new Position(col, row);
	}
	
	@Override
	public String toString() {
		return "▓";
	}
	
	public Boolean isAtPosition(int col, int row) {
		Position comparison = new Position(col,row);
		return (comparison == pos);
	}

	public void update() {
		// TODO Auto-generated method stub
	}
}
